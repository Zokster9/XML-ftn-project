package project.xmlproject.model.autorska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriloziUzPrijavu complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PriloziUzPrijavu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="opis_autorskog_dela" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primer_autorskog_dela" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriloziUzPrijavu", propOrder = {
        "opisAutorskogDela",
        "primerAutorskogDela"
})
public class PriloziUzPrijavu {

    @XmlElement(name = "opis_autorskog_dela")
    protected String opisAutorskogDela;
    @XmlElement(name = "primer_autorskog_dela", required = true)
    protected String primerAutorskogDela;

    /**
     * Gets the value of the opisAutorskogDela property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOpisAutorskogDela() {
        return opisAutorskogDela;
    }

    /**
     * Sets the value of the opisAutorskogDela property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOpisAutorskogDela(String value) {
        this.opisAutorskogDela = value;
    }

    /**
     * Gets the value of the primerAutorskogDela property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrimerAutorskogDela() {
        return primerAutorskogDela;
    }

    /**
     * Sets the value of the primerAutorskogDela property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrimerAutorskogDela(String value) {
        this.primerAutorskogDela = value;
    }

}
