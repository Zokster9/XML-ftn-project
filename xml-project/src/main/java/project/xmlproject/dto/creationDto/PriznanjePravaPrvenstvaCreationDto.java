package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.PriznanjePravaPrvenstva;

import java.util.ArrayList;


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

    public PriznanjePravaPrvenstvaCreationDto(ArrayList<String> values){
        this.datumPrijave = values.get(0);
        this.brojRanijePrijave = values.get(1);
        this.dvoslovnaOznakaDrzaveOrganizacije = values.get(2);
    }

    public PriznanjePravaPrvenstvaCreationDto(PriznanjePravaPrvenstva priznanjePravaPrvenstva){

        this.datumPrijave = priznanjePravaPrvenstva.getDatumPrijave();
        this.brojRanijePrijave = priznanjePravaPrvenstva.getBrojRanijePrijave();
        this.dvoslovnaOznakaDrzaveOrganizacije = priznanjePravaPrvenstva.getDvoslovnaOznakaDrzaveOrganizacije();
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
