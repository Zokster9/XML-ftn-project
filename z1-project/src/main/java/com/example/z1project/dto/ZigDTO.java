package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class ZigDTO {

    @XmlElement
    private TipZigaDTO tipZiga;
    @XmlElement
    private TipZnakaDTO tipZnaka;
    @XmlElement
    private IzgledZnakaDTO izgledZnaka;
    @XmlElement
    private NaznaceneBojeDTO naznaceneBoje;
    @XmlElement
    private String transliteracijaZnaka;
    @XmlElement
    private String prevodZnaka;
    @XmlElement
    private String opisZnaka;

    public ZigDTO() {
    }

    public ZigDTO(TipZigaDTO tipZiga, TipZnakaDTO tipZnaka, IzgledZnakaDTO izgledZnaka, NaznaceneBojeDTO naznaceneBoje,
                  String transliteracijaZnaka, String prevodZnaka, String opisZnaka) {
        this.tipZiga = tipZiga;
        this.tipZnaka = tipZnaka;
        this.izgledZnaka = izgledZnaka;
        this.naznaceneBoje = naznaceneBoje;
        this.transliteracijaZnaka = transliteracijaZnaka;
        this.prevodZnaka = prevodZnaka;
        this.opisZnaka = opisZnaka;
    }

    public ZigDTO(ZahtevZaPriznanjeZiga.Zig zig) {
        this.tipZiga = new TipZigaDTO(zig.getTipZiga());
        this.tipZnaka = new TipZnakaDTO(zig.getTipZnaka());
        this.izgledZnaka = new IzgledZnakaDTO(zig.getIzgledZnaka());
        try {
            this.naznaceneBoje = new NaznaceneBojeDTO(zig.getNaznaceneBoje());
        } catch (Exception e) {
            this.naznaceneBoje = null;
        }
        this.transliteracijaZnaka = zig.getTransliteracijaZnaka();
        this.prevodZnaka = zig.getPrevodZnaka();
        this.opisZnaka = zig.getOpisZnaka();
    }

    public TipZigaDTO getTipZiga() {
        return tipZiga;
    }

    public void setTipZiga(TipZigaDTO tipZiga) {
        this.tipZiga = tipZiga;
    }

    public TipZnakaDTO getTipZnaka() {
        return tipZnaka;
    }

    public void setTipZnaka(TipZnakaDTO tipZnaka) {
        this.tipZnaka = tipZnaka;
    }

    public IzgledZnakaDTO getIzgledZnaka() {
        return izgledZnaka;
    }

    public void setIzgledZnaka(IzgledZnakaDTO izgledZnaka) {
        this.izgledZnaka = izgledZnaka;
    }

    public NaznaceneBojeDTO getNaznaceneBoje() {
        return naznaceneBoje;
    }

    public void setNaznaceneBoje(NaznaceneBojeDTO naznaceneBoje) {
        this.naznaceneBoje = naznaceneBoje;
    }

    public String getTransliteracijaZnaka() {
        return transliteracijaZnaka;
    }

    public void setTransliteracijaZnaka(String transliteracijaZnaka) {
        this.transliteracijaZnaka = transliteracijaZnaka;
    }

    public String getPrevodZnaka() {
        return prevodZnaka;
    }

    public void setPrevodZnaka(String prevodZnaka) {
        this.prevodZnaka = prevodZnaka;
    }

    public String getOpisZnaka() {
        return opisZnaka;
    }

    public void setOpisZnaka(String opisZnaka) {
        this.opisZnaka = opisZnaka;
    }
}
