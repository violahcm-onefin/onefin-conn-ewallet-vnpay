package com.onefin.ewallet.service;

import com.onefin.ewallet.model.OneFin_to_SoftSpace_TopupMobileResponse;
import com.onefin.ewallet.model.VNPayConnResponse;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;

public interface IMessageUtil {

	OneFin_to_SoftSpace_TopupMobileResponse build_OneFin_to_SoftSpace_TopupMobileResponse(TopupResponse data);

	VNPayConnResponse buildVNPayConnectorResponse(String code, Object data);

	OneFin_to_SoftSpace_TopupMobileResponse build_OneFin_to_SoftSpace_TopupMobileResponseV2(vn.vnpay.vntopup.TopupResponse data);
	
}
