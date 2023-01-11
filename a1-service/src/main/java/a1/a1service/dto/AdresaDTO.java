package a1.a1service.dto;

import a1.a1service.model.Adresa;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;

public class AdresaDTO {

    @XmlElement
    private int postanskiBroj;

    @XmlElement
    private String grad;

    @XmlElement
    private String ulica;

    @XmlElement
    private BigInteger broj;

    @XmlElement
    private String drzava;

    public AdresaDTO() {
    }

    public AdresaDTO(Adresa adresa) {
        this.postanskiBroj = adresa.getPostanskiBroj();
        this.grad = adresa.getGrad();
        this.ulica = adresa.getUlica();
        this.broj = adresa.getBroj();
        this.drzava = adresa.getDrzava();
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public String getGrad() {
        return grad;
    }

    public String getUlica() {
        return ulica;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public String getDrzava() {
        return drzava;
    }
}