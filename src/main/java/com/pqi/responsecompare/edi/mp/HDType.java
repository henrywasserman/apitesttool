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
 * <p>Java class for HDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HDType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Maintenance-Type-Code" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="001"/&gt;
 *               &lt;enumeration value="024"/&gt;
 *               &lt;enumeration value="021"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Plan-Coverage-Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Coverage-Level" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="DC1"/&gt;
 *               &lt;enumeration value="DC2B"/&gt;
 *               &lt;enumeration value="DC3A"/&gt;
 *               &lt;enumeration value="DC2A"/&gt;
 *               &lt;enumeration value="DF1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Date-Time-Qualifier" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="007"/&gt;
 *               &lt;enumeration value="356"/&gt;
 *               &lt;enumeration value="357"/&gt;
 *               &lt;enumeration value="348"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Date-Time-Period-Format-Qualifier" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="D8"/&gt;
 *               &lt;enumeration value="RD8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Date-Time-Period-Format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HDType", propOrder = {
    "maintenanceTypeCode",
    "planCoverageDescription",
    "coverageLevel",
    "dateTimeQualifier",
    "dateTimePeriodFormatQualifier",
    "dateTimePeriodFormat"
})
public class HDType {

    @XmlElement(name = "Maintenance-Type-Code")
    protected String maintenanceTypeCode;
    @XmlElement(name = "Plan-Coverage-Description")
    protected String planCoverageDescription;
    @XmlElement(name = "Coverage-Level")
    protected String coverageLevel;
    @XmlElement(name = "Date-Time-Qualifier")
    protected String dateTimeQualifier;
    @XmlElement(name = "Date-Time-Period-Format-Qualifier")
    protected String dateTimePeriodFormatQualifier;
    @XmlElement(name = "Date-Time-Period-Format")
    protected String dateTimePeriodFormat;

    /**
     * Gets the value of the maintenanceTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaintenanceTypeCode() {
        return maintenanceTypeCode;
    }

    /**
     * Sets the value of the maintenanceTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaintenanceTypeCode(String value) {
        this.maintenanceTypeCode = value;
    }

    /**
     * Gets the value of the planCoverageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanCoverageDescription() {
        return planCoverageDescription;
    }

    /**
     * Sets the value of the planCoverageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanCoverageDescription(String value) {
        this.planCoverageDescription = value;
    }

    /**
     * Gets the value of the coverageLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverageLevel() {
        return coverageLevel;
    }

    /**
     * Sets the value of the coverageLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverageLevel(String value) {
        this.coverageLevel = value;
    }

    /**
     * Gets the value of the dateTimeQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTimeQualifier() {
        return dateTimeQualifier;
    }

    /**
     * Sets the value of the dateTimeQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTimeQualifier(String value) {
        this.dateTimeQualifier = value;
    }

    /**
     * Gets the value of the dateTimePeriodFormatQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTimePeriodFormatQualifier() {
        return dateTimePeriodFormatQualifier;
    }

    /**
     * Sets the value of the dateTimePeriodFormatQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTimePeriodFormatQualifier(String value) {
        this.dateTimePeriodFormatQualifier = value;
    }

    /**
     * Gets the value of the dateTimePeriodFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTimePeriodFormat() {
        return dateTimePeriodFormat;
    }

    /**
     * Sets the value of the dateTimePeriodFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTimePeriodFormat(String value) {
        this.dateTimePeriodFormat = value;
    }

}