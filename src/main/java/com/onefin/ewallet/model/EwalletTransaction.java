package com.onefin.ewallet.model;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onefin.ewallet.common.HashMapConverter;
import com.onefin.ewallet.common.VNPayConstants;

import lombok.Data;

@Data
@Entity
@Table(name = "VnpayEwalletTransaction")
public class EwalletTransaction {

	@Id
	@GenericGenerator(name = VNPayConstants.UUID, strategy = VNPayConstants.UUID2)
	@GeneratedValue(generator = VNPayConstants.UUID)
	@Column(unique = true, nullable = false)
	private UUID id;

	@Column
	private String orderId;

	@Column
	private String destination;

	@Column
	private String apiOperation; // SMS_BRANDNAME, AIRTIME_TOPUP

	@Column
	private String vnpayResult;

	@Column
	private String connectorResult;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = VNPayConstants.DATE_FORMAT_TRANS, timezone = VNPayConstants.TIME_ZONE)
	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Lob
	@Convert(converter = HashMapConverter.class)
	@Column
	private Map<String, Object> ewalletRequest;

	@Lob
	@Convert(converter = HashMapConverter.class)
	@Column
	private Map<String, Object> vnpayResponse;

}
