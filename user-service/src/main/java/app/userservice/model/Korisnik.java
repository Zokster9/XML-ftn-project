package app.userservice.model;

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
 *         &lt;element name="korisnickoIme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="korisnikJeSluzbenik" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "korisnickoIme",
        "sifra",
        "ime",
        "prezime",
        "korisnikJeSluzbenik"
})
@XmlRootElement(name = "korisnik")
public class Korisnik {

    @XmlElement(required = true)
    protected String korisnickoIme;
    @XmlElement(required = true)
    protected String sifra;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(required = true)
    protected boolean korisnikJeSluzbenik;

    /**
     * Gets the value of the korisnickoIme property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Sets the value of the korisnickoIme property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKorisnickoIme(String value) {
        this.korisnickoIme = value;
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

    /**
     * Gets the value of the korisnikJeSluzbenik property.
     *
     */
    public boolean isKorisnikJeSluzbenik() {
        return korisnikJeSluzbenik;
    }

    /**
     * Sets the value of the korisnikJeSluzbenik property.
     *
     */
    public void setKorisnikJeSluzbenik(boolean value) {
        this.korisnikJeSluzbenik = value;
    }

}
