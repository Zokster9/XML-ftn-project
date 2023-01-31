package com.example.z1project.dto;

public class TipZigaDTO {

    private boolean individualniZig;
    private boolean kolektivniZig;
    private boolean zigGarancije;

    public TipZigaDTO() {
    }

    public TipZigaDTO(boolean individualniZig, boolean kolektivniZig, boolean zigGarancije) {
        this.individualniZig = individualniZig;
        this.kolektivniZig = kolektivniZig;
        this.zigGarancije = zigGarancije;
    }

    public boolean isIndividualniZig() {
        return individualniZig;
    }

    public void setIndividualniZig(boolean individualniZig) {
        this.individualniZig = individualniZig;
    }

    public boolean isKolektivniZig() {
        return kolektivniZig;
    }

    public void setKolektivniZig(boolean kolektivniZig) {
        this.kolektivniZig = kolektivniZig;
    }

    public boolean isZigGarancije() {
        return zigGarancije;
    }

    public void setZigGarancije(boolean zigGarancije) {
        this.zigGarancije = zigGarancije;
    }
}
