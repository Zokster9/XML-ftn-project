package a1.a1service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPravno_lice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TPravno_lice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/autorksa}TLice"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sediste" type="{http://www.ftn.uns.ac.rs/autorksa}Adresa"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPravno_lice", propOrder = {
        "poslovnoIme",
        "sediste"
})
public class TPravnoLice
        extends TLice
{

    @XmlElement(name = "poslovno_ime", required = true)
    protected String poslovnoIme;
    @XmlElement(required = true)
    protected Adresa sediste;

    /**
     * Gets the value of the poslovnoIme property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPoslovnoIme() {
        return poslovnoIme;
    }

    /**
     * Sets the value of the poslovnoIme property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPoslovnoIme(String value) {
        this.poslovnoIme = value;
    }


    public Adresa getSediste() {
        return sediste;
    }


    public void setSediste(Adresa value) {
        this.sediste = value;
    }

}
