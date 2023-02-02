package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class PriloziUzZahtevDTO {

    @XmlElement
    private PrilogUzZahtevDTO primerakZnaka;
    @XmlElement
    private PrilogUzZahtevDTO spisakRobeIUsluga;
    @XmlElement
    private PrilogUzZahtevDTO punomocje;
    @XmlElement
    private boolean generalnoPunomocjeRanijePrilozeno;
    @XmlElement
    private boolean punomocjeCeBitiNaknadnoDostavljeno;
    @XmlElement
    private PrilogUzZahtevDTO opstiAktOKolektivnomZigu;
    @XmlElement
    private PrilogUzZahtevDTO dokazOPravuPrvenstva;
    @XmlElement
    private PrilogUzZahtevDTO dokazOUplatiTakse;

    public PriloziUzZahtevDTO() {
    }

    public PriloziUzZahtevDTO(PrilogUzZahtevDTO primerakZnaka, PrilogUzZahtevDTO spisakRobeIUsluga,
                              PrilogUzZahtevDTO punomocje, boolean generalnoPunomocjeRanijePrilozeno,
                              boolean punomocjeCeBitiNaknadnoDostavljeno, PrilogUzZahtevDTO opstiAktOKolektivnomZigu,
                              PrilogUzZahtevDTO dokazOPravuPrvenstva, PrilogUzZahtevDTO dokazOUplatiTakse) {
        this.primerakZnaka = primerakZnaka;
        this.spisakRobeIUsluga = spisakRobeIUsluga;
        this.punomocje = punomocje;
        this.generalnoPunomocjeRanijePrilozeno = generalnoPunomocjeRanijePrilozeno;
        this.punomocjeCeBitiNaknadnoDostavljeno = punomocjeCeBitiNaknadnoDostavljeno;
        this.opstiAktOKolektivnomZigu = opstiAktOKolektivnomZigu;
        this.dokazOPravuPrvenstva = dokazOPravuPrvenstva;
        this.dokazOUplatiTakse = dokazOUplatiTakse;
    }

    public PriloziUzZahtevDTO(ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev priloziUzZahtev) {
        this.primerakZnaka = new PrilogUzZahtevDTO(priloziUzZahtev.getPrimerakZnaka());
        this.spisakRobeIUsluga = new PrilogUzZahtevDTO(priloziUzZahtev.getSpisakRobeIUsluga());
        this.punomocje = new PrilogUzZahtevDTO(priloziUzZahtev.getPunomocje());
        this.generalnoPunomocjeRanijePrilozeno = priloziUzZahtev.isGeneralnoPunomocjeRanijePrilozeno();
        this.punomocjeCeBitiNaknadnoDostavljeno = priloziUzZahtev.isPunomocjeCeBitiNaknadnoDostavljeno();
        this.opstiAktOKolektivnomZigu = new PrilogUzZahtevDTO(priloziUzZahtev.getOpstiAktOKolektivnomZigu());
        this.dokazOPravuPrvenstva = new PrilogUzZahtevDTO(priloziUzZahtev.getDokazOPravuPrvenstva());
        this.dokazOUplatiTakse = new PrilogUzZahtevDTO(priloziUzZahtev.getDokazOUplatiTakse());
    }

    public PrilogUzZahtevDTO getPrimerakZnaka() {
        return primerakZnaka;
    }

    public void setPrimerakZnaka(PrilogUzZahtevDTO primerakZnaka) {
        this.primerakZnaka = primerakZnaka;
    }

    public PrilogUzZahtevDTO getSpisakRobeIUsluga() {
        return spisakRobeIUsluga;
    }

    public void setSpisakRobeIUsluga(PrilogUzZahtevDTO spisakRobeIUsluga) {
        this.spisakRobeIUsluga = spisakRobeIUsluga;
    }

    public PrilogUzZahtevDTO getPunomocje() {
        return punomocje;
    }

    public void setPunomocje(PrilogUzZahtevDTO punomocje) {
        this.punomocje = punomocje;
    }

    public boolean isGeneralnoPunomocjeRanijePrilozeno() {
        return generalnoPunomocjeRanijePrilozeno;
    }

    public void setGeneralnoPunomocjeRanijePrilozeno(boolean generalnoPunomocjeRanijePrilozeno) {
        this.generalnoPunomocjeRanijePrilozeno = generalnoPunomocjeRanijePrilozeno;
    }

    public boolean isPunomocjeCeBitiNaknadnoDostavljeno() {
        return punomocjeCeBitiNaknadnoDostavljeno;
    }

    public void setPunomocjeCeBitiNaknadnoDostavljeno(boolean punomocjeCeBitiNaknadnoDostavljeno) {
        this.punomocjeCeBitiNaknadnoDostavljeno = punomocjeCeBitiNaknadnoDostavljeno;
    }

    public PrilogUzZahtevDTO getOpstiAktOKolektivnomZigu() {
        return opstiAktOKolektivnomZigu;
    }

    public void setOpstiAktOKolektivnomZigu(PrilogUzZahtevDTO opstiAktOKolektivnomZigu) {
        this.opstiAktOKolektivnomZigu = opstiAktOKolektivnomZigu;
    }

    public PrilogUzZahtevDTO getDokazOPravuPrvenstva() {
        return dokazOPravuPrvenstva;
    }

    public void setDokazOPravuPrvenstva(PrilogUzZahtevDTO dokazOPravuPrvenstva) {
        this.dokazOPravuPrvenstva = dokazOPravuPrvenstva;
    }

    public PrilogUzZahtevDTO getDokazOUplatiTakse() {
        return dokazOUplatiTakse;
    }

    public void setDokazOUplatiTakse(PrilogUzZahtevDTO dokazOUplatiTakse) {
        this.dokazOUplatiTakse = dokazOUplatiTakse;
    }
}
