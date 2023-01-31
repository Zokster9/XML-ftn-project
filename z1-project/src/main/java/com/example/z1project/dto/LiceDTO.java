package com.example.z1project.dto;

public class LiceDTO {

    private AdresaDTO adresa;
    private KontaktPodaciDTO kontaktPodaci;

    public LiceDTO() {
    }

    public LiceDTO(AdresaDTO adresa, KontaktPodaciDTO kontaktPodaci) {
        this.adresa = adresa;
        this.kontaktPodaci = kontaktPodaci;
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
