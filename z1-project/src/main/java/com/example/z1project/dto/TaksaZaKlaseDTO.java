package com.example.z1project.dto;

public class TaksaZaKlaseDTO {

    private double vrednost;
    private int brojKlasa;

    public TaksaZaKlaseDTO() {
    }

    public TaksaZaKlaseDTO(double vrednost, int brojKlasa) {
        this.vrednost = vrednost;
        this.brojKlasa = brojKlasa;
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
