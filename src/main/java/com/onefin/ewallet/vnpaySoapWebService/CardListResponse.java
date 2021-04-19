
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardListResponseType" type="{http://www.vnpay.vn/VnTopup/}CardListResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardListResponse", propOrder = {
    "cardListResponseType"
})
public class CardListResponse {

    @XmlElement(name = "CardListResponseType")
    protected CardListResponseType cardListResponseType;

    /**
     * Gets the value of the cardListResponseType property.
     * 
     * @return
     *     possible object is
     *     {@link CardListResponseType }
     *     
     */
    public CardListResponseType getCardListResponseType() {
        return cardListResponseType;
    }

    /**
     * Sets the value of the cardListResponseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardListResponseType }
     *     
     */
    public void setCardListResponseType(CardListResponseType value) {
        this.cardListResponseType = value;
    }

}
