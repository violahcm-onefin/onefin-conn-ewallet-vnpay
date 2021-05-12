package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class VNPayConnResponse {

	private String connectorCode;

	private Object vnpayResponse;
}
