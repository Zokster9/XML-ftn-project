package project.xmlproject.dto.creationDto;

import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZahtevZaPriznanjePatentaCreationDto {

    private PodaciOPrijavamaCreationDto podaciOPrijavama;
    private NazivPronalaskaCreationDto nazivPronalaska;
    private PodnosilacCreationDto podnosilac;
    private PronalazacCreationDto pronalazac;
    private PunomocnikCreationDto punomocnik;

    public ZahtevZaPriznanjePatentaCreationDto() {

    }

    public ZahtevZaPriznanjePatentaCreationDto(PodaciOPrijavamaCreationDto podaciOPrijavama, NazivPronalaskaCreationDto nazivPronalaska, PodnosilacCreationDto podnosilac, PronalazacCreationDto pronalazac, PunomocnikCreationDto punomocnik) {
        this.podaciOPrijavama = podaciOPrijavama;
        this.nazivPronalaska = nazivPronalaska;
        this.podnosilac = podnosilac;
        this.pronalazac = pronalazac;
        this.punomocnik = punomocnik;
    }

    public ZahtevZaPriznanjePatentaCreationDto(ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta, String mode) {
        this.podaciOPrijavama = new PodaciOPrijavamaCreationDto(zahtevZaPriznanjePatenta.getPodaciOPrijavama(), mode);
        this.nazivPronalaska = new NazivPronalaskaCreationDto(zahtevZaPriznanjePatenta.getNazivPronalaska());
        this.podnosilac = new PodnosilacCreationDto(zahtevZaPriznanjePatenta.getPodnosilac());
        this.pronalazac = new PronalazacCreationDto(zahtevZaPriznanjePatenta.getPronalazac());
        this.punomocnik = new PunomocnikCreationDto(zahtevZaPriznanjePatenta.getPunomocnik());
    }

    public PodaciOPrijavamaCreationDto getPodaciOPrijavama() {
        return podaciOPrijavama;
    }

    public void setPodaciOPrijavama(PodaciOPrijavamaCreationDto podaciOPrijavama) {
        this.podaciOPrijavama = podaciOPrijavama;
    }

    public NazivPronalaskaCreationDto getNazivPronalaska() {
        return nazivPronalaska;
    }

    public void setNazivPronalaska(NazivPronalaskaCreationDto nazivPronalaska) {
        this.nazivPronalaska = nazivPronalaska;
    }

    public PodnosilacCreationDto getPodnosilac() {
        return podnosilac;
    }

    public void setPodnosilac(PodnosilacCreationDto podnosilac) {
        this.podnosilac = podnosilac;
    }

    public PronalazacCreationDto getPronalazac() {
        return pronalazac;
    }

    public void setPronalazac(PronalazacCreationDto pronalazac) {
        this.pronalazac = pronalazac;
    }

    public PunomocnikCreationDto getPunomocnik() {
        return punomocnik;
    }

    public void setPunomocnik(PunomocnikCreationDto punomocnik) {
        this.punomocnik = punomocnik;
    }
}
