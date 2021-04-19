
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
 *         &lt;element name="GetCardResult" type="{http://www.vnpay.vn/VnTopup/}CardResponse" minOccurs="0"/>
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
    "getCardResult"
})
@XmlRootElement(name = "GetCardResponse")
public class GetCardResponse {

    @XmlElement(name = "GetCardResult")
    protected CardResponse getCardResult;

    /**
     * Gets the value of the getCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardResponse }
     *     
     */
    public CardResponse getGetCardResult() {
        return getCardResult;
    }

    /**
     * Sets the value of the getCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardResponse }
     *     
     */
    public void setGetCardResult(CardResponse value) {
        this.getCardResult = value;
    }

}
