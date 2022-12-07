package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

public class PronalazacCreationDto {

    private String naziv;
    private AdresaCreationDto adresa;
    private KontaktPodaciCreationDto kontaktPodaci;
    private Boolean zeliBitiUPrijavi;

    public PronalazacCreationDto(){

    }

    public PronalazacCreationDto(String naziv, AdresaCreationDto adresa, KontaktPodaciCreationDto kontaktPodaci, Boolean zeliBitiUPrijavi) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.kontaktPodaci = kontaktPodaci;
        this.zeliBitiUPrijavi = zeliBitiUPrijavi;
    }

    public PronalazacCreationDto(ZahtevZaPriznanjePatenta.Pronalazac pronalazac) {
        this.naziv = pronalazac.getNaziv();
        this.adresa = new AdresaCreationDto(pronalazac.getAdresa());
        this.kontaktPodaci = new KontaktPodaciCreationDto(pronalazac.getKontaktPodaci());
        this.zeliBitiUPrijavi = pronalazac.isZeliBitiUPrijavi();
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

    public Boolean getZeliBitiUPrijavi() {
        return zeliBitiUPrijavi;
    }

    public void setZeliBitiUPrijavi(Boolean zeliBitiUPrijavi) {
        this.zeliBitiUPrijavi = zeliBitiUPrijavi;
    }
}
