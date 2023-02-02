package com.example.z1project.dto;

import com.example.z1project.model.zig.TPravnoLice;

import javax.xml.bind.annotation.XmlElement;

public class PravnoLiceDTO {

    @XmlElement
    private String naziv;
    @XmlElement
    private AdresaDTO adresa;
    @XmlElement
    private KontaktPodaciDTO kontaktPodaci;

    public PravnoLiceDTO() {

    }

    public PravnoLiceDTO(String naziv) {
        if (!naziv.equals("undefined")) {
            this.naziv = naziv;
        }
    }

    public PravnoLiceDTO(String naziv, AdresaDTO adresa, KontaktPodaciDTO kontaktPodaci) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.kontaktPodaci = kontaktPodaci;
    }

    public PravnoLiceDTO(TPravnoLice pravnoLice) {
        this.naziv = pravnoLice.getNaziv();
        this.adresa = new AdresaDTO(pravnoLice.getAdresa());
        this.kontaktPodaci = new KontaktPodaciDTO(pravnoLice.getKontaktPodaci());
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public AdresaDTO getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaDTO adresa) {
        this.adresa = adresa;
    }

    public KontaktPodaciDTO getKontaktPodaci() {
        return kontaktPodaci;
    }

    public void setKontaktPodaci(KontaktPodaciDTO kontaktPodaci) {
        this.kontaktPodaci = kontaktPodaci;
    }
}
