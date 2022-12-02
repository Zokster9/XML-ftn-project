package project.xmlproject.dto.creationDto;

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
