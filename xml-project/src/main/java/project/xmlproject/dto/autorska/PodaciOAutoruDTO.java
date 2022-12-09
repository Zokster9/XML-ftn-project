package project.xmlproject.dto.autorska;

import project.xmlproject.model.autorska.PodaciOAutoru;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;

public class PodaciOAutoruDTO {

    @XmlElement
    private String ime;

    @XmlElement
    private String prezime;

    @XmlElement
    private AdresaDTO adresa;

    @XmlElement
    private String drzavljanstvo;

    @XmlElement
    private String godinaSmrti;

    @XmlElement
    private String znak;

    public PodaciOAutoruDTO() {
    }

    public PodaciOAutoruDTO(PodaciOAutoru podaciOAutoru) {
        this.ime = podaciOAutoru.getIme();
        this.prezime = podaciOAutoru.getPrezime();
        if (podaciOAutoru.getGodinaSmrti() == null) {
            this.adresa = new AdresaDTO(podaciOAutoru.getAdresa());
            this.drzavljanstvo = podaciOAutoru.getDrzavljanstvo();
            this.znak = podaciOAutoru.getZnak();
        }else {
            this.godinaSmrti = podaciOAutoru.getGodinaSmrti();
        }
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public AdresaDTO getAdresa() {
        return adresa;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public String getGodinaSmrti() {
        return godinaSmrti;
    }

    public String getZnak() {
        return znak;
    }
}
