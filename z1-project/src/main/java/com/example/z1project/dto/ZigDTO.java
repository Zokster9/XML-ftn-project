package com.example.z1project.dto;

public class ZigDTO {

    private TipZigaDTO tipZiga;
    private TipZnakaDTO tipZnaka;
    private IzgledZnakaDTO izgledZnaka;
    private NaznaceneBojeDTO naznaceneBoje;
    private String transliteracijaZnaka;
    private String prevodZnaka;
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
