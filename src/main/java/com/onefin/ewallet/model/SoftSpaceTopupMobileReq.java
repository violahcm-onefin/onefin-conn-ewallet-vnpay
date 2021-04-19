package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class SoftSpaceTopupMobileReq {

	private String MobileNo;

	private int Amount;

	private int Trace;

	private String LocalDateTime;

}
