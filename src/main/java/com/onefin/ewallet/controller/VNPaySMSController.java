package com.onefin.ewallet.controller;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.onefin.ewallet.common.VNPayConstants;
import com.onefin.ewallet.model.EwalletTransaction;
import com.onefin.ewallet.model.SMSBrandName;
import com.onefin.ewallet.model.VNPayConnResponse;
import com.onefin.ewallet.service.IHTTPRequestUtil;
import com.onefin.ewallet.service.IMessageUtil;
import com.onefin.ewallet.service.IVNpayService;

@Controller
@Configuration
@RequestMapping("/vnpay/ewallet")
public class VNPaySMSController {

	@Autowired
	public IVNpayService IVNpayService;

	@Autowired
	private IMessageUtil imsgUtil;

	@Autowired
	private IHTTPRequestUtil IHTTPRequestUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(VNPaySMSController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/sendSms")
	public @ResponseBody ResponseEntity<?> smsBrandName(@Valid @RequestBody(required = true) SMSBrandName requestBody,
			HttpServletRequest request) throws Exception {

		LOGGER.info("== RequestID {} - Send SMS to VNPAY", requestBody.getMessageId());
		EwalletTransaction eTrans = new EwalletTransaction();
		Map<String, Object> response = null;
		VNPayConnResponse connResponse = null;
		try {
			requestBody = IVNpayService.buildSMSBrandName(requestBody);
			response = (Map<String, Object>) IHTTPRequestUtil.sendSMSBrandName(requestBody);
			connResponse = imsgUtil.buildVNPayConnectorResponse(VNPayConstants.VNPAY_CONNECTOR_SUCCESS, response);
			return new ResponseEntity<>(connResponse, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("== RequestID {} - Fail to process SMS to VNPAY", requestBody.getMessageId(), e);
			return new ResponseEntity<>(
					imsgUtil.buildVNPayConnectorResponse(VNPayConstants.INTERNAL_SERVER_ERROR, null), HttpStatus.OK);
		} finally {
			try {
				eTrans.setOrderId(requestBody.getMessageId());
				eTrans.setApiOperation(VNPayConstants.VNPAY_SMS_BRANDNAME);
				eTrans.setDestination(requestBody.getDestination());
				eTrans.setVnpayResult(response != null ? Objects.toString(response.get("status"), null) : null);
				eTrans.setConnectorResult(VNPayConstants.VNPAY_CONNECTOR_SUCCESS);
				eTrans.setEwalletRequest((Map<String, Object>) IVNpayService.convertObject2Map(requestBody, Map.class));
				eTrans.setVnpayResponse((Map<String, Object>) IVNpayService.convertObject2Map(response, Map.class));
				IVNpayService.save(eTrans);
			} catch (Exception e) {
				LOGGER.error("Fail store VNPAY transaction", e);
			}
		}

	}

}
