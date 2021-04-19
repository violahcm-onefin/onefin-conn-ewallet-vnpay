
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for topupResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="topupResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="topupReturn" type="{http://www.vnpay.vn/VnTopup/}topupResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "topupResponse", propOrder = {
    "topupReturn"
})
public class TopupResponse {

    protected TopupResponseType topupReturn;

    /**
     * Gets the value of the topupReturn property.
     * 
     * @return
     *     possible object is
     *     {@link TopupResponseType }
     *     
     */
    public TopupResponseType getTopupReturn() {
        return topupReturn;
    }

    /**
     * Sets the value of the topupReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopupResponseType }
     *     
     */
    public void setTopupReturn(TopupResponseType value) {
        this.topupReturn = value;
    }

}
