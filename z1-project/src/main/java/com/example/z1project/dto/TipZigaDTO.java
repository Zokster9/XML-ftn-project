package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class TipZigaDTO {

    @XmlElement
    private boolean individualniZig;
    @XmlElement
    private boolean kolektivniZig;
    @XmlElement
    private boolean zigGarancije;

    public TipZigaDTO() {
    }

    public TipZigaDTO(boolean individualniZig, boolean kolektivniZig, boolean zigGarancije) {
        this.individualniZig = individualniZig;
        this.kolektivniZig = kolektivniZig;
        this.zigGarancije = zigGarancije;
    }

    public TipZigaDTO(ZahtevZaPriznanjeZiga.Zig.TipZiga tipZiga) {
        this.individualniZig = tipZiga.isIndividualniZig();
        try {
            this.kolektivniZig = tipZiga.isKolektivniZig();
        } catch (Exception e) {
            this.kolektivniZig = false;
        }
        try {
            this.zigGarancije = tipZiga.isZigGarancije();
        } catch (Exception e) {
            this.zigGarancije = false;
        }
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
