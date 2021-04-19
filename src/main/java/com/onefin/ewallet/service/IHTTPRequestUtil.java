package com.onefin.ewallet.service;

import com.onefin.ewallet.model.*;

public interface IHTTPRequestUtil {

	VNPay_to_OneFin_TopupMobileResponse sendTopupMobile(SoftSpaceTopupMobileReq data) throws Exception;

}
