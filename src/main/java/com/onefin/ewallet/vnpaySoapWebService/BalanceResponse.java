
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for balanceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="balanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceReturn" type="{http://www.vnpay.vn/VnTopup/}balanceResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "balanceResponse", propOrder = {
    "balanceReturn"
})
public class BalanceResponse {

    protected BalanceResponseType balanceReturn;

    /**
     * Gets the value of the balanceReturn property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceResponseType }
     *     
     */
    public BalanceResponseType getBalanceReturn() {
        return balanceReturn;
    }

    /**
     * Sets the value of the balanceReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceResponseType }
     *     
     */
    public void setBalanceReturn(BalanceResponseType value) {
        this.balanceReturn = value;
    }

}
