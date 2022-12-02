package project.xmlproject.dto.creationDto;

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
