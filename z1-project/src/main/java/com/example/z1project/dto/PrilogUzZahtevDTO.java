package com.example.z1project.dto;

import com.example.z1project.model.zig.TPrilogUzZahtev;

import javax.xml.bind.annotation.XmlElement;

public class PrilogUzZahtevDTO {

    @XmlElement
    private String nazivDokumenta;
    @XmlElement
    private String putanjaDokumenta;

    public PrilogUzZahtevDTO() {
    }

    public PrilogUzZahtevDTO(String nazivDokumenta) {
    }

    public PrilogUzZahtevDTO(String nazivDokumenta, String putanjaDokumenta) {
        this.nazivDokumenta = nazivDokumenta;
        this.putanjaDokumenta = putanjaDokumenta;
    }

    public PrilogUzZahtevDTO(TPrilogUzZahtev primerakZnaka) {
        this.nazivDokumenta = primerakZnaka.getNazivDokumenta();
        this.putanjaDokumenta = primerakZnaka.getPutanjaDokumenta();
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
