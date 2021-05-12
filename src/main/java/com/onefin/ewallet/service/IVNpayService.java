package com.onefin.ewallet.service;

import com.onefin.ewallet.model.EwalletTransaction;
import com.onefin.ewallet.model.SMSBrandName;
import com.onefin.service.IBaseService;

public interface IVNpayService extends IBaseService {

	SMSBrandName buildSMSBrandName(SMSBrandName data);

	EwalletTransaction save(EwalletTransaction transData) throws Exception;

}
