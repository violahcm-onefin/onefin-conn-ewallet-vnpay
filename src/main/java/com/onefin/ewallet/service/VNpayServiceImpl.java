package com.onefin.ewallet.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefin.ewallet.model.EwalletTransaction;
import com.onefin.ewallet.model.SMSBrandName;
import com.onefin.service.BaseService;

@Service
public class VNpayServiceImpl extends BaseService implements IVNpayService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VNpayServiceImpl.class);

	@Autowired
	private ConfigLoader configLoader;
	
	@Autowired
	private EwalletTransactionRepository transRepository;

	@Override
	public SMSBrandName buildSMSBrandName(SMSBrandName data) {
		data.setSender(configLoader.getSmsBrandname());
		data.setKeyword(configLoader.getSmsKeyword());
		data.setPartnerCode(configLoader.getSmsPartnerCode());
		data.setSercretKey(configLoader.getSmsSercretKey());
		return data;
	}
	
	@Override
	public EwalletTransaction save(EwalletTransaction transData) throws Exception {
		transData.setCreatedDate(new Date(System.currentTimeMillis()));
		return transRepository.save(transData);
	}
	
	

}
