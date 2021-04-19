
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionRequest" type="{http://www.vnpay.vn/VnTopup/}transactionRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction", propOrder = {
    "transactionRequest"
})
public class Transaction {

    @XmlElement(name = "TransactionRequest")
    protected TransactionRequestType transactionRequest;

    /**
     * Gets the value of the transactionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionRequestType }
     *     
     */
    public TransactionRequestType getTransactionRequest() {
        return transactionRequest;
    }

    /**
     * Sets the value of the transactionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRequestType }
     *     
     */
    public void setTransactionRequest(TransactionRequestType value) {
        this.transactionRequest = value;
    }

}
