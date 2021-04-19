package com.onefin.ewallet.service;

import com.onefin.ewallet.common.EncryptUtil;
import com.onefin.ewallet.model.SoftSpaceTopupMobileReq;
import com.onefin.ewallet.vnpaySoapWebService.Topup;
import com.onefin.ewallet.vnpaySoapWebService.TopupRequestType;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;
import com.onefin.ewallet.vnpaySoapWebService.VnpSrvSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

@Service
public class HTTPRequestUtilImpl implements IHTTPRequestUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(HTTPRequestUtilImpl.class);

	@Autowired
	private ConfigLoader configLoader;

	@Autowired
	private EncryptUtil encryptUtil;

	private final VnpSrvSoap vnpaySoapWebService;

	public HTTPRequestUtilImpl() throws MalformedURLException {
		assert false;
		configLoader = new ConfigLoader();
		String vnpayUrl = configLoader.getSoapUrl();
		LOGGER.info(vnpayUrl);
		LOGGER.info(vnpayUrl);
		URL url = new URL(vnpayUrl);

		//1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
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
		String SignRawStr = String.format("%s-%d-%d-%s-%s", data.getMobileNo(), data.getAmount(), data.getTrace(), data.getLocalDateTime(), configLoader.getPartnerCode());

		String signedData = vnpaySign(SignRawStr);
		topupRequestType.setSign(signedData);

		LOGGER.debug("signedData: {}", signedData);
//		======================================================

		Topup topup = new Topup();
		topup.setTopupRequest(topupRequestType);

		TopupResponse topupResponse = vnpaySoapWebService.topupMobile(topup);

		LOGGER.debug("TopupMobile getRespCode: {}", topupResponse.getTopupReturn().getRespCode());
		String expectResponseSignStr = String.format(
		        "%s-%s-%s-%s-%s-%s-%s",
				topupResponse.getTopupReturn().getRespCode(),
				topupResponse.getTopupReturn().getMobileNo(),
				topupResponse.getTopupReturn().getTrace(),
				topupResponse.getTopupReturn().getBalance(),
				topupResponse.getTopupReturn().getAmount(),
				topupResponse.getTopupReturn().getLocalDateTime(),
				topupResponse.getTopupReturn().getVnPayDateTime()
        );

		// validate signature
		if (!verifyVNPaySignature(expectResponseSignStr, topupResponse.getTopupReturn().getSign())) {
			LOGGER.error("== sendTopupMobile Verify signature fail");
		}

		return topupResponse;
	}


}
