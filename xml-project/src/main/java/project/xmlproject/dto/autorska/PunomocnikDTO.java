package project.xmlproject.dto.autorska;


import project.xmlproject.model.autorska.Punomocnik;

import javax.xml.bind.annotation.XmlElement;

public class PunomocnikDTO {

    @XmlElement
    private String ime;

    @XmlElement
    private String prezime;

    @XmlElement
    private AdresaDTO adresa;

    public PunomocnikDTO() {
    }

    public PunomocnikDTO(Punomocnik punomocnik) {
        this.ime = punomocnik.getIme();
        this.prezime = punomocnik.getPrezime();
        this.adresa = new AdresaDTO(punomocnik.getAdresa());
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public AdresaDTO getAdresa() {
        return adresa;
    }
}
