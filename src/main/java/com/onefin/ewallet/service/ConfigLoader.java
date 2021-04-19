package com.onefin.ewallet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Configuration
@Service
public class ConfigLoader {
	@Value("${vnpay.onefinPrivateKey}")
	private String onefinPrivateKey;

	@Value("${vnpay.onefinPrivateKey}")
	private String vtbPublicKey;

	@Value("${vnpay.partnerCode}")
	private String partnerCode;

	@Value("${vnpay.vnpayPublicKey}")
	private String vnpayPublicKey;
}
