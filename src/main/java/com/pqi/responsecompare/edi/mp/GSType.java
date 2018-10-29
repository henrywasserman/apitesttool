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
 * <p>Java class for GSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Functional-Identifier-Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Application-Senders-Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Application-Receivers-Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Group-Control-Number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Responsible-Agency-Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VersionReleaseIndustry-Identifier-Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GSType", propOrder = {
    "functionalIdentifierCode",
    "applicationSendersCode",
    "applicationReceiversCode",
    "date",
    "time",
    "groupControlNumber",
    "responsibleAgencyCode",
    "versionReleaseIndustryIdentifierCode"
})
public class GSType {

    @XmlElement(name = "Functional-Identifier-Code", required = true)
    protected String functionalIdentifierCode;
    @XmlElement(name = "Application-Senders-Code", required = true)
    protected String applicationSendersCode;
    @XmlElement(name = "Application-Receivers-Code", required = true)
    protected String applicationReceiversCode;
    @XmlElement(name = "Date", required = true)
    protected String date;
    @XmlElement(name = "Time", required = true)
    protected String time;
    @XmlElement(name = "Group-Control-Number", required = true)
    protected String groupControlNumber;
    @XmlElement(name = "Responsible-Agency-Code", required = true)
    protected String responsibleAgencyCode;
    @XmlElement(name = "VersionReleaseIndustry-Identifier-Code", required = true)
    protected String versionReleaseIndustryIdentifierCode;

    /**
     * Gets the value of the functionalIdentifierCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionalIdentifierCode() {
        return functionalIdentifierCode;
    }

    /**
     * Sets the value of the functionalIdentifierCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionalIdentifierCode(String value) {
        this.functionalIdentifierCode = value;
    }

    /**
     * Gets the value of the applicationSendersCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationSendersCode() {
        return applicationSendersCode;
    }

    /**
     * Sets the value of the applicationSendersCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationSendersCode(String value) {
        this.applicationSendersCode = value;
    }

    /**
     * Gets the value of the applicationReceiversCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationReceiversCode() {
        return applicationReceiversCode;
    }

    /**
     * Sets the value of the applicationReceiversCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationReceiversCode(String value) {
        this.applicationReceiversCode = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the groupControlNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupControlNumber() {
        return groupControlNumber;
    }

    /**
     * Sets the value of the groupControlNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupControlNumber(String value) {
        this.groupControlNumber = value;
    }

    /**
     * Gets the value of the responsibleAgencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleAgencyCode() {
        return responsibleAgencyCode;
    }

    /**
     * Sets the value of the responsibleAgencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleAgencyCode(String value) {
        this.responsibleAgencyCode = value;
    }

    /**
     * Gets the value of the versionReleaseIndustryIdentifierCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionReleaseIndustryIdentifierCode() {
        return versionReleaseIndustryIdentifierCode;
    }

    /**
     * Sets the value of the versionReleaseIndustryIdentifierCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionReleaseIndustryIdentifierCode(String value) {
        this.versionReleaseIndustryIdentifierCode = value;
    }

}
