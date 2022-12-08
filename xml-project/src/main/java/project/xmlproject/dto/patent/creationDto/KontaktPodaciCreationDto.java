package project.xmlproject.dto.patent.creationDto;

import project.xmlproject.model.patent.KontaktPodaci;

public class KontaktPodaciCreationDto {

    private String brojTelefona;
    private String brojFaksa;
    private String ePosta;

    public KontaktPodaciCreationDto() {
    }

    public KontaktPodaciCreationDto(String brojTelefona, String brojFaksa, String ePosta) {
        this.brojTelefona = brojTelefona;
        this.brojFaksa = brojFaksa;
        this.ePosta = ePosta;
    }

    public KontaktPodaciCreationDto(KontaktPodaci kontaktPodaci) {
        this.brojTelefona = kontaktPodaci.getBrojTelefona();
        this.brojFaksa = kontaktPodaci.getBrojFaksa();
        this.ePosta = kontaktPodaci.getEPosta();
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getBrojFaksa() {
        return brojFaksa;
    }

    public void setBrojFaksa(String brojFaksa) {
        this.brojFaksa = brojFaksa;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }
}
