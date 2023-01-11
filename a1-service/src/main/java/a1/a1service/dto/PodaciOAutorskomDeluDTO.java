package a1.a1service.dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

import a1.a1service.model.PodaciOAutorskomDelu;
import a1.a1service.model.PodaciOAutoru;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PodaciOAutorskomDeluDTO {

    @XmlElement
    private String naslov;

    @XmlElement
    private String alternativniNaslov;

    @XmlElement
    private String vrsta;

    @XmlElement
    private String formaZapisa;

    @XmlElement
    private Boolean stvorenoURadnomOdnosu;

    @XmlElement
    private boolean anonimniAutor;

    @JacksonXmlProperty(localName = "autori")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PodaciOAutoruDTO> autori;

    @XmlElement
    private String naslovAutorskogDelaPrerade;

    @XmlElement
    private String nacinKoriscenja;

    public PodaciOAutorskomDeluDTO() {
        autori = new ArrayList<>();
    }

    public PodaciOAutorskomDeluDTO(PodaciOAutorskomDelu podaciOAutorskomDelu) {
        this.naslov = podaciOAutorskomDelu.getNaslov();
        this.alternativniNaslov = podaciOAutorskomDelu.getAlternativniNaslov();
        this.vrsta = podaciOAutorskomDelu.getVrsta();
        this.formaZapisa = podaciOAutorskomDelu.getFormaZapisa();
        this.stvorenoURadnomOdnosu = podaciOAutorskomDelu.isStvorenoURadnomOdnosu();
        this.anonimniAutor = podaciOAutorskomDelu.isAnonimniAutor();
        if (!this.anonimniAutor) {
            this.autori = new ArrayList<>();
            for (PodaciOAutoru podaciOAutoru: podaciOAutorskomDelu.getAutori()) {
                this.autori.add(new PodaciOAutoruDTO(podaciOAutoru));
            }
        }
        this.naslovAutorskogDelaPrerade = podaciOAutorskomDelu.getNaslovAutorskogDelaPrerade();
        this.nacinKoriscenja = podaciOAutorskomDelu.getNacinKoriscenja();
    }

    public String getNaslov() {
        return naslov;
    }

    public String getAlternativniNaslov() {
        return alternativniNaslov;
    }

    public String getVrsta() {
        return vrsta;
    }

    public String getFormaZapisa() {
        return formaZapisa;
    }

    public Boolean getStvorenoURadnomOdnosu() {
        return stvorenoURadnomOdnosu;
    }

    public boolean isAnonimniAutor() {
        return anonimniAutor;
    }

    public List<PodaciOAutoruDTO> getAutori() {
        return autori;
    }

    public String getNaslovAutorskogDelaPrerade() {
        return naslovAutorskogDelaPrerade;
    }

    public String getNacinKoriscenja() {
        return nacinKoriscenja;
    }
}
