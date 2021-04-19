package com.onefin.ewallet.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OneFin_to_SoftSpace_TopupMobileResponse {

	private String RespCode;

	private String MobileNo;

	private BigDecimal Amount;

	private long Trace;

	private String LocalDateTime;

	private String VnPayDateTime;

	private String PartnerCode;

}
