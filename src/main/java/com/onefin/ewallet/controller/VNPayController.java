package com.onefin.ewallet.controller;

import com.onefin.ewallet.common.OneFinConstants;
import com.onefin.ewallet.model.*;
import com.onefin.ewallet.service.IHTTPRequestUtil;
import com.onefin.ewallet.service.IMessageUtil;
import com.onefin.ewallet.service.IVNpayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Configuration
@RequestMapping("/vnpay/airtime-topup")
public class VNPayController {

	@Autowired
	public IVNpayService IVNpayService;

	@Autowired
	private IMessageUtil imsgUtil;

	@Autowired
	private IHTTPRequestUtil IHTTPRequestUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(VNPayController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/topupmobile")
	public @ResponseBody ResponseEntity<?> topupmobile(@Valid @RequestBody(required = true) SoftSpaceTopupMobileReq requestBody, HttpServletRequest request) throws Exception {

		LOGGER.info("== RequestID {} - Send TokenIssue Request to VIETIN", requestBody.getRequestId());
		try {
			VNPay_to_OneFin_TopupMobileResponse response = IHTTPRequestUtil.sendTopupMobile(requestBody);
		} catch (Exception e) {
			LOGGER.error("== RequestID {} - Fail to process TokenIssue function: {}", requestBody.getRequestId(), e);
			return new ResponseEntity<>(
					imsgUtil.buildVietinConnectorResponse(OneFinConstants.INTERNAL_SERVER_ERROR, null), HttpStatus.OK);
		}

	}


}
