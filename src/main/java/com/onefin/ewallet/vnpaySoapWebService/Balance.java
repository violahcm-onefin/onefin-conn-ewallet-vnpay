
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for balance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="balance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceRequest" type="{http://www.vnpay.vn/VnTopup/}balanceRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "balance", propOrder = {
    "balanceRequest"
})
public class Balance {

    protected BalanceRequestType balanceRequest;

    /**
     * Gets the value of the balanceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceRequestType }
     *     
     */
    public BalanceRequestType getBalanceRequest() {
        return balanceRequest;
    }

    /**
     * Sets the value of the balanceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceRequestType }
     *     
     */
    public void setBalanceRequest(BalanceRequestType value) {
        this.balanceRequest = value;
    }

}
