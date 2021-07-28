package com.onefin.ewallet.service;

import com.onefin.ewallet.model.*;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;

public interface IHTTPRequestUtil {

	TopupResponse sendTopupMobile(SoftSpaceTopupMobileReq data) throws Exception;

	Object sendSMSBrandName(SMSBrandName data) throws Exception;
	
	vn.vnpay.vntopup.TopupResponse sendTopupMobileV2(SoftSpaceTopupMobileReq data) throws Exception;

}
