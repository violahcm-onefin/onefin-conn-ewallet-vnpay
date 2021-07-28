package com.onefin.ewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefin.ewallet.model.OneFin_to_SoftSpace_TopupMobileResponse;
import com.onefin.ewallet.model.VNPayConnResponse;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;

@Service
public class MessageUtilImpl implements IMessageUtil {

	@Autowired
	private ConfigLoader configLoader;

	@Override
	public OneFin_to_SoftSpace_TopupMobileResponse build_OneFin_to_SoftSpace_TopupMobileResponse(TopupResponse data) {
		OneFin_to_SoftSpace_TopupMobileResponse response = new OneFin_to_SoftSpace_TopupMobileResponse();
		response.setRespCode(data.getTopupReturn().getRespCode());
		response.setMobileNo(data.getTopupReturn().getMobileNo());
		response.setAmount(data.getTopupReturn().getAmount());
		response.setTrace(data.getTopupReturn().getTrace());
		response.setLocalDateTime(data.getTopupReturn().getLocalDateTime());
		response.setVnPayDateTime(data.getTopupReturn().getVnPayDateTime());
		response.setPartnerCode(configLoader.getPartnerCode());
		return response;
	}
	
	@Override
	public OneFin_to_SoftSpace_TopupMobileResponse build_OneFin_to_SoftSpace_TopupMobileResponseV2(vn.vnpay.vntopup.TopupResponse data) {
		OneFin_to_SoftSpace_TopupMobileResponse response = new OneFin_to_SoftSpace_TopupMobileResponse();
		response.setRespCode(data.getTopupReturn().getRespCode());
		response.setMobileNo(data.getTopupReturn().getMobileNo());
		response.setAmount(data.getTopupReturn().getAmount());
		response.setTrace(data.getTopupReturn().getTrace());
		response.setLocalDateTime(data.getTopupReturn().getLocalDateTime());
		response.setVnPayDateTime(data.getTopupReturn().getVnPayDateTime());
		response.setPartnerCode(configLoader.getPartnerCode());
		return response;
	}

	@Override
	public VNPayConnResponse buildVNPayConnectorResponse(String code, Object data) {
		VNPayConnResponse response = new VNPayConnResponse();
		response.setConnectorCode(code);
		response.setVnpayResponse(data);
		return response;
	}

}
