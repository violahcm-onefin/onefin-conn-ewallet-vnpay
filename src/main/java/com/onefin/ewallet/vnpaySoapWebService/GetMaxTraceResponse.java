
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
 *         &lt;element name="GetMaxTraceResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getMaxTraceResult"
})
@XmlRootElement(name = "GetMaxTraceResponse")
public class GetMaxTraceResponse {

    @XmlElement(name = "GetMaxTraceResult")
    protected String getMaxTraceResult;

    /**
     * Gets the value of the getMaxTraceResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetMaxTraceResult() {
        return getMaxTraceResult;
    }

    /**
     * Sets the value of the getMaxTraceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetMaxTraceResult(String value) {
        this.getMaxTraceResult = value;
    }

}
