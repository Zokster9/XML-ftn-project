package project.xmlproject.dto.creationDto;

public class NovaPrijavaCreationDto {

    private String brojPrijave;
    private String datumPrijave;
    private String priznatiDatumPrijave;

    public NovaPrijavaCreationDto(){

    }

    public NovaPrijavaCreationDto(String brojPrijave, String datumPrijave, String priznatiDatumPrijave) {
        this.brojPrijave = brojPrijave;
        this.datumPrijave = datumPrijave;
        this.priznatiDatumPrijave = priznatiDatumPrijave;
    }

    public String getBrojPrijave() {
        return brojPrijave;
    }

    public void setBrojPrijave(String brojPrijave) {
        this.brojPrijave = brojPrijave;
    }

    public String getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(String datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getPriznatiDatumPrijave() {
        return priznatiDatumPrijave;
    }

    public void setPriznatiDatumPrijave(String priznatiDatumPrijave) {
        this.priznatiDatumPrijave = priznatiDatumPrijave;
    }
}
