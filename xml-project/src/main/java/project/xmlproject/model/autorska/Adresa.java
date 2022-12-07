package project.xmlproject.model.autorska;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Adresa complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Adresa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="postanski_broj"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="11000"/&gt;
 *               &lt;maxInclusive value="40000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresa", propOrder = {
        "postanskiBroj",
        "grad",
        "ulica",
        "broj",
        "drzava"
})
public class Adresa {

    @XmlElement(name = "postanski_broj")
    protected int postanskiBroj;
    @XmlElement(required = true)
    protected String grad;
    @XmlElement(required = true)
    protected String ulica;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger broj;
    @XmlElement(required = true)
    protected String drzava;

    /**
     * Gets the value of the postanskiBroj property.
     *
     */
    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Sets the value of the postanskiBroj property.
     *
     */
    public void setPostanskiBroj(int value) {
        this.postanskiBroj = value;
    }

    /**
     * Gets the value of the grad property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    /**
     * Gets the value of the ulica property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the broj property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setBroj(BigInteger value) {
        this.broj = value;
    }

    /**
     * Gets the value of the drzava property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }

}
