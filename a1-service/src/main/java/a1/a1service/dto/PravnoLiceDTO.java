package a1.a1service.dto;

import a1.a1service.model.TPravnoLice;

import javax.xml.bind.annotation.XmlElement;

public class PravnoLiceDTO {

    @XmlElement
    private String telefon;

    @XmlElement
    private String email;

    @XmlElement
    private String poslovnoIme;

    @XmlElement
    private AdresaDTO sediste;

    public PravnoLiceDTO() {
    }

    public PravnoLiceDTO(TPravnoLice tPravnoLice) {
        this.telefon = tPravnoLice.getTelefon();
        this.email = tPravnoLice.getEmail();
        this.poslovnoIme = tPravnoLice.getPoslovnoIme();
        this.sediste = new AdresaDTO(tPravnoLice.getSediste());
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getPoslovnoIme() {
        return poslovnoIme;
    }

    public AdresaDTO getSediste() {
        return sediste;
    }
}
