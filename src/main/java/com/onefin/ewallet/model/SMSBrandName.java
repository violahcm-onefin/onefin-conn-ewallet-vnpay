package com.onefin.ewallet.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SMSBrandName {

	@Size(max = 32)
	@NotEmpty(message = "Not empty")
	private String messageId;

	@Size(max = 15)
	@NotEmpty(message = "Not empty")
	private String destination;

	private String sender;

	private String keyword;

	@Size(max = 480)
	@NotEmpty(message = "Not empty")
	private String shortMessage;

	private String encryptMessage;

	@NotNull(message = "Not empty")
	private Integer isEncrypt;

	@NotNull(message = "Not empty")
	private Integer type;

	@NotNull(message = "Not empty")
	private Long requestTime;

	private String partnerCode;

	private String sercretKey;

}
