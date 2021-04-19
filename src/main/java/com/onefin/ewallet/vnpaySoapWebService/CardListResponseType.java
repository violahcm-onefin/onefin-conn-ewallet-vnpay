
package com.onefin.ewallet.vnpaySoapWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardListResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TranxMap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardListResponseType", propOrder = {
    "responseCode",
    "description",
    "tranxMap",
    "listCard"
})
public class CardListResponseType {

    @XmlElement(name = "ResponseCode")
    protected String responseCode;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "TranxMap")
    protected String tranxMap;
    @XmlElement(name = "ListCard")
    protected String listCard;

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the tranxMap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranxMap() {
        return tranxMap;
    }

    /**
     * Sets the value of the tranxMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranxMap(String value) {
        this.tranxMap = value;
    }

    /**
     * Gets the value of the listCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListCard() {
        return listCard;
    }

    /**
     * Sets the value of the listCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListCard(String value) {
        this.listCard = value;
    }

}
