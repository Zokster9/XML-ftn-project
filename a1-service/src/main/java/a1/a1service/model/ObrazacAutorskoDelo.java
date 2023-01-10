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
 *         &lt;element name="podnosilac" type="{http://www.ftn.uns.ac.rs/autorksa}TLice"/&gt;
 *         &lt;element name="punomocnik" type="{http://www.ftn.uns.ac.rs/autorksa}Punomocnik" minOccurs="0"/&gt;
 *         &lt;element name="podaci_o_autorskom_delu" type="{http://www.ftn.uns.ac.rs/autorksa}Podaci_o_autorskom_delu"/&gt;
 *         &lt;element name="broj_prijave" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="datum_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
        "podnosilac",
        "punomocnik",
        "podaciOAutorskomDelu",
        "brojPrijave",
        "datumPrijave",
        "priloziUzPrijavu",
        "podnosilacAutor"
})
@XmlRootElement(name = "obrazac_autorsko_delo")
public class ObrazacAutorskoDelo {

    @XmlElement(required = true)
    protected TLice podnosilac;
    protected Punomocnik punomocnik;
    @XmlElement(name = "podaci_o_autorskom_delu", required = true)
    protected PodaciOAutorskomDelu podaciOAutorskomDelu;
    @XmlElement(name = "broj_prijave", required = true)
    protected String brojPrijave;
    @XmlElement(name = "datum_prijave", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrijave;
    @XmlElement(name = "prilozi_uz_prijavu", required = true)
    protected PriloziUzPrijavu priloziUzPrijavu;
    @XmlElement(name = "podnosilac_autor", required = true)
    protected boolean podnosilacAutor;

    /**
     * Gets the value of the podnosilac property.
     *
     * @return
     *     possible object is
     *     {@link rs.ac.uns.ftn.autorska.TLice }
     *
     */
    public TLice getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     *
     * @param value
     *     allowed object is
     *     {@link rs.ac.uns.ftn.autorska.TLice }
     *
     */
    public void setPodnosilac(TLice value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the punomocnik property.
     *
     * @return
     *     possible object is
     *     {@link rs.ac.uns.ftn.autorska.Punomocnik }
     *
     */
    public Punomocnik getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     *
     * @param value
     *     allowed object is
     *     {@link rs.ac.uns.ftn.autorska.Punomocnik }
     *
     */
    public void setPunomocnik(Punomocnik value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the podaciOAutorskomDelu property.
     *
     * @return
     *     possible object is
     *     {@link rs.ac.uns.ftn.autorska.PodaciOAutorskomDelu }
     *
     */
    public PodaciOAutorskomDelu getPodaciOAutorskomDelu() {
        return podaciOAutorskomDelu;
    }

    /**
     * Sets the value of the podaciOAutorskomDelu property.
     *
     * @param value
     *     allowed object is
     *     {@link rs.ac.uns.ftn.autorska.PodaciOAutorskomDelu }
     *
     */
    public void setPodaciOAutorskomDelu(PodaciOAutorskomDelu value) {
        this.podaciOAutorskomDelu = value;
    }

    /**
     * Gets the value of the brojPrijave property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBrojPrijave(String value) {
        this.brojPrijave = value;
    }

    /**
     * Gets the value of the datumPrijave property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatumPrijave() {
        return datumPrijave;
    }

    /**
     * Sets the value of the datumPrijave property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatumPrijave(XMLGregorianCalendar value) {
        this.datumPrijave = value;
    }

    /**
     * Gets the value of the priloziUzPrijavu property.
     *
     * @return
     *     possible object is
     *     {@link rs.ac.uns.ftn.autorska.PriloziUzPrijavu }
     *
     */
    public PriloziUzPrijavu getPriloziUzPrijavu() {
        return priloziUzPrijavu;
    }

    /**
     * Sets the value of the priloziUzPrijavu property.
     *
     * @param value
     *     allowed object is
     *     {@link rs.ac.uns.ftn.autorska.PriloziUzPrijavu }
     *
     */
    public void setPriloziUzPrijavu(PriloziUzPrijavu value) {
        this.priloziUzPrijavu = value;
    }

    public boolean isPodnosilacAutor() {
        return podnosilacAutor;
    }

    public void setPodnosilacAutor(boolean podnosilacAutor) {
        this.podnosilacAutor = podnosilacAutor;
    }
}
