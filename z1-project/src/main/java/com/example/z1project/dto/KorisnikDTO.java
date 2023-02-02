package com.example.z1project.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "korisnickoIme",
        "sifra",
        "ime",
        "prezime",
        "korisnikJeSluzbenik"
})
@XmlRootElement
public class KorisnikDTO {

    @XmlElement
    private String korisnickoIme;
    @XmlElement
    private String sifra;
    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;
    @XmlElement
    private boolean korisnikJeSluzbenik;

    public KorisnikDTO() {
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public boolean isKorisnikJeSluzbenik() {
        return korisnikJeSluzbenik;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setKorisnikJeSluzbenik(boolean korisnikJeSluzbenik) {
        this.korisnikJeSluzbenik = korisnikJeSluzbenik;
    }
}
