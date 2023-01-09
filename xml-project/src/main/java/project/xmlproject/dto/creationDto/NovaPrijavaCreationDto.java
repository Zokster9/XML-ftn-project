package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.NovaPrijava;

import java.sql.Timestamp;

public class NovaPrijavaCreationDto {

    private String brojPrijave;
    private String datumPrijave;
    private String priznatiDatumPrijave;

    public NovaPrijavaCreationDto(String brojPrijave, String datumPrijave, String priznatiDatumPrijave) {
        this.brojPrijave = brojPrijave;
        this.datumPrijave = datumPrijave;
        this.priznatiDatumPrijave = priznatiDatumPrijave;
    }

    public NovaPrijavaCreationDto(NovaPrijava novaPrijava){
        this.brojPrijave = novaPrijava.getBrojPrijave();
        this.datumPrijave = novaPrijava.getDatumPrijave();
        this.priznatiDatumPrijave = novaPrijava.getPriznatiDatumPrijave();
    }

    public NovaPrijavaCreationDto() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String dateAndTime = timestamp.toString().substring(0, 19);
        String date = timestamp.toString().substring(0, 10);
        this.brojPrijave = 'P' + dateAndTime;
        this.datumPrijave = date;
        this.priznatiDatumPrijave = "";
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
