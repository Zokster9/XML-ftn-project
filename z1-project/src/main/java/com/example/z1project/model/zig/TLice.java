//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.31 at 09:25:02 PM CET 
//


package com.example.z1project.model.zig;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for TLice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TLice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zig}Kontakt_podaci"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zig}Adresa"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLice", propOrder = {
    "kontaktPodaci",
    "adresa"
})
@XmlSeeAlso({
    TFizickoLice.class,
    TPravnoLice.class
})
public abstract class TLice {

    @XmlElement(name = "Kontakt_podaci", required = true)
    protected KontaktPodaci kontaktPodaci;
    @XmlElement(name = "Adresa", required = true)
    protected Adresa adresa;

    /**
     * Gets the value of the kontaktPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link KontaktPodaci }
     *     
     */
    public KontaktPodaci getKontaktPodaci() {
        return kontaktPodaci;
    }

    /**
     * Sets the value of the kontaktPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link KontaktPodaci }
     *     
     */
    public void setKontaktPodaci(KontaktPodaci value) {
        this.kontaktPodaci = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

}
