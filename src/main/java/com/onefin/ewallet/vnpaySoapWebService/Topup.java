
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for topup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="topup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="topupRequest" type="{http://www.vnpay.vn/VnTopup/}topupRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "topup", propOrder = {
    "topupRequest"
})
public class Topup {

    protected TopupRequestType topupRequest;

    /**
     * Gets the value of the topupRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TopupRequestType }
     *     
     */
    public TopupRequestType getTopupRequest() {
        return topupRequest;
    }

    /**
     * Sets the value of the topupRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopupRequestType }
     *     
     */
    public void setTopupRequest(TopupRequestType value) {
        this.topupRequest = value;
    }

}
