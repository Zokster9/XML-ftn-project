package project.xmlproject.dto.creationDto;

public class PriznanjePravaPrvenstvaCreationDto {

    private String datumPrijave;
    private String brojRanijePrijave;
    private String dvoslovnaOznakaDrzaveOrganizacije;

    public PriznanjePravaPrvenstvaCreationDto(){

    }

    public PriznanjePravaPrvenstvaCreationDto(String datumPrijave, String brojRanijePrijave, String dvoslovnaOznakaDrzaveOrganizacije) {
        this.datumPrijave = datumPrijave;
        this.brojRanijePrijave = brojRanijePrijave;
        this.dvoslovnaOznakaDrzaveOrganizacije = dvoslovnaOznakaDrzaveOrganizacije;
    }

    public String getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(String datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getBrojRanijePrijave() {
        return brojRanijePrijave;
    }

    public void setBrojRanijePrijave(String brojRanijePrijave) {
        this.brojRanijePrijave = brojRanijePrijave;
    }

    public String getDvoslovnaOznakaDrzaveOrganizacije() {
        return dvoslovnaOznakaDrzaveOrganizacije;
    }

    public void setDvoslovnaOznakaDrzaveOrganizacije(String dvoslovnaOznakaDrzaveOrganizacije) {
        this.dvoslovnaOznakaDrzaveOrganizacije = dvoslovnaOznakaDrzaveOrganizacije;
    }
}
