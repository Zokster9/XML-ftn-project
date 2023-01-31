package com.example.z1project.dto;

public class FizickoLiceDTO extends LiceDTO {

    private String ime;
    private String prezime;

    public FizickoLiceDTO() {
    }

    public FizickoLiceDTO(String ime, String prezime, AdresaDTO adresa, KontaktPodaciDTO kontaktPodaci) {
        super(adresa, kontaktPodaci);
        this.ime = ime;
        this.prezime = prezime;
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
}
