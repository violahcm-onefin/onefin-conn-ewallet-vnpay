package com.onefin.ewallet.service;

import com.onefin.ewallet.common.EncryptUtil;
import com.onefin.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VNpayServiceImpl extends BaseService implements IVNpayService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VNpayServiceImpl.class);

	@Autowired
	private ConfigLoader configLoader;

	@Autowired
	private IMessageUtil iMessageUtil;

	@Autowired
	private EncryptUtil encryptUtil;



}
