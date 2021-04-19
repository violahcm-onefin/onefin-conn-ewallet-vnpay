package com.onefin.ewallet.service;

import com.onefin.ewallet.model.*;
import com.onefin.ewallet.vnpaySoapWebService.TopupResponse;

public interface IHTTPRequestUtil {

	TopupResponse sendTopupMobile(SoftSpaceTopupMobileReq data) throws Exception;

}
