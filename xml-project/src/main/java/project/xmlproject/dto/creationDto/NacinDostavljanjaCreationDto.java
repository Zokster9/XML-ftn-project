package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

public class NacinDostavljanjaCreationDto {

    private String nacinDostavljanja;
    private String email;
    private AdresaCreationDto adresa;

    public NacinDostavljanjaCreationDto() {

    }

    public NacinDostavljanjaCreationDto(String nacinDostavljanja, String email, AdresaCreationDto adresa) {
        this.nacinDostavljanja = nacinDostavljanja;
        this.email = email;
        this.adresa = adresa;
    }

    public NacinDostavljanjaCreationDto(ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja nacinDostavljanja){
        if (nacinDostavljanja.getElektronski() != null) {
            this.nacinDostavljanja = "elektronski";
            this.email = nacinDostavljanja.getElektronski().getEmail();
            this.adresa = null;
        } else {
            this.nacinDostavljanja = "papirni";
            this.email = null;
            this.adresa = new AdresaCreationDto(nacinDostavljanja.getPapirni().getAdresa());
        }
    }

    public String getNacinDostavljanja() {
        return nacinDostavljanja;
    }

    public void setNacinDostavljanja(String nacinDostavljanja) {
        this.nacinDostavljanja = nacinDostavljanja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdresaCreationDto getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaCreationDto adresa) {
        this.adresa = adresa;
    }
}
