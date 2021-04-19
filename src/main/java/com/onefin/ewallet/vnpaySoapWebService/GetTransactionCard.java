
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
 *         &lt;element name="sPartnerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sTrace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sLocalDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sPartnerCode",
    "sTrace",
    "sLocalDateTime",
    "sSign"
})
@XmlRootElement(name = "GetTransactionCard")
public class GetTransactionCard {

    protected String sPartnerCode;
    protected String sTrace;
    protected String sLocalDateTime;
    protected String sSign;

    /**
     * Gets the value of the sPartnerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPartnerCode() {
        return sPartnerCode;
    }

    /**
     * Sets the value of the sPartnerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPartnerCode(String value) {
        this.sPartnerCode = value;
    }

    /**
     * Gets the value of the sTrace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTrace() {
        return sTrace;
    }

    /**
     * Sets the value of the sTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTrace(String value) {
        this.sTrace = value;
    }

    /**
     * Gets the value of the sLocalDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLocalDateTime() {
        return sLocalDateTime;
    }

    /**
     * Sets the value of the sLocalDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLocalDateTime(String value) {
        this.sLocalDateTime = value;
    }

    /**
     * Gets the value of the sSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSign() {
        return sSign;
    }

    /**
     * Sets the value of the sSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSign(String value) {
        this.sSign = value;
    }

}
