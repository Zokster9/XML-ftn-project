package com.example.z1project.dto;

public class ZahtevZaPriznanjeZigaDTO {

    private PodnosiociPrijaveDTO podnosiociPrijave;
    private LiceDTO punomocnik;
    private LiceDTO zajednickiPredstavnikPodnosiocaPrijave;
    private ZigDTO zig;
    private KlaseRobeIUslugaDTO klaseRobeIUsluga;
    private String pravoPrvenstvaIOsnov;
    private PlaceneTakseDTO placeneTakse;
    private PodaciOPrijaviDTO podaciOPrijavi;

    public ZahtevZaPriznanjeZigaDTO() {
    }

    public ZahtevZaPriznanjeZigaDTO(PodnosiociPrijaveDTO podnosiociPrijave, LiceDTO punomocnik,
                                    LiceDTO zajednickiPredstavnikPodnosiocaPrijave, ZigDTO zig,
                                    KlaseRobeIUslugaDTO klaseRobeIUsluga, String pravoPrvenstvaIOsnov,
                                    PlaceneTakseDTO placeneTakse, PodaciOPrijaviDTO podaciOPrijavi) {
        this.podnosiociPrijave = podnosiociPrijave;
        this.punomocnik = punomocnik;
        this.zajednickiPredstavnikPodnosiocaPrijave = zajednickiPredstavnikPodnosiocaPrijave;
        this.zig = zig;
        this.klaseRobeIUsluga = klaseRobeIUsluga;
        this.pravoPrvenstvaIOsnov = pravoPrvenstvaIOsnov;
        this.placeneTakse = placeneTakse;
        this.podaciOPrijavi = podaciOPrijavi;
    }

    public PodnosiociPrijaveDTO getPodnosiociPrijave() {
        return podnosiociPrijave;
    }

    public void setPodnosiociPrijave(PodnosiociPrijaveDTO podnosiociPrijave) {
        this.podnosiociPrijave = podnosiociPrijave;
    }

    public LiceDTO getPunomocnik() {
        return punomocnik;
    }

    public void setPunomocnik(LiceDTO punomocnik) {
        this.punomocnik = punomocnik;
    }

    public LiceDTO getZajednickiPredstavnikPodnosiocaPrijave() {
        return zajednickiPredstavnikPodnosiocaPrijave;
    }

    public void setZajednickiPredstavnikPodnosiocaPrijave(LiceDTO zajednickiPredstavnikPodnosiocaPrijave) {
        this.zajednickiPredstavnikPodnosiocaPrijave = zajednickiPredstavnikPodnosiocaPrijave;
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
