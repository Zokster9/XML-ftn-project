package project.xmlproject.dto.autorska;

import project.xmlproject.model.autorska.PriloziUzPrijavu;

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
