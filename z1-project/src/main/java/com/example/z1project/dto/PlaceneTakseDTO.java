package com.example.z1project.dto;

public class PlaceneTakseDTO {

    private double osnovnaTaksa;
    private TaksaZaKlaseDTO taksaZaKlase;
    private double taksaZaGrafickoResenje;
    private double ukupnaTaksa;

    public PlaceneTakseDTO() {
    }

    public PlaceneTakseDTO(double osnovnaTaksa, TaksaZaKlaseDTO taksaZaKlase, double taksaZaGrafickoResenje, double ukupnaTaksa) {
        this.osnovnaTaksa = osnovnaTaksa;
        this.taksaZaKlase = taksaZaKlase;
        this.taksaZaGrafickoResenje = taksaZaGrafickoResenje;
        this.ukupnaTaksa = ukupnaTaksa;
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
