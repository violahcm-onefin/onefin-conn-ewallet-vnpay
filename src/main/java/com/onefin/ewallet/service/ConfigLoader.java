package com.onefin.ewallet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Configuration
@Service
public class ConfigLoader {
	@Value("${vnpay.airtimeTopup.onefinPrivateKey}")
	private String onefinPrivateKey;

	@Value("${vnpay.airtimeTopup.vnpayPublicKey}")
	private String vnpayPublicKey;

	@Value("${vnpay.airtimeTopup.soapUrl}")
	private String soapUrl;

	@Value("${vnpay.airtimeTopup.partnerCode}")
	private String partnerCode;

	@Value("${vnpay.smsBrandName.url}")
	private String smsUrl;

	@Value("${vnpay.smsBrandName.partnerCode}")
	private String smsPartnerCode;

	@Value("${vnpay.smsBrandName.sercretKey}")
	private String smsSercretKey;

	@Value("${vnpay.smsBrandName.keyword}")
	private String smsKeyword;

	@Value("${vnpay.smsBrandName.brandname}")
	private String smsBrandname;

}
