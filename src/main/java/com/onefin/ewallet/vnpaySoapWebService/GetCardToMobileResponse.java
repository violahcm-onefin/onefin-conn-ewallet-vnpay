
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
 *         &lt;element name="GetCardToMobileResult" type="{http://www.vnpay.vn/VnTopup/}CardResponse" minOccurs="0"/>
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
    "getCardToMobileResult"
})
@XmlRootElement(name = "GetCardToMobileResponse")
public class GetCardToMobileResponse {

    @XmlElement(name = "GetCardToMobileResult")
    protected CardResponse getCardToMobileResult;

    /**
     * Gets the value of the getCardToMobileResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardResponse }
     *     
     */
    public CardResponse getGetCardToMobileResult() {
        return getCardToMobileResult;
    }

    /**
     * Sets the value of the getCardToMobileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardResponse }
     *     
     */
    public void setGetCardToMobileResult(CardResponse value) {
        this.getCardToMobileResult = value;
    }

}
