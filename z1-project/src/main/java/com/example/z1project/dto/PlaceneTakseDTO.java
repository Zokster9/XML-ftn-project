package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class PlaceneTakseDTO {

    @XmlElement
    private double osnovnaTaksa;
    @XmlElement
    private TaksaZaKlaseDTO taksaZaKlase;
    @XmlElement
    private double taksaZaGrafickoResenje;
    @XmlElement
    private double ukupnaTaksa;

    public PlaceneTakseDTO() {
    }

    public PlaceneTakseDTO(double osnovnaTaksa, TaksaZaKlaseDTO taksaZaKlase, double taksaZaGrafickoResenje, double ukupnaTaksa) {
        this.osnovnaTaksa = osnovnaTaksa;
        this.taksaZaKlase = taksaZaKlase;
        this.taksaZaGrafickoResenje = taksaZaGrafickoResenje;
        this.ukupnaTaksa = ukupnaTaksa;
    }

    public PlaceneTakseDTO(ZahtevZaPriznanjeZiga.PlaceneTakse placeneTakse) {
        this.osnovnaTaksa = placeneTakse.getOsnovnaTaksa();
        this.taksaZaKlase = new TaksaZaKlaseDTO(placeneTakse.getTaksaZaKlase());
        this.taksaZaGrafickoResenje = placeneTakse.getTaksaZaGrafickoResenje();
        this.ukupnaTaksa = placeneTakse.getUkupnaTaksa();
    }

    public double getOsnovnaTaksa() {
        return osnovnaTaksa;
    }

    public void setOsnovnaTaksa(double osnovnaTaksa) {
        this.osnovnaTaksa = osnovnaTaksa;
    }

    public TaksaZaKlaseDTO getTaksaZaKlase() {
        return taksaZaKlase;
    }

    public void setTaksaZaKlase(TaksaZaKlaseDTO taksaZaKlase) {
        this.taksaZaKlase = taksaZaKlase;
    }

    public double getTaksaZaGrafickoResenje() {
        return taksaZaGrafickoResenje;
    }

    public void setTaksaZaGrafickoResenje(double taksaZaGrafickoResenje) {
        this.taksaZaGrafickoResenje = taksaZaGrafickoResenje;
    }

    public double getUkupnaTaksa() {
        return ukupnaTaksa;
    }

    public void setUkupnaTaksa(double ukupnaTaksa) {
        this.ukupnaTaksa = ukupnaTaksa;
    }
}
