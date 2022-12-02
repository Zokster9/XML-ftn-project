package project.xmlproject.dto.creationDto;

public class PodnosilacCreationDto {

    private String naziv;
    private AdresaCreationDto adresa;
    private KontaktPodaciCreationDto kontaktPodaci;
    private String drzavljanstvo;
    private Boolean podnosilacJePronalazac;
    private NacinDostavljanjaCreationDto nacinDostavljanja;

    public PodnosilacCreationDto() {

    }

    public PodnosilacCreationDto(String naziv, AdresaCreationDto adresa, KontaktPodaciCreationDto kontaktPodaci, String drzavljanstvo, Boolean podnosilacJePronalazac, NacinDostavljanjaCreationDto nacinDostavljanja) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.kontaktPodaci = kontaktPodaci;
        this.drzavljanstvo = drzavljanstvo;
        this.podnosilacJePronalazac = podnosilacJePronalazac;
        this.nacinDostavljanja = nacinDostavljanja;
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

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public Boolean getPodnosilacJePronalazac() {
        return podnosilacJePronalazac;
    }

    public void setPodnosilacJePronalazac(Boolean podnosilacJePronalazac) {
        this.podnosilacJePronalazac = podnosilacJePronalazac;
    }

    public NacinDostavljanjaCreationDto getNacinDostavljanja() {
        return nacinDostavljanja;
    }

    public void setNacinDostavljanja(NacinDostavljanjaCreationDto nacinDostavljanja) {
        this.nacinDostavljanja = nacinDostavljanja;
    }
}
