package project.xmlproject.model.autorska;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Podaci_o_autorskom_delu complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Podaci_o_autorskom_delu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alternativni_naslov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="vrsta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="forma_zapisa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="stvoreno_u_radnom_odnosu" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="anonimni_autor"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="autori" type="{http://www.ftn.uns.ac.rs/autorksa}Podaci_o_autoru" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="naslov_autorskog_dela_prerade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Podaci_o_autorskom_delu", propOrder = {
        "naslov",
        "alternativniNaslov",
        "vrsta",
        "formaZapisa",
        "stvorenoURadnomOdnosu",
        "anonimniAutor",
        "autori",
        "naslovAutorskogDelaPrerade"
})
public class PodaciOAutorskomDelu {

    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "alternativni_naslov")
    protected String alternativniNaslov;
    @XmlElement(required = true)
    protected String vrsta;
    @XmlElement(name = "forma_zapisa", required = true)
    protected String formaZapisa;
    @XmlElement(name = "stvoreno_u_radnom_odnosu")
    protected Boolean stvorenoURadnomOdnosu;
    @XmlElement(name = "anonimni_autor")
    protected boolean anonimniAutor;
    protected List<PodaciOAutoru> autori;
    @XmlElement(name = "naslov_autorskog_dela_prerade")
    protected String naslovAutorskogDelaPrerade;

    /**
     * Gets the value of the naslov property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the alternativniNaslov property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAlternativniNaslov() {
        return alternativniNaslov;
    }

    /**
     * Sets the value of the alternativniNaslov property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAlternativniNaslov(String value) {
        this.alternativniNaslov = value;
    }

    /**
     * Gets the value of the vrsta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVrsta() {
        return vrsta;
    }

    /**
     * Sets the value of the vrsta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVrsta(String value) {
        this.vrsta = value;
    }

    /**
     * Gets the value of the formaZapisa property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFormaZapisa() {
        return formaZapisa;
    }

    /**
     * Sets the value of the formaZapisa property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFormaZapisa(String value) {
        this.formaZapisa = value;
    }

    /**
     * Gets the value of the stvorenoURadnomOdnosu property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isStvorenoURadnomOdnosu() {
        return stvorenoURadnomOdnosu;
    }

    /**
     * Sets the value of the stvorenoURadnomOdnosu property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setStvorenoURadnomOdnosu(Boolean value) {
        this.stvorenoURadnomOdnosu = value;
    }

    /**
     * Gets the value of the anonimniAutor property.
     *
     */
    public boolean isAnonimniAutor() {
        return anonimniAutor;
    }

    /**
     * Sets the value of the anonimniAutor property.
     *
     */
    public void setAnonimniAutor(boolean value) {
        this.anonimniAutor = value;
    }

    /**
     * Gets the value of the autori property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autori property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutori().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PodaciOAutoru }
     *
     *
     */
    public List<PodaciOAutoru> getAutori() {
        if (autori == null) {
            autori = new ArrayList<PodaciOAutoru>();
        }
        return this.autori;
    }

    public void setAutori(List<PodaciOAutoru> value) {this.autori = value;}

    /**
     * Gets the value of the naslovAutorskogDelaPrerade property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaslovAutorskogDelaPrerade() {
        return naslovAutorskogDelaPrerade;
    }

    /**
     * Sets the value of the naslovAutorskogDelaPrerade property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaslovAutorskogDelaPrerade(String value) {
        this.naslovAutorskogDelaPrerade = value;
    }

}
