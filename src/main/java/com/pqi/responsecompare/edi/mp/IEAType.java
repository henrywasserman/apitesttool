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
 * <p>Java class for IEAType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IEAType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Number-of-Included-Functional-Groups" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Interchange-Control-Number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IEAType", propOrder = {
    "numberOfIncludedFunctionalGroups",
    "interchangeControlNumber"
})
public class IEAType {

    @XmlElement(name = "Number-of-Included-Functional-Groups", required = true)
    protected String numberOfIncludedFunctionalGroups;
    @XmlElement(name = "Interchange-Control-Number", required = true)
    protected String interchangeControlNumber;

    /**
     * Gets the value of the numberOfIncludedFunctionalGroups property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfIncludedFunctionalGroups() {
        return numberOfIncludedFunctionalGroups;
    }

    /**
     * Sets the value of the numberOfIncludedFunctionalGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfIncludedFunctionalGroups(String value) {
        this.numberOfIncludedFunctionalGroups = value;
    }

    /**
     * Gets the value of the interchangeControlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterchangeControlNumber() {
        return interchangeControlNumber;
    }

    /**
     * Sets the value of the interchangeControlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterchangeControlNumber(String value) {
        this.interchangeControlNumber = value;
    }

}
