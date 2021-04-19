
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
 *         &lt;element name="PartnerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UnitCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Trace" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SignData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "partnerCode",
    "product",
    "total",
    "unitCode",
    "trace",
    "signData"
})
@XmlRootElement(name = "GetCardList")
public class GetCardList {

    @XmlElement(name = "PartnerCode")
    protected String partnerCode;
    @XmlElement(name = "Product")
    protected String product;
    @XmlElement(name = "Total")
    protected int total;
    @XmlElement(name = "UnitCode")
    protected int unitCode;
    @XmlElement(name = "Trace")
    protected int trace;
    @XmlElement(name = "SignData")
    protected String signData;

    /**
     * Gets the value of the partnerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerCode() {
        return partnerCode;
    }

    /**
     * Sets the value of the partnerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerCode(String value) {
        this.partnerCode = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the total property.
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * Gets the value of the unitCode property.
     * 
     */
    public int getUnitCode() {
        return unitCode;
    }

    /**
     * Sets the value of the unitCode property.
     * 
     */
    public void setUnitCode(int value) {
        this.unitCode = value;
    }

    /**
     * Gets the value of the trace property.
     * 
     */
    public int getTrace() {
        return trace;
    }

    /**
     * Sets the value of the trace property.
     * 
     */
    public void setTrace(int value) {
        this.trace = value;
    }

    /**
     * Gets the value of the signData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignData() {
        return signData;
    }

    /**
     * Sets the value of the signData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignData(String value) {
        this.signData = value;
    }

}
