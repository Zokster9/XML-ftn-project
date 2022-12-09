package project.xmlproject.dto.autorska;

import project.xmlproject.model.autorska.TFizickoLice;

import javax.xml.bind.annotation.XmlElement;

public class FizickoLiceDTO {

    @XmlElement
    private String telefon;

    @XmlElement
    private String email;

    @XmlElement
    private String ime;

    @XmlElement
    private String prezime;

    @XmlElement
    private AdresaDTO adresaLica;

    @XmlElement
    private String drzavljanstvo;

    public FizickoLiceDTO() {
    }

    public FizickoLiceDTO(TFizickoLice tFizickoLice) {
        this.telefon = tFizickoLice.getTelefon();
        this.email = tFizickoLice.getEmail();
        this.ime = tFizickoLice.getIme();
        this.prezime = tFizickoLice.getPrezime();
        this.adresaLica = new AdresaDTO(tFizickoLice.getAdresaLica());
        this.drzavljanstvo = tFizickoLice.getDrzavljanstvo();
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public AdresaDTO getAdresaLica() {
        return adresaLica;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }
}
