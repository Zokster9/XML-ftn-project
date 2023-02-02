package com.example.z1project.dto;

import com.example.z1project.model.zig.KontaktPodaci;

import javax.xml.bind.annotation.XmlElement;

public class KontaktPodaciDTO {

    @XmlElement
    private String brojTelefona;
    @XmlElement
    private String email;
    @XmlElement
    private String brojFaksa;

    public KontaktPodaciDTO() {
    }

    public KontaktPodaciDTO(String brojTelefona, String email, String brojFaksa) {
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.brojFaksa = brojFaksa;
    }

    public KontaktPodaciDTO(KontaktPodaci kontaktPodaci) {
        this.brojTelefona = kontaktPodaci.getBrojTelefona();
        this.email = kontaktPodaci.getEmail();
        this.brojFaksa = kontaktPodaci.getBrojFaksa();
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojFaksa() {
        return brojFaksa;
    }

    public void setBrojFaksa(String brojFaksa) {
        this.brojFaksa = brojFaksa;
    }
}
