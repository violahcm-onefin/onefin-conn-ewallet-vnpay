
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetBalanceResult" type="{http://www.vnpay.vn/VnTopup/}balanceResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getBalanceResult"
})
@XmlRootElement(name = "GetBalanceResponse")
public class GetBalanceResponse {

    @XmlElement(name = "GetBalanceResult")
    protected BalanceResponse getBalanceResult;

    /**
     * Gets the value of the getBalanceResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceResponse }
     *     
     */
    public BalanceResponse getGetBalanceResult() {
        return getBalanceResult;
    }

    /**
     * Sets the value of the getBalanceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceResponse }
     *     
     */
    public void setGetBalanceResult(BalanceResponse value) {
        this.getBalanceResult = value;
    }

}
