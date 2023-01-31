package com.example.z1project.dto;

public class TipZnakaDTO {

    private boolean verbalniZnak;
    private boolean grafickiZnak;
    private boolean kombinovaniZnak;
    private boolean trodimenzionalniZnak;
    private boolean drugaVrstaZnaka;

    public TipZnakaDTO() {
    }

    public TipZnakaDTO(boolean verbalniZnak, boolean grafickiZnak, boolean kombinovaniZnak, boolean trodimenzionalniZnak, boolean drugaVrstaZnaka) {
        this.verbalniZnak = verbalniZnak;
        this.grafickiZnak = grafickiZnak;
        this.kombinovaniZnak = kombinovaniZnak;
        this.trodimenzionalniZnak = trodimenzionalniZnak;
        this.drugaVrstaZnaka = drugaVrstaZnaka;
    }

    public boolean isVerbalniZnak() {
        return verbalniZnak;
    }

    public void setVerbalniZnak(boolean verbalniZnak) {
        this.verbalniZnak = verbalniZnak;
    }

    public boolean isGrafickiZnak() {
        return grafickiZnak;
    }

    public void setGrafickiZnak(boolean grafickiZnak) {
        this.grafickiZnak = grafickiZnak;
    }

    public boolean isKombinovaniZnak() {
        return kombinovaniZnak;
    }

    public void setKombinovaniZnak(boolean kombinovaniZnak) {
        this.kombinovaniZnak = kombinovaniZnak;
    }

    public boolean isTrodimenzionalniZnak() {
        return trodimenzionalniZnak;
    }

    public void setTrodimenzionalniZnak(boolean trodimenzionalniZnak) {
        this.trodimenzionalniZnak = trodimenzionalniZnak;
    }

    public boolean isDrugaVrstaZnaka() {
        return drugaVrstaZnaka;
    }

    public void setDrugaVrstaZnaka(boolean drugaVrstaZnaka) {
        this.drugaVrstaZnaka = drugaVrstaZnaka;
    }
}
