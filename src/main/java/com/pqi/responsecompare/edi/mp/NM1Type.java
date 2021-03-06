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
 * <p>Java class for NM1Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NM1Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Entity-ID-Code" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="IL"/&gt;
 *               &lt;enumeration value="74"/&gt;
 *               &lt;enumeration value="70"/&gt;
 *               &lt;enumeration value="QD"/&gt;
 *               &lt;enumeration value="31"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Entity-Type-Qualifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Name-Last-or-Organization-Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Name-First" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Name-Middle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Identification-Code-Qualifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Identification-Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Date-Time-Period-Format-Qualifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Date-Time-Period" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Gender-Code" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="F"/&gt;
 *               &lt;enumeration value="M"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Race-or-Ethnicity-Code" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="C"/&gt;
 *               &lt;enumeration value="7"/&gt;
 *               &lt;enumeration value="N"/&gt;
 *               &lt;enumeration value="H"/&gt;
 *               &lt;enumeration value="A"/&gt;
 *               &lt;enumeration value="I"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Citizenship-Status-Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Member-Residence-Street-Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Unknown" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="APT 2"/&gt;
 *               &lt;enumeration value="B 308"/&gt;
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
@XmlType(name = "NM1Type", propOrder = {
    "entityIDCode",
    "entityTypeQualifier",
    "nameLastOrOrganizationName",
    "nameFirst",
    "nameMiddle",
    "identificationCodeQualifier",
    "identificationCode",
    "dateTimePeriodFormatQualifier",
    "dateTimePeriod",
    "genderCode",
    "raceOrEthnicityCode",
    "citizenshipStatusCode",
    "memberResidenceStreetAddress",
    "unknown"
})
public class NM1Type {

    @XmlElement(name = "Entity-ID-Code")
    protected String entityIDCode;
    @XmlElement(name = "Entity-Type-Qualifier")
    protected String entityTypeQualifier;
    @XmlElement(name = "Name-Last-or-Organization-Name")
    protected String nameLastOrOrganizationName;
    @XmlElement(name = "Name-First")
    protected String nameFirst;
    @XmlElement(name = "Name-Middle")
    protected String nameMiddle;
    @XmlElement(name = "Identification-Code-Qualifier")
    protected String identificationCodeQualifier;
    @XmlElement(name = "Identification-Code")
    protected String identificationCode;
    @XmlElement(name = "Date-Time-Period-Format-Qualifier")
    protected String dateTimePeriodFormatQualifier;
    @XmlElement(name = "Date-Time-Period")
    protected String dateTimePeriod;
    @XmlElement(name = "Gender-Code")
    protected String genderCode;
    @XmlElement(name = "Race-or-Ethnicity-Code")
    protected String raceOrEthnicityCode;
    @XmlElement(name = "Citizenship-Status-Code")
    protected String citizenshipStatusCode;
    @XmlElement(name = "Member-Residence-Street-Address")
    protected String memberResidenceStreetAddress;
    @XmlElement(name = "Unknown")
    protected String unknown;

    /**
     * Gets the value of the entityIDCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityIDCode() {
        return entityIDCode;
    }

    /**
     * Sets the value of the entityIDCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityIDCode(String value) {
        this.entityIDCode = value;
    }

    /**
     * Gets the value of the entityTypeQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityTypeQualifier() {
        return entityTypeQualifier;
    }

    /**
     * Sets the value of the entityTypeQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityTypeQualifier(String value) {
        this.entityTypeQualifier = value;
    }

    /**
     * Gets the value of the nameLastOrOrganizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameLastOrOrganizationName() {
        return nameLastOrOrganizationName;
    }

    /**
     * Sets the value of the nameLastOrOrganizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameLastOrOrganizationName(String value) {
        this.nameLastOrOrganizationName = value;
    }

    /**
     * Gets the value of the nameFirst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameFirst() {
        return nameFirst;
    }

    /**
     * Sets the value of the nameFirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameFirst(String value) {
        this.nameFirst = value;
    }

    /**
     * Gets the value of the nameMiddle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameMiddle() {
        return nameMiddle;
    }

    /**
     * Sets the value of the nameMiddle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameMiddle(String value) {
        this.nameMiddle = value;
    }

    /**
     * Gets the value of the identificationCodeQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationCodeQualifier() {
        return identificationCodeQualifier;
    }

    /**
     * Sets the value of the identificationCodeQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationCodeQualifier(String value) {
        this.identificationCodeQualifier = value;
    }

    /**
     * Gets the value of the identificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationCode() {
        return identificationCode;
    }

    /**
     * Sets the value of the identificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationCode(String value) {
        this.identificationCode = value;
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
     * Gets the value of the dateTimePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTimePeriod() {
        return dateTimePeriod;
    }

    /**
     * Sets the value of the dateTimePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTimePeriod(String value) {
        this.dateTimePeriod = value;
    }

    /**
     * Gets the value of the genderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * Sets the value of the genderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderCode(String value) {
        this.genderCode = value;
    }

    /**
     * Gets the value of the raceOrEthnicityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaceOrEthnicityCode() {
        return raceOrEthnicityCode;
    }

    /**
     * Sets the value of the raceOrEthnicityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaceOrEthnicityCode(String value) {
        this.raceOrEthnicityCode = value;
    }

    /**
     * Gets the value of the citizenshipStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenshipStatusCode() {
        return citizenshipStatusCode;
    }

    /**
     * Sets the value of the citizenshipStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenshipStatusCode(String value) {
        this.citizenshipStatusCode = value;
    }

    /**
     * Gets the value of the memberResidenceStreetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberResidenceStreetAddress() {
        return memberResidenceStreetAddress;
    }

    /**
     * Sets the value of the memberResidenceStreetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberResidenceStreetAddress(String value) {
        this.memberResidenceStreetAddress = value;
    }

    /**
     * Gets the value of the unknown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnknown() {
        return unknown;
    }

    /**
     * Sets the value of the unknown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnknown(String value) {
        this.unknown = value;
    }

}
