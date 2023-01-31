package com.example.z1project.dto;

public class PravnoLiceDTO extends LiceDTO {

    private String naziv;

    public PravnoLiceDTO() {
    }

    public PravnoLiceDTO(String naziv, AdresaDTO adresa, KontaktPodaciDTO kontaktPodaci) {
        super(adresa, kontaktPodaci);
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
