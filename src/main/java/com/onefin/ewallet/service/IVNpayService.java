package com.onefin.ewallet.service;

import com.onefin.ewallet.model.SoftSpaceTopupMobileReq;
import com.onefin.service.IBaseService;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface IVNpayService extends IBaseService {

	/**
	 * Validate response from VTB
	 * 
	 * @param responseObj
	 * @param language
	 * @return
	 */
	public ResponseEntity<?> validateResponse(Object data);

	SoftSpaceTopupMobileReq buildVNPayTopupMobile(SoftSpaceTopupMobileReq model)
			throws NoSuchAlgorithmException, InvalidKeySpecException, IOException;

}
