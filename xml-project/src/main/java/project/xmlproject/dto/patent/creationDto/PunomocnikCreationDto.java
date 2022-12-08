package project.xmlproject.dto.patent.creationDto;

import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

public class PunomocnikCreationDto {

    private String tipPunomocnika;
    private Boolean zajednickiPredstavnik;
    private String naziv;
    private AdresaCreationDto adresa;
    private KontaktPodaciCreationDto kontaktPodaci;

    public PunomocnikCreationDto(){

    }

    public PunomocnikCreationDto(String tipPunomocnika, Boolean zajednickiPredstavnik, String naziv, AdresaCreationDto adresa, KontaktPodaciCreationDto kontaktPodaci) {
        this.tipPunomocnika = tipPunomocnika;
        this.zajednickiPredstavnik = zajednickiPredstavnik;
        this.naziv = naziv;
        this.adresa = adresa;
        this.kontaktPodaci = kontaktPodaci;
    }

    public PunomocnikCreationDto(ZahtevZaPriznanjePatenta.Punomocnik punomocnik) {
        if (punomocnik.getTipPunomocnika().getPunomocnikZaZastupanje() != null) {
            this.tipPunomocnika = "zastupanje";
        }
        else
        {
            this.tipPunomocnika = "prijemPismena";
        }
        this.naziv = punomocnik.getNaziv();
        this.adresa = new AdresaCreationDto(punomocnik.getAdresa());
        this.kontaktPodaci = new KontaktPodaciCreationDto(punomocnik.getKontaktPodaci());
        this.zajednickiPredstavnik = punomocnik.isZajednickiPredstavnik();
    }

    public String getTipPunomocnika() {
        return tipPunomocnika;
    }

    public void setTipPunomocnika(String tipPunomocnika) {
        this.tipPunomocnika = tipPunomocnika;
    }

    public Boolean getZajednickiPredstavnik() {
        return zajednickiPredstavnik;
    }

    public void setZajednickiPredstavnik(Boolean zajednickiPredstavnik) {
        this.zajednickiPredstavnik = zajednickiPredstavnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public AdresaCreationDto getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaCreationDto adresa) {
        this.adresa = adresa;
    }

    public KontaktPodaciCreationDto getKontaktPodaci() {
        return kontaktPodaci;
    }

    public void setKontaktPodaci(KontaktPodaciCreationDto kontaktPodaci) {
        this.kontaktPodaci = kontaktPodaci;
    }
}
