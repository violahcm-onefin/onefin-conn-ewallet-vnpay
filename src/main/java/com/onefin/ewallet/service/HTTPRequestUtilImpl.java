package com.onefin.ewallet.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onefin.ewallet.common.EncryptUtil;
import com.onefin.ewallet.model.SMSBrandName;
import com.onefin.ewallet.model.SoftSpaceTopupMobileReq;
import com.onefin.ewallet.vnpaySoapWebService.Topup;
import com.onefin.ewallet.vnpaySoapWebService.TopupRequestType;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;
import com.onefin.ewallet.vnpaySoapWebService.VnpSrvSoap;

@Service
public class HTTPRequestUtilImpl implements IHTTPRequestUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(HTTPRequestUtilImpl.class);

	@Autowired
	private ConfigLoader configLoader;

	@Autowired
	private EncryptUtil encryptUtil;

	private VnpSrvSoap vnpaySoapWebService;
	
	@Autowired
	@Qualifier("VnpayAirtimeService")
	private vn.vnpay.vntopup.VnpSrvSoap vnpSrvSoap;

	@Autowired
	public IVNpayService IVNpayService;

	@PostConstruct
	public void populateMovieCache() throws MalformedURLException {
		String vnpayUrl = configLoader.getSoapUrl();
		URL url = new URL(vnpayUrl);

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://www.vnpay.vn/VnTopup/", "VnpSrv");

		javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
		vnpaySoapWebService = service.getPort(VnpSrvSoap.class);
	}

	private String vnpaySign(String input) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		PrivateKey privateKeyOneFin = encryptUtil.readPrivateKey(configLoader.getOnefinPrivateKey());
		String signedData = encryptUtil.sign(input, privateKeyOneFin);
		return signedData;
	}

	private boolean verifyVNPaySignature(String data, String signature) throws CertificateException, IOException {
		PublicKey publicKeyVietin = encryptUtil.readPublicKey2(configLoader.getVnpayPublicKey());
		return encryptUtil.verifySignature(data, signature, publicKeyVietin);
	}

	@Override
	public TopupResponse sendTopupMobile(SoftSpaceTopupMobileReq data) throws Exception {
		TopupRequestType topupRequestType = new TopupRequestType();

		topupRequestType.setMobileNo(data.getMobileNo());
		topupRequestType.setAmount(data.getAmount());
		topupRequestType.setTrace(data.getTrace());
		topupRequestType.setLocalDateTime(data.getLocalDateTime());
		topupRequestType.setPartnerCode(configLoader.getPartnerCode());

//		======================================================
		String SignRawStr = String.format("%s-%d-%d-%s-%s", data.getMobileNo(), data.getAmount(), data.getTrace(),
				data.getLocalDateTime(), configLoader.getPartnerCode());

		String signedData = vnpaySign(SignRawStr);
		topupRequestType.setSign(signedData);

		LOGGER.debug("signedData: {}", signedData);
//		======================================================

		Topup topup = new Topup();
		topup.setTopupRequest(topupRequestType);

		TopupResponse topupResponse = vnpaySoapWebService.topupMobile(topup);

		LOGGER.debug("TopupMobile getRespCode: {}", topupResponse.getTopupReturn().getRespCode());
		String expectResponseSignStr = String.format("%s-%s-%s-%s-%s-%s-%s",
				topupResponse.getTopupReturn().getRespCode(), topupResponse.getTopupReturn().getMobileNo(),
				topupResponse.getTopupReturn().getTrace(), topupResponse.getTopupReturn().getBalance(),
				topupResponse.getTopupReturn().getAmount(), topupResponse.getTopupReturn().getLocalDateTime(),
				topupResponse.getTopupReturn().getVnPayDateTime());

		// validate signature
		if (!verifyVNPaySignature(expectResponseSignStr, topupResponse.getTopupReturn().getSign())) {
			LOGGER.error("== sendTopupMobile Verify signature fail");
		}

		return topupResponse;
	}

	@Override
	public Object sendSMSBrandName(SMSBrandName data) throws Exception {
		String url = configLoader.getSmsUrl();
		LOGGER.info("== Send request to VNPAY SMS {} ", url);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity entity = new HttpEntity(data, headers);
		ResponseEntity<String> resp = null;
		try {
			resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		} catch (Exception e) {
			LOGGER.error("== Error response from VNPAY SMS!!!", e);
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			LOGGER.info("== Response - " + resp.getBody());
			Map<String, Object> result = (Map<String, Object>) IVNpayService.convertString2Map(resp.getBody(),
					Map.class);
			return result;
		} catch (Exception e) {
			LOGGER.error("== Can't parse result from VNPAY SMS!!!", e);
			return null;
		}
	}

	@Override
	public vn.vnpay.vntopup.TopupResponse sendTopupMobileV2(SoftSpaceTopupMobileReq data) throws Exception {
		vn.vnpay.vntopup.TopupRequestType topupRequestType = new vn.vnpay.vntopup.TopupRequestType();

		topupRequestType.setMobileNo(data.getMobileNo());
		topupRequestType.setAmount(data.getAmount());
		topupRequestType.setTrace(data.getTrace());
		topupRequestType.setLocalDateTime(data.getLocalDateTime());
		topupRequestType.setPartnerCode(configLoader.getPartnerCode());

//		======================================================
		String SignRawStr = String.format("%s-%d-%d-%s-%s", data.getMobileNo(), data.getAmount(), data.getTrace(),
				data.getLocalDateTime(), configLoader.getPartnerCode());

		String signedData = vnpaySign(SignRawStr);
		topupRequestType.setSign(signedData);

		LOGGER.debug("signedData: {}", signedData);
//		======================================================

		vn.vnpay.vntopup.Topup topup = new vn.vnpay.vntopup.Topup();
		topup.setTopupRequest(topupRequestType);

		vn.vnpay.vntopup.TopupResponse topupResponse = vnpSrvSoap.topupMobile(topup);

		LOGGER.debug("TopupMobileV2 getRespCode: {}", topupResponse.getTopupReturn().getRespCode());
		String expectResponseSignStr = String.format("%s-%s-%s-%s-%s-%s-%s",
				topupResponse.getTopupReturn().getRespCode(), topupResponse.getTopupReturn().getMobileNo(),
				topupResponse.getTopupReturn().getTrace(), topupResponse.getTopupReturn().getBalance(),
				topupResponse.getTopupReturn().getAmount(), topupResponse.getTopupReturn().getLocalDateTime(),
				topupResponse.getTopupReturn().getVnPayDateTime());

		// validate signature
		if (!verifyVNPaySignature(expectResponseSignStr, topupResponse.getTopupReturn().getSign())) {
			LOGGER.error("== sendTopupMobileV2 Verify signature fail");
		}

		return topupResponse;
	}
}
