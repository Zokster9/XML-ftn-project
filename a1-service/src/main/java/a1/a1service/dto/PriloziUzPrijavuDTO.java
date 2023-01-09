package a1.a1service.dto;

import a1.a1service.model.PriloziUzPrijavu;

import javax.xml.bind.annotation.XmlElement;

public class PriloziUzPrijavuDTO {

    @XmlElement
    private String opisAutorskogDela;

    @XmlElement
    private String primerAutorskogDela;

    public PriloziUzPrijavuDTO() {
    }

    public PriloziUzPrijavuDTO(PriloziUzPrijavu priloziUzPrijavu) {
        this.opisAutorskogDela = priloziUzPrijavu.getOpisAutorskogDela();
        this.primerAutorskogDela = priloziUzPrijavu.getPrimerAutorskogDela();
    }

    public String getOpisAutorskogDela() {
        return opisAutorskogDela;
    }

    public String getPrimerAutorskogDela() {
        return primerAutorskogDela;
    }
}
