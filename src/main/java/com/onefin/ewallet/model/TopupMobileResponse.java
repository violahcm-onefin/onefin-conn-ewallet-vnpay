package com.onefin.ewallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TopupMobileResponse {

	@JsonIgnore
	private String MobileNo;

	private String Amount;

	private String Trace;

	private String LocalDateTime;

}
