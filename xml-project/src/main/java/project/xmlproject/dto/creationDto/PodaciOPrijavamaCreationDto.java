package project.xmlproject.dto.creationDto;

import java.util.ArrayList;

public class PodaciOPrijavamaCreationDto {

    private NovaPrijavaCreationDto novaPrijava;
    private DodatnaPrijavaCreationDto dodatnaPrijava;
    private ArrayList<PriznanjePravaPrvenstvaCreationDto> priznanjaPravaPrvenstva;

    public PodaciOPrijavamaCreationDto(){

    }

    public PodaciOPrijavamaCreationDto(NovaPrijavaCreationDto novaPrijava, DodatnaPrijavaCreationDto dodatnaPrijava, ArrayList<PriznanjePravaPrvenstvaCreationDto> priznanjaPravaPrvenstva) {
        this.novaPrijava = novaPrijava;
        this.dodatnaPrijava = dodatnaPrijava;
        this.priznanjaPravaPrvenstva = priznanjaPravaPrvenstva;
    }

    public NovaPrijavaCreationDto getNovaPrijava() {
        return novaPrijava;
    }

    public void setNovaPrijava(NovaPrijavaCreationDto novaPrijava) {
        this.novaPrijava = novaPrijava;
    }

    public DodatnaPrijavaCreationDto getDodatnaPrijava() {
        return dodatnaPrijava;
    }

    public void setDodatnaPrijava(DodatnaPrijavaCreationDto dodatnaPrijava) {
        this.dodatnaPrijava = dodatnaPrijava;
    }

    public ArrayList<PriznanjePravaPrvenstvaCreationDto> getPriznanjaPravaPrvenstva() {
        return priznanjaPravaPrvenstva;
    }

    public void setPriznanjaPravaPrvenstva(ArrayList<PriznanjePravaPrvenstvaCreationDto> priznanjaPravaPrvenstva) {
        this.priznanjaPravaPrvenstva = priznanjaPravaPrvenstva;
    }
}
