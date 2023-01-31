package com.example.z1project.dto;

public class KontaktPodaciDTO {

    private String brojTelefona;
    private String email;
    private String brojFaksa;

    public KontaktPodaciDTO() {
    }

    public KontaktPodaciDTO(String brojTelefona, String email, String brojFaksa) {
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.brojFaksa = brojFaksa;
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
