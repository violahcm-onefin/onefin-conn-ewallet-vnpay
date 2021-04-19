package com.onefin.ewallet.service;

import com.onefin.ewallet.model.OneFin_to_SoftSpace_TopupMobileResponse;
import com.onefin.ewallet.model.VNPayConnResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageUtilImpl implements IMessageUtil {

	@Autowired
	private ConfigLoader configLoader;

	@Override
	public OneFin_to_SoftSpace_TopupMobileResponse build_OneFin_to_SoftSpace_TopupMobileResponse(String connectorCode, Object Res) {
		OneFin_to_SoftSpace_TopupMobileResponse response = new OneFin_to_SoftSpace_TopupMobileResponse();
//		response.setAmount();
		response.setResponse(Res);
		response.setVersion(configLoader.getVNPayVersion());
		return response;
	}

}
