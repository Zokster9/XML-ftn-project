package a1.a1service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="datum_resenja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="zahtev_je_prihvacen" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="obrazlozenje" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="referenca" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "brojResenjaZahteva",
        "datumResenja",
        "zahtevJePrihvacen",
        "sifra",
        "obrazlozenje",
        "referenca",
        "imeSluzbenika",
        "prezimeSluzbenika"
})
@XmlRootElement(name = "resenje_zahteva")
public class ResenjeZahteva {

    @XmlElement(name = "broj_resenja_zahteva", required = true)
    protected String brojResenjaZahteva;
    @XmlElement(name = "datum_resenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumResenja;
    @XmlElement(name = "zahtev_je_prihvacen")
    protected boolean zahtevJePrihvacen;
    protected String sifra;
    protected String obrazlozenje;
    @XmlElement(required = true)
    protected String referenca;
    @XmlElement(name = "ime_sluzbenika",required = true)
    protected String imeSluzbenika;
    @XmlElement(name = "prezime_sluzbenika",required = true)
    protected String prezimeSluzbenika;

    public String getBrojResenjaZahteva() {
        return brojResenjaZahteva;
    }

    public void setBrojResenjaZahteva(String brojResenjaZahteva) {
        this.brojResenjaZahteva = brojResenjaZahteva;
    }

    /**
     * Gets the value of the datumResenja property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatumResenja() {
        return datumResenja;
    }

    /**
     * Sets the value of the datumResenja property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatumResenja(XMLGregorianCalendar value) {
        this.datumResenja = value;
    }

    /**
     * Gets the value of the zahtevJePrihvacen property.
     *
     */
    public boolean isZahtevJePrihvacen() {
        return zahtevJePrihvacen;
    }

    /**
     * Sets the value of the zahtevJePrihvacen property.
     *
     */
    public void setZahtevJePrihvacen(boolean value) {
        this.zahtevJePrihvacen = value;
    }

    /**
     * Gets the value of the sifra property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setObrazlozenje(String value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the referenca property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferenca() {
        return referenca;
    }

    /**
     * Sets the value of the referenca property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferenca(String value) {
        this.referenca = value;
    }

    public String getImeSluzbenika() {
        return imeSluzbenika;
    }

    public void setImeSluzbenika(String imeSluzbenika) {
        this.imeSluzbenika = imeSluzbenika;
    }

    public String getPrezimeSluzbenika() {
        return prezimeSluzbenika;
    }

    public void setPrezimeSluzbenika(String prezimeSluzbenika) {
        this.prezimeSluzbenika = prezimeSluzbenika;
    }
}
