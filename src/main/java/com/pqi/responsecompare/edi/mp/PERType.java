//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.13 at 05:01:13 PM EDT 
//


package com.pqi.responsecompare.edi.mp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PERType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PERType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Contact-Function-Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Communication-Number1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Communication-Number-Qualifier2"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="7812154989"/&gt;
 *               &lt;enumeration value="6173024791"/&gt;
 *               &lt;enumeration value="4138639710"/&gt;
 *               &lt;enumeration value="7572148719"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Communication-Number2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Communication-Number-Qualifier3" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="6173022254"/&gt;
 *               &lt;enumeration value="4132623407"/&gt;
 *               &lt;enumeration value="6172662257"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERType", propOrder = {
    "contactFunctionCode",
    "communicationNumber1",
    "communicationNumberQualifier2",
    "communicationNumber2",
    "communicationNumberQualifier3"
})
public class PERType {

    @XmlElement(name = "Contact-Function-Code", required = true)
    protected String contactFunctionCode;
    @XmlElement(name = "Communication-Number1", required = true)
    protected String communicationNumber1;
    @XmlElement(name = "Communication-Number-Qualifier2", required = true)
    protected String communicationNumberQualifier2;
    @XmlElement(name = "Communication-Number2")
    protected String communicationNumber2;
    @XmlElement(name = "Communication-Number-Qualifier3")
    protected String communicationNumberQualifier3;

    /**
     * Gets the value of the contactFunctionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactFunctionCode() {
        return contactFunctionCode;
    }

    /**
     * Sets the value of the contactFunctionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactFunctionCode(String value) {
        this.contactFunctionCode = value;
    }

    /**
     * Gets the value of the communicationNumber1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationNumber1() {
        return communicationNumber1;
    }

    /**
     * Sets the value of the communicationNumber1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationNumber1(String value) {
        this.communicationNumber1 = value;
    }

    /**
     * Gets the value of the communicationNumberQualifier2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationNumberQualifier2() {
        return communicationNumberQualifier2;
    }

    /**
     * Sets the value of the communicationNumberQualifier2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationNumberQualifier2(String value) {
        this.communicationNumberQualifier2 = value;
    }

    /**
     * Gets the value of the communicationNumber2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationNumber2() {
        return communicationNumber2;
    }

    /**
     * Sets the value of the communicationNumber2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationNumber2(String value) {
        this.communicationNumber2 = value;
    }

    /**
     * Gets the value of the communicationNumberQualifier3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationNumberQualifier3() {
        return communicationNumberQualifier3;
    }

    /**
     * Sets the value of the communicationNumberQualifier3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationNumberQualifier3(String value) {
        this.communicationNumberQualifier3 = value;
    }

}