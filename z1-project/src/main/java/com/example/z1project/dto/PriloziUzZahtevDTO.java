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
        try {
            this.primerakZnaka = new PrilogUzZahtevDTO(priloziUzZahtev.getPrimerakZnaka());
        } catch (Exception e){
            this.primerakZnaka = null;
        }
        try {
            this.spisakRobeIUsluga = new PrilogUzZahtevDTO(priloziUzZahtev.getSpisakRobeIUsluga());
        } catch (Exception e){
            this.spisakRobeIUsluga = null;
        }
        try {
            this.punomocje = new PrilogUzZahtevDTO(priloziUzZahtev.getPunomocje());
        } catch (Exception e){
            this.punomocje = null;
        }
        try {
            this.generalnoPunomocjeRanijePrilozeno = priloziUzZahtev.isGeneralnoPunomocjeRanijePrilozeno();
        } catch (Exception e) {
            this.generalnoPunomocjeRanijePrilozeno = false;
        }
        try {
            this.punomocjeCeBitiNaknadnoDostavljeno = priloziUzZahtev.isPunomocjeCeBitiNaknadnoDostavljeno();
        } catch (Exception e) {
            this.punomocjeCeBitiNaknadnoDostavljeno = false;
        }
        try {
            this.opstiAktOKolektivnomZigu = new PrilogUzZahtevDTO(priloziUzZahtev.getOpstiAktOKolektivnomZigu());
        } catch (Exception e){
            this.opstiAktOKolektivnomZigu = null;
        }
        try {
            this.dokazOPravuPrvenstva = new PrilogUzZahtevDTO(priloziUzZahtev.getDokazOPravuPrvenstva());
        } catch (Exception e){
            this.dokazOPravuPrvenstva = null;
        }
        try {
            this.dokazOUplatiTakse = new PrilogUzZahtevDTO(priloziUzZahtev.getDokazOUplatiTakse());
        } catch (Exception e){
            this.dokazOUplatiTakse = null;
        }
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
