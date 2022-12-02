package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.DodatnaPrijava;

public class DodatnaPrijavaCreationDto {

    private String tipPrijave;
    private String brojPrvobitnePrijave;
    private String datumPodnosenjaPrijave;

    public DodatnaPrijavaCreationDto(){

    }

    public DodatnaPrijavaCreationDto(String tipPrijave, String brojPrvobitnePrijave, String datumPodnosenjaPrijave) {
        this.tipPrijave = tipPrijave;
        this.brojPrvobitnePrijave = brojPrvobitnePrijave;
        this.datumPodnosenjaPrijave = datumPodnosenjaPrijave;
    }

    public String getTipPrijave() {
        return tipPrijave;
    }

    public void setTipPrijave(String tipPrijave) {
        this.tipPrijave = tipPrijave;
    }

    public String getBrojPrvobitnePrijave() {
        return brojPrvobitnePrijave;
    }

    public void setBrojPrvobitnePrijave(String brojPrvobitnePrijave) {
        this.brojPrvobitnePrijave = brojPrvobitnePrijave;
    }

    public String getDatumPodnosenjaPrijave() {
        return datumPodnosenjaPrijave;
    }

    public void setDatumPodnosenjaPrijave(String datumPodnosenjaPrijave) {
        this.datumPodnosenjaPrijave = datumPodnosenjaPrijave;
    }
}
