package com.onefin.ewallet.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Objects;

import com.onefin.ewallet.model.SoftSpaceTopupMobileReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onefin.ewallet.common.EncryptUtil;
import com.onefin.ewallet.common.OneFinConstants;
import com.onefin.ewallet.model.PaymentByOTP;
import com.onefin.ewallet.model.PaymentByToken;
import com.onefin.ewallet.model.ProviderInquiry;
import com.onefin.ewallet.model.RegisterOnlinePay;
import com.onefin.ewallet.model.TokenIssue;
import com.onefin.ewallet.model.TokenIssuePayment;
import com.onefin.ewallet.model.TokenRevokeReIssue;
import com.onefin.ewallet.model.TransactionInquiry;
import com.onefin.ewallet.model.VerifyPin;
import com.onefin.ewallet.model.Withdraw;
import com.onefin.service.BaseService;

@Service
public class VNpayServiceImpl extends BaseService implements IVNpayService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VNpayServiceImpl.class);

	@Autowired
	private ConfigLoader configLoader;

	@Autowired
	private IMessageUtil iMessageUtil;

	@Autowired
	private EncryptUtil encryptUtil;

	@Override
	public SoftSpaceTopupMobileReq buildVNPayTopupMobile(SoftSpaceTopupMobileReq data)
			throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		data.setProviderId(configLoader.getVietinProviderId());
		data.setMerchantId(configLoader.getVietinMerchantId());
		data.setVersion(configLoader.getVietinVersion());

		String dataSign = data.getCardNumber() + data.getCardIssueDate() + data.getCardHolderName()
				+ data.getProviderCustId() + data.getCustPhoneNo() + data.getCustIDNo() + data.getClientIP()
				+ data.getTransTime() + data.getRequestId() + data.getProviderId() + data.getMerchantId()
				+ data.getChannel() + data.getVersion() + data.getLanguage() + data.getMac();

		LOGGER.info("== Before Sign Data - " + dataSign);
		String signData = viettinSign(dataSign);
		data.setSignature(signData);
		LOGGER.info("== After Sign Data - " + signData);
		return data;
	}

}
