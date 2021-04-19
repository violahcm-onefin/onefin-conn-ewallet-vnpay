
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="topuprequest" type="{http://www.vnpay.vn/VnTopup/}topup" minOccurs="0"/>
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
    "topuprequest"
})
@XmlRootElement(name = "TopupMobile")
public class TopupMobile {

    protected Topup topuprequest;

    /**
     * Gets the value of the topuprequest property.
     * 
     * @return
     *     possible object is
     *     {@link Topup }
     *     
     */
    public Topup getTopuprequest() {
        return topuprequest;
    }

    /**
     * Sets the value of the topuprequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Topup }
     *     
     */
    public void setTopuprequest(Topup value) {
        this.topuprequest = value;
    }

}
