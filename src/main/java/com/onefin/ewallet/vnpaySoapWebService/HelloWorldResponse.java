
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
 *         &lt;element name="HelloWorldResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "helloWorldResult"
})
@XmlRootElement(name = "HelloWorldResponse")
public class HelloWorldResponse {

    @XmlElement(name = "HelloWorldResult")
    protected String helloWorldResult;

    /**
     * Gets the value of the helloWorldResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelloWorldResult() {
        return helloWorldResult;
    }

    /**
     * Sets the value of the helloWorldResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelloWorldResult(String value) {
        this.helloWorldResult = value;
    }

}
