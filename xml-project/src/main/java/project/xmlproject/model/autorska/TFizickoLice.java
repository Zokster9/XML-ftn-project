package project.xmlproject.model.autorska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TFizicko_lice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TFizicko_lice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/autorksa}TLice"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresa_lica" type="{http://www.ftn.uns.ac.rs/autorksa}Adresa"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TFizicko_lice", propOrder = {
        "ime",
        "prezime",
        "adresaLica",
        "drzavljanstvo"
})
public class TFizickoLice
        extends TLice
{

    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(name = "adresa_lica", required = true)
    protected Adresa adresaLica;
    @XmlElement(required = true)
    protected String drzavljanstvo;

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


    public Adresa getAdresaLica() {
        return adresaLica;
    }


    public void setAdresaLica(Adresa value) {
        this.adresaLica = value;
    }

    public String getDrzavljanstvo() { return drzavljanstvo; }

    public void setDrzavljanstvo(String value) { this.drzavljanstvo = value; }

}
