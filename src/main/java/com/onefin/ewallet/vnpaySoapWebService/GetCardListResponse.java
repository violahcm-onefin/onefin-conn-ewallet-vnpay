
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
 *         &lt;element name="GetCardListResult" type="{http://www.vnpay.vn/VnTopup/}CardListResponse" minOccurs="0"/>
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
    "getCardListResult"
})
@XmlRootElement(name = "GetCardListResponse")
public class GetCardListResponse {

    @XmlElement(name = "GetCardListResult")
    protected CardListResponse getCardListResult;

    /**
     * Gets the value of the getCardListResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardListResponse }
     *     
     */
    public CardListResponse getGetCardListResult() {
        return getCardListResult;
    }

    /**
     * Sets the value of the getCardListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardListResponse }
     *     
     */
    public void setGetCardListResult(CardListResponse value) {
        this.getCardListResult = value;
    }

}
