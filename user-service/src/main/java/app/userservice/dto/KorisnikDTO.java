package app.userservice.dto;


import app.userservice.model.Korisnik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

    public KorisnikDTO(Korisnik korisnik) {
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.sifra = korisnik.getSifra();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnikJeSluzbenik = korisnik.isKorisnikJeSluzbenik();
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
}
