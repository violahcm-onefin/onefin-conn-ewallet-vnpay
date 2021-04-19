package com.onefin.ewallet.controller;

import com.onefin.ewallet.model.SoftSpaceTopupMobileReq;
import com.onefin.ewallet.service.IHTTPRequestUtil;
import com.onefin.ewallet.service.IMessageUtil;
import com.onefin.ewallet.service.IVNpayService;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;
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
@RequestMapping("/airtimetopup-api-connector/rest/v1/ewallet/")
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

		TopupResponse response = IHTTPRequestUtil.sendTopupMobile(requestBody);

		return new ResponseEntity<>(
				imsgUtil.build_OneFin_to_SoftSpace_TopupMobileResponse(response), HttpStatus.OK);

	}


}
