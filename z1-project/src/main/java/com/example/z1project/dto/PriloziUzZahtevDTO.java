package com.example.z1project.dto;

public class PriloziUzZahtevDTO {

    private PriloziUzZahtevDTO primerakZnaka;
    private PriloziUzZahtevDTO spisakRobeIUsluga;
    private PriloziUzZahtevDTO punomocje;
    private boolean generalnoPunomocjeRanijePrilozeno;
    private boolean punomocjeCeBitiNaknadnoDostavljeno;
    private PriloziUzZahtevDTO opstiAktOKolektivnomZigu;
    private PriloziUzZahtevDTO dokazOPravuPrvenstva;
    private PriloziUzZahtevDTO dokazOUplatiTakse;

    public PriloziUzZahtevDTO() {
    }

    public PriloziUzZahtevDTO(PriloziUzZahtevDTO primerakZnaka, PriloziUzZahtevDTO spisakRobeIUsluga,
                              PriloziUzZahtevDTO punomocje, boolean generalnoPunomocjeRanijePrilozeno,
                              boolean punomocjeCeBitiNaknadnoDostavljeno, PriloziUzZahtevDTO opstiAktOKolektivnomZigu,
                              PriloziUzZahtevDTO dokazOPravuPrvenstva, PriloziUzZahtevDTO dokazOUplatiTakse) {
        this.primerakZnaka = primerakZnaka;
        this.spisakRobeIUsluga = spisakRobeIUsluga;
        this.punomocje = punomocje;
        this.generalnoPunomocjeRanijePrilozeno = generalnoPunomocjeRanijePrilozeno;
        this.punomocjeCeBitiNaknadnoDostavljeno = punomocjeCeBitiNaknadnoDostavljeno;
        this.opstiAktOKolektivnomZigu = opstiAktOKolektivnomZigu;
        this.dokazOPravuPrvenstva = dokazOPravuPrvenstva;
        this.dokazOUplatiTakse = dokazOUplatiTakse;
    }

    public PriloziUzZahtevDTO getPrimerakZnaka() {
        return primerakZnaka;
    }

    public void setPrimerakZnaka(PriloziUzZahtevDTO primerakZnaka) {
        this.primerakZnaka = primerakZnaka;
    }

    public PriloziUzZahtevDTO getSpisakRobeIUsluga() {
        return spisakRobeIUsluga;
    }

    public void setSpisakRobeIUsluga(PriloziUzZahtevDTO spisakRobeIUsluga) {
        this.spisakRobeIUsluga = spisakRobeIUsluga;
    }

    public PriloziUzZahtevDTO getPunomocje() {
        return punomocje;
    }

    public void setPunomocje(PriloziUzZahtevDTO punomocje) {
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

    public PriloziUzZahtevDTO getOpstiAktOKolektivnomZigu() {
        return opstiAktOKolektivnomZigu;
    }

    public void setOpstiAktOKolektivnomZigu(PriloziUzZahtevDTO opstiAktOKolektivnomZigu) {
        this.opstiAktOKolektivnomZigu = opstiAktOKolektivnomZigu;
    }

    public PriloziUzZahtevDTO getDokazOPravuPrvenstva() {
        return dokazOPravuPrvenstva;
    }

    public void setDokazOPravuPrvenstva(PriloziUzZahtevDTO dokazOPravuPrvenstva) {
        this.dokazOPravuPrvenstva = dokazOPravuPrvenstva;
    }

    public PriloziUzZahtevDTO getDokazOUplatiTakse() {
        return dokazOUplatiTakse;
    }

    public void setDokazOUplatiTakse(PriloziUzZahtevDTO dokazOUplatiTakse) {
        this.dokazOUplatiTakse = dokazOUplatiTakse;
    }
}
