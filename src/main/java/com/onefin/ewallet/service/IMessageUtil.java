package com.onefin.ewallet.service;

import com.onefin.ewallet.model.OneFin_to_SoftSpace_TopupMobileResponse;

public interface IMessageUtil {

	OneFin_to_SoftSpace_TopupMobileResponse build_OneFin_to_SoftSpace_TopupMobileResponse(String connectorCode, Object vtbRes);


}
