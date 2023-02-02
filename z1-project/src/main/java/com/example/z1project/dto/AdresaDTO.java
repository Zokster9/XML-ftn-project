package com.example.z1project.dto;

import com.example.z1project.model.zig.Adresa;

import javax.xml.bind.annotation.XmlElement;

public class AdresaDTO {

    @XmlElement
    private String ulica;
    @XmlElement
    private String broj;
    @XmlElement
    private int postanskiBroj;
    @XmlElement
    private String mesto;
    @XmlElement
    private String drzava;

    public AdresaDTO() {
    }

    public AdresaDTO(String ulica, String broj, int postanskiBroj, String mesto, String drzava) {
        this.ulica = ulica;
        this.broj = broj;
        this.postanskiBroj = postanskiBroj;
        this.mesto = mesto;
        this.drzava = drzava;
    }

    public AdresaDTO(Adresa adresa) {
        this.ulica = adresa.getUlica();
        this.broj = adresa.getBroj();
        this.postanskiBroj = adresa.getPostanskiBroj();
        this.mesto = adresa.getMesto();
        this.drzava = adresa.getDrzava();
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
}
