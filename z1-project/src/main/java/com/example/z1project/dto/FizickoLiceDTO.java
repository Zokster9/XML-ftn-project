package com.example.z1project.dto;

import com.example.z1project.model.zig.TFizickoLice;

import javax.xml.bind.annotation.XmlElement;

public class FizickoLiceDTO {

    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;
    @XmlElement
    private AdresaDTO adresa;
    @XmlElement
    private KontaktPodaciDTO kontaktPodaci;

    public FizickoLiceDTO(String ime) {
        if (!ime.equals("undefined")) {
            this.ime = ime;
        }
    }

    public FizickoLiceDTO() {
    }

    public FizickoLiceDTO(String ime, String prezime, AdresaDTO adresa, KontaktPodaciDTO kontaktPodaci) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.kontaktPodaci = kontaktPodaci;
    }

    public FizickoLiceDTO(TFizickoLice fizickoLice) {
        this.ime = fizickoLice.getIme();
        this.prezime = fizickoLice.getPrezime();
        this.adresa = new AdresaDTO(fizickoLice.getAdresa());
        this.kontaktPodaci = new KontaktPodaciDTO(fizickoLice.getKontaktPodaci());
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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
