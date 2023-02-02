package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class TaksaZaKlaseDTO {

    @XmlElement
    private double vrednost;
    @XmlElement
    private int brojKlasa;

    public TaksaZaKlaseDTO() {
    }

    public TaksaZaKlaseDTO(double vrednost, int brojKlasa) {
        this.vrednost = vrednost;
        this.brojKlasa = brojKlasa;
    }

    public TaksaZaKlaseDTO(ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase taksaZaKlase) {
        this.vrednost = taksaZaKlase.getVrednost();
        this.brojKlasa = taksaZaKlase.getBrojKlasa();
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public int getBrojKlasa() {
        return brojKlasa;
    }

    public void setBrojKlasa(int brojKlasa) {
        this.brojKlasa = brojKlasa;
    }
}
