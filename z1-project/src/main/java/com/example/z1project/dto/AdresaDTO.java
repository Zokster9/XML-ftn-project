package com.example.z1project.dto;

public class AdresaDTO {

    private String ulica;
    private String broj;
    private int postanskiBroj;
    private String mesto;
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
