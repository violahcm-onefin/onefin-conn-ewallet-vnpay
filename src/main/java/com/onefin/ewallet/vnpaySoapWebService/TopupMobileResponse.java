
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
 *         &lt;element name="TopupMobileResult" type="{http://www.vnpay.vn/VnTopup/}topupResponse" minOccurs="0"/>
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
    "topupMobileResult"
})
@XmlRootElement(name = "TopupMobileResponse")
public class TopupMobileResponse {

    @XmlElement(name = "TopupMobileResult")
    protected TopupResponse topupMobileResult;

    /**
     * Gets the value of the topupMobileResult property.
     * 
     * @return
     *     possible object is
     *     {@link TopupResponse }
     *     
     */
    public TopupResponse getTopupMobileResult() {
        return topupMobileResult;
    }

    /**
     * Sets the value of the topupMobileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopupResponse }
     *     
     */
    public void setTopupMobileResult(TopupResponse value) {
        this.topupMobileResult = value;
    }

}
