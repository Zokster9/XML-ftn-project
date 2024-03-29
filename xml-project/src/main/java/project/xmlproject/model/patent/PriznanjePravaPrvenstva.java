//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.11.30 at 09:42:14 PM CET 
//


package project.xmlproject.model.patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Datum_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Broj_ranije_prijave"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="P[0-9]+"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Dvoslovna_oznaka_drzave_organizacije"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="[A-Z][A-Z]"/&gt;
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
@XmlType(name = "", propOrder = {
    "datumPrijave",
    "brojRanijePrijave",
    "dvoslovnaOznakaDrzaveOrganizacije"
})
@XmlRootElement(name = "Priznanje_prava_prvenstva")
public class PriznanjePravaPrvenstva {

    @XmlElement(name = "Datum_prijave", required = true)
    protected String datumPrijave;
    @XmlElement(name = "Broj_ranije_prijave", required = true)
    protected String brojRanijePrijave;
    @XmlElement(name = "Dvoslovna_oznaka_drzave_organizacije", required = true)
    protected String dvoslovnaOznakaDrzaveOrganizacije;

    /**
     * Gets the value of the datumPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumPrijave() {
        return datumPrijave;
    }

    /**
     * Sets the value of the datumPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumPrijave(String value) {
        this.datumPrijave = value;
    }

    /**
     * Gets the value of the brojRanijePrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojRanijePrijave() {
        return brojRanijePrijave;
    }

    /**
     * Sets the value of the brojRanijePrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojRanijePrijave(String value) {
        this.brojRanijePrijave = value;
    }

    /**
     * Gets the value of the dvoslovnaOznakaDrzaveOrganizacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDvoslovnaOznakaDrzaveOrganizacije() {
        return dvoslovnaOznakaDrzaveOrganizacije;
    }

    /**
     * Sets the value of the dvoslovnaOznakaDrzaveOrganizacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDvoslovnaOznakaDrzaveOrganizacije(String value) {
        this.dvoslovnaOznakaDrzaveOrganizacije = value;
    }

}
