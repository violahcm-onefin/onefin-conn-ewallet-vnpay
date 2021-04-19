package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class VNPay_to_OneFin_TopupMobileResponse {

	private String RespCode;

	private String MobileNo;

	private int Amount;

	private int Trace;

	private String LocalDateTime;

}
