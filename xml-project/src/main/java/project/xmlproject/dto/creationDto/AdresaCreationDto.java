package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.Adresa;

public class AdresaCreationDto {

    private String ulicaIBroj;
    private Integer postanskiBroj;
    private String mesto;
    private String drzava;

    public AdresaCreationDto(){

    }

    public AdresaCreationDto(String ulicaIBroj, Integer postanskiBroj, String mesto, String drzava) {
        this.ulicaIBroj = ulicaIBroj;
        this.postanskiBroj = postanskiBroj;
        this.mesto = mesto;
        this.drzava = drzava;
    }

    public AdresaCreationDto(Adresa adresa) {
        this.ulicaIBroj = adresa.getUlicaIBroj();
        this.postanskiBroj = adresa.getPostanskiBroj();
        this.mesto = adresa.getMesto();
        this.drzava = adresa.getDrzava();
    }

    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    public void setUlicaIBroj(String ulicaIBroj) {
        this.ulicaIBroj = ulicaIBroj;
    }

    public Integer getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Integer postanskiBroj) {
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
