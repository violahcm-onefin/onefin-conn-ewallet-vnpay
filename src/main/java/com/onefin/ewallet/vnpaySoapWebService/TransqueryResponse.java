
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transqueryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transqueryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transqueryReturn" type="{http://www.vnpay.vn/VnTopup/}transqueryResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transqueryResponse", propOrder = {
    "transqueryReturn"
})
public class TransqueryResponse {

    protected TransqueryResponseType transqueryReturn;

    /**
     * Gets the value of the transqueryReturn property.
     * 
     * @return
     *     possible object is
     *     {@link TransqueryResponseType }
     *     
     */
    public TransqueryResponseType getTransqueryReturn() {
        return transqueryReturn;
    }

    /**
     * Sets the value of the transqueryReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransqueryResponseType }
     *     
     */
    public void setTransqueryReturn(TransqueryResponseType value) {
        this.transqueryReturn = value;
    }

}
