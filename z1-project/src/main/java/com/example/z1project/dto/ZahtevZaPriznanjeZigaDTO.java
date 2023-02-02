package com.example.z1project.dto;

import com.example.z1project.model.zig.TFizickoLice;
import com.example.z1project.model.zig.TPravnoLice;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZahtevZaPriznanjeZigaDTO {

    @XmlElement
    private PodnosiociPrijaveDTO podnosiociPrijave;
    @XmlElement
    private FizickoLiceDTO punomocnik;
    @XmlElement
    private FizickoLiceDTO fizickiZajednickiPredstavnikPodnosiocaPrijave;
    @XmlElement
    private PravnoLiceDTO pravniZajednickiPredstavnikPodnosiocaPrijave;
    @XmlElement
    private ZigDTO zig;
    @XmlElement
    private KlaseRobeIUslugaDTO klaseRobeIUsluga;
    @XmlElement
    private String pravoPrvenstvaIOsnov;
    @XmlElement
    private PlaceneTakseDTO placeneTakse;
    @XmlElement
    private PodaciOPrijaviDTO podaciOPrijavi;

    public ZahtevZaPriznanjeZigaDTO() {
    }

    public ZahtevZaPriznanjeZigaDTO(PodnosiociPrijaveDTO podnosiociPrijave, FizickoLiceDTO punomocnik,
                                    FizickoLiceDTO fizickiZajednickiPredstavnikPodnosiocaPrijave,
                                    PravnoLiceDTO pravniZajednickiPredstavnikPodnosiocaPrijave, ZigDTO zig,
                                    KlaseRobeIUslugaDTO klaseRobeIUsluga, String pravoPrvenstvaIOsnov,
                                    PlaceneTakseDTO placeneTakse, PodaciOPrijaviDTO podaciOPrijavi) {
        this.podnosiociPrijave = podnosiociPrijave;
        this.punomocnik = punomocnik;
        this.fizickiZajednickiPredstavnikPodnosiocaPrijave = fizickiZajednickiPredstavnikPodnosiocaPrijave;
        this.pravniZajednickiPredstavnikPodnosiocaPrijave = pravniZajednickiPredstavnikPodnosiocaPrijave;
        this.zig = zig;
        this.klaseRobeIUsluga = klaseRobeIUsluga;
        this.pravoPrvenstvaIOsnov = pravoPrvenstvaIOsnov;
        this.placeneTakse = placeneTakse;
        this.podaciOPrijavi = podaciOPrijavi;
    }

    public ZahtevZaPriznanjeZigaDTO(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) {
        this.podnosiociPrijave = new PodnosiociPrijaveDTO(zahtevZaPriznanjeZiga.getPodnosiociPrijave());
        try {
            this.punomocnik = new FizickoLiceDTO(zahtevZaPriznanjeZiga.getPunomocnik());
        } catch (Exception e) {
            this.punomocnik = null;
        }
        try {
            if (zahtevZaPriznanjeZiga.getZajednickiPredstavnikPodnosiocaPrijave() instanceof TFizickoLice) {
                this.fizickiZajednickiPredstavnikPodnosiocaPrijave = new FizickoLiceDTO((TFizickoLice) zahtevZaPriznanjeZiga.getZajednickiPredstavnikPodnosiocaPrijave());
            } else {
                this.pravniZajednickiPredstavnikPodnosiocaPrijave = new PravnoLiceDTO((TPravnoLice) zahtevZaPriznanjeZiga.getZajednickiPredstavnikPodnosiocaPrijave());
            }
        } catch (Exception e) {
            this.fizickiZajednickiPredstavnikPodnosiocaPrijave = null;
            this.pravniZajednickiPredstavnikPodnosiocaPrijave = null;
        }
        this.zig = new ZigDTO(zahtevZaPriznanjeZiga.getZig());
        this.klaseRobeIUsluga = new KlaseRobeIUslugaDTO(zahtevZaPriznanjeZiga.getKlaseRobeIUsluga());
        this.pravoPrvenstvaIOsnov = zahtevZaPriznanjeZiga.getPravoPrvenstvaIOsnov();
        this.placeneTakse = new PlaceneTakseDTO(zahtevZaPriznanjeZiga.getPlaceneTakse());
        this.podaciOPrijavi = new PodaciOPrijaviDTO(zahtevZaPriznanjeZiga.getPodaciOPrijavi());
    }

    public PodnosiociPrijaveDTO getPodnosiociPrijave() {
        return podnosiociPrijave;
    }

    public void setPodnosiociPrijave(PodnosiociPrijaveDTO podnosiociPrijave) {
        this.podnosiociPrijave = podnosiociPrijave;
    }

    public FizickoLiceDTO getPunomocnik() {
        return punomocnik;
    }

    public void setPunomocnik(FizickoLiceDTO punomocnik) {
        this.punomocnik = punomocnik;
    }

    public FizickoLiceDTO getFizickiZajednickiPredstavnikPodnosiocaPrijave() {
        return fizickiZajednickiPredstavnikPodnosiocaPrijave;
    }

    public void setFizickiZajednickiPredstavnikPodnosiocaPrijave(FizickoLiceDTO fizickiZajednickiPredstavnikPodnosiocaPrijave) {
        this.fizickiZajednickiPredstavnikPodnosiocaPrijave = fizickiZajednickiPredstavnikPodnosiocaPrijave;
    }

    public PravnoLiceDTO getPravniZajednickiPredstavnikPodnosiocaPrijave() {
        return pravniZajednickiPredstavnikPodnosiocaPrijave;
    }

    public void setPravniZajednickiPredstavnikPodnosiocaPrijave(PravnoLiceDTO pravniZajednickiPredstavnikPodnosiocaPrijave) {
        this.pravniZajednickiPredstavnikPodnosiocaPrijave = pravniZajednickiPredstavnikPodnosiocaPrijave;
    }

    public ZigDTO getZig() {
        return zig;
    }

    public void setZig(ZigDTO zig) {
        this.zig = zig;
    }

    public KlaseRobeIUslugaDTO getKlaseRobeIUsluga() {
        return klaseRobeIUsluga;
    }

    public void setKlaseRobeIUsluga(KlaseRobeIUslugaDTO klaseRobeIUsluga) {
        this.klaseRobeIUsluga = klaseRobeIUsluga;
    }

    public String getPravoPrvenstvaIOsnov() {
        return pravoPrvenstvaIOsnov;
    }

    public void setPravoPrvenstvaIOsnov(String pravoPrvenstvaIOsnov) {
        this.pravoPrvenstvaIOsnov = pravoPrvenstvaIOsnov;
    }

    public PlaceneTakseDTO getPlaceneTakse() {
        return placeneTakse;
    }

    public void setPlaceneTakse(PlaceneTakseDTO placeneTakse) {
        this.placeneTakse = placeneTakse;
    }

    public PodaciOPrijaviDTO getPodaciOPrijavi() {
        return podaciOPrijavi;
    }

    public void setPodaciOPrijavi(PodaciOPrijaviDTO podaciOPrijavi) {
        this.podaciOPrijavi = podaciOPrijavi;
    }
}
