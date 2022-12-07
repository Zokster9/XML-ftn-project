package project.xmlproject.model.autorska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Podaci_o_autoru complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Podaci_o_autoru"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresa" type="{http://www.ftn.uns.ac.rs/autorksa}Adresa" minOccurs="0"/&gt;
 *         &lt;element name="drzavljanstvo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="godina_smrti" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="znak" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Podaci_o_autoru", propOrder = {
        "ime",
        "prezime",
        "adresa",
        "drzavljanstvo",
        "godinaSmrti",
        "znak"
})
public class PodaciOAutoru {

    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    protected Adresa adresa;
    protected String drzavljanstvo;
    @XmlElement(name = "godina_smrti")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar godinaSmrti;
    protected String znak;

    /**
     * Gets the value of the ime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }


    public Adresa getAdresa() {
        return adresa;
    }


    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the drzavljanstvo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDrzavljanstvo(String value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the godinaSmrti property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getGodinaSmrti() {
        return godinaSmrti;
    }

    /**
     * Sets the value of the godinaSmrti property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setGodinaSmrti(XMLGregorianCalendar value) {
        this.godinaSmrti = value;
    }

    /**
     * Gets the value of the znak property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getZnak() {
        return znak;
    }

    /**
     * Sets the value of the znak property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZnak(String value) {
        this.znak = value;
    }

}
