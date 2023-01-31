package com.example.z1project.dto;

public class PrilogUzZahtevDTO {

    private String nazivDokumenta;
    private String putanjaDokumenta;

    public PrilogUzZahtevDTO() {
    }

    public PrilogUzZahtevDTO(String nazivDokumenta, String putanjaDokumenta) {
        this.nazivDokumenta = nazivDokumenta;
        this.putanjaDokumenta = putanjaDokumenta;
    }

    public String getNazivDokumenta() {
        return nazivDokumenta;
    }

    public void setNazivDokumenta(String nazivDokumenta) {
        this.nazivDokumenta = nazivDokumenta;
    }

    public String getPutanjaDokumenta() {
        return putanjaDokumenta;
    }

    public void setPutanjaDokumenta(String putanjaDokumenta) {
        this.putanjaDokumenta = putanjaDokumenta;
    }
}
