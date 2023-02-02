package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;

public class PodaciOPrijaviDTO {

    @XmlElement
    private PriloziUzZahtevDTO priloziUzZahtev;
    @XmlElement
    private String brojPrijaveZiga;
    @XmlElement
    private XMLGregorianCalendar datumPodnosenja;
    @XmlElement
    private XMLGregorianCalendar datumPrihvatanja;

    public PodaciOPrijaviDTO() {
    }

    public PodaciOPrijaviDTO(PriloziUzZahtevDTO priloziUzZahtev, String brojPrijaveZiga,
                             XMLGregorianCalendar datumPodnosenja, XMLGregorianCalendar datumPrihvatanja) {
        this.priloziUzZahtev = priloziUzZahtev;
        this.brojPrijaveZiga = brojPrijaveZiga;
        this.datumPodnosenja = datumPodnosenja;
        this.datumPrihvatanja = datumPrihvatanja;
    }

    public PodaciOPrijaviDTO(ZahtevZaPriznanjeZiga.PodaciOPrijavi podaciOPrijavi) {
        this.priloziUzZahtev = new PriloziUzZahtevDTO(podaciOPrijavi.getPriloziUzZahtev());
        this.brojPrijaveZiga = podaciOPrijavi.getBrojPrijaveZiga();
        this.datumPodnosenja = podaciOPrijavi.getDatumPodnosenja();
        this.datumPrihvatanja = podaciOPrijavi.getDatumPrihvatanja();
    }

    public PriloziUzZahtevDTO getPriloziUzZahtev() {
        return priloziUzZahtev;
    }

    public void setPriloziUzZahtev(PriloziUzZahtevDTO priloziUzZahtev) {
        this.priloziUzZahtev = priloziUzZahtev;
    }

    public String getBrojPrijaveZiga() {
        return brojPrijaveZiga;
    }

    public void setBrojPrijaveZiga(String brojPrijaveZiga) {
        this.brojPrijaveZiga = brojPrijaveZiga;
    }

    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    public void setDatumPodnosenja(XMLGregorianCalendar datumPodnosenja) {
        this.datumPodnosenja = datumPodnosenja;
    }

    public XMLGregorianCalendar getDatumPrihvatanja() {
        return datumPrihvatanja;
    }

    public void setDatumPrihvatanja(XMLGregorianCalendar datumPrihvatanja) {
        this.datumPrihvatanja = datumPrihvatanja;
    }
}
