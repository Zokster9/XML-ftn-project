package project.xmlproject;

import project.xmlproject.model.patent.*;
import rs.ac.uns.ftn.patent.*;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class MarshalExample {

    public MarshalExample() {

    }

    public void marshal() throws JAXBException, IOException {
        //root
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = new ZahtevZaPriznanjePatenta();

        //root elements
        //1. element: podaciOPrijavama
        ZahtevZaPriznanjePatenta.PodaciOPrijavama podaciOPrijavama = new ZahtevZaPriznanjePatenta.PodaciOPrijavama();

        //subelements of podaciOPrijavama: NovaPrijava, DodatnaPrijava, PriznanjaPravaPrventsva
        NovaPrijava novaPrijava = new NovaPrijava();
        novaPrijava.setBrojPrijave("P123");
        novaPrijava.setDatumPrijave("30.11.2022.");
        novaPrijava.setPriznatiDatumPrijave("1.12.2022.");

        DodatnaPrijava dodatnaPrijava = new DodatnaPrijava();

        DodatnaPrijava.TipPrijave tipPrijave = new DodatnaPrijava.TipPrijave();
        tipPrijave.setDopunskaPrijava("true");

        dodatnaPrijava.setTipPrijave(tipPrijave);
        dodatnaPrijava.setBrojPrvobitnePrijave("P456");
        dodatnaPrijava.setDatumPodnosenjaPrijave("29.11.2022.");

        PriznanjePravaPrvenstva priznanjePravaPrvenstva1 = new PriznanjePravaPrvenstva();
        priznanjePravaPrvenstva1.setDatumPrijave("29.11.2022.");
        priznanjePravaPrvenstva1.setBrojRanijePrijave("P342");
        priznanjePravaPrvenstva1.setDvoslovnaOznakaDrzaveOrganizacije("AB");

        PriznanjePravaPrvenstva priznanjePravaPrvenstva2 = new PriznanjePravaPrvenstva();
        priznanjePravaPrvenstva2.setDatumPrijave("28.11.2022.");
        priznanjePravaPrvenstva2.setBrojRanijePrijave("P142");
        priznanjePravaPrvenstva2.setDvoslovnaOznakaDrzaveOrganizacije("CD");

        ZahtevZaPriznanjePatenta.PodaciOPrijavama.PriznanjaPravaPrvenstva priznanjaPravaPrvenstva = new ZahtevZaPriznanjePatenta.PodaciOPrijavama.PriznanjaPravaPrvenstva();
        priznanjaPravaPrvenstva.getPriznanjePravaPrvenstva().add(priznanjePravaPrvenstva1);
        priznanjaPravaPrvenstva.getPriznanjePravaPrvenstva().add(priznanjePravaPrvenstva2);

        podaciOPrijavama.setNovaPrijava(novaPrijava);
        podaciOPrijavama.setDodatnaPrijava(dodatnaPrijava);
        podaciOPrijavama.setPriznanjaPravaPrvenstva(priznanjaPravaPrvenstva);

        // 2. element: NazivPronalaska
        // subelements: engleski naziv, srpski naziv
        ZahtevZaPriznanjePatenta.NazivPronalaska nazivPronalaska = new ZahtevZaPriznanjePatenta.NazivPronalaska();
        nazivPronalaska.setEngleskiNaziv("Nice man");
        nazivPronalaska.setSrpskiNaziv("Brao covece");

        // 3. element: Podnosilac
        // subelements: naziv, adresa, kontakt podaci, drzavljanstvo, podnosilac je pronalazac, nacin dostavljanja
        ZahtevZaPriznanjePatenta.Podnosilac podnosilac = new ZahtevZaPriznanjePatenta.Podnosilac();
        podnosilac.setNaziv("Macos Macorski");

        Adresa adresa  = new Adresa();
        adresa.setUlicaIBroj("Tamo nedje 69");
        adresa.setPostanskiBroj(24736);
        adresa.setMesto("Jos nedjee");
        adresa.setDrzava("Srbija");

        podnosilac.setAdresa(adresa);

        KontaktPodaci kontaktPodaci = new KontaktPodaci();
        kontaktPodaci.setBrojTelefona("062559743");
        kontaktPodaci.setBrojFaksa("12441");
        kontaktPodaci.setEPosta("neki@gmail.com");

        podnosilac.setKontaktPodaci(kontaktPodaci);

        podnosilac.setDrzavljanstvo("Madjarrr");
        podnosilac.setPodnosilacJePronalazac(true);

        ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja nacinDostavljanja = new ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja();

        ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja.Elektronski elektronski = new ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja.Elektronski();
        elektronski.setEmail("macos@gmail.com");

        nacinDostavljanja.setElektronski(elektronski);

        podnosilac.setNacinDostavljanja(nacinDostavljanja);

        // 4. element: Pronalazac
        // subelements: naziv, adresa, kontakt podaci, zeli biti u prijavi
        ZahtevZaPriznanjePatenta.Pronalazac pronalazac = new ZahtevZaPriznanjePatenta.Pronalazac();
        pronalazac.setNaziv("Teodor the great");

        Adresa adresa1 = new Adresa();
        adresa1.setUlicaIBroj("Tamo nedje 68");
        adresa1.setPostanskiBroj(24732);
        adresa1.setMesto("Jos nedjeeeeee");
        adresa1.setDrzava("Srbijaaaaa");

        pronalazac.setAdresa(adresa1);

        KontaktPodaci kontaktPodaci1 = new KontaktPodaci();
        kontaktPodaci1.setBrojTelefona("062559742");
        kontaktPodaci1.setBrojFaksa("12221");
        kontaktPodaci1.setEPosta("nekiaaaaa@gmail.com");

        pronalazac.setKontaktPodaci(kontaktPodaci1);

        pronalazac.setZeliBitiUPrijavi(false);


        // 5. element: punomocnik
        // subelements: tip punomocnika, zajednicki predstavnik, naziv, adresa, kontakt podaci
        ZahtevZaPriznanjePatenta.Punomocnik punomocnik = new ZahtevZaPriznanjePatenta.Punomocnik();

        ZahtevZaPriznanjePatenta.Punomocnik.TipPunomocnika tipPunomocnika = new ZahtevZaPriznanjePatenta.Punomocnik.TipPunomocnika();
        tipPunomocnika.setPunomocnikZaPrijemPismena("true");

        punomocnik.setTipPunomocnika(tipPunomocnika);
        punomocnik.setZajednickiPredstavnik(false);
        punomocnik.setNaziv("Zoki zorane");

        Adresa adresa2 = new Adresa();
        adresa2.setUlicaIBroj("Tamo nedje 624");
        adresa2.setPostanskiBroj(24733);
        adresa2.setMesto("smrdi");
        adresa2.setDrzava("Madjarska");

        punomocnik.setAdresa(adresa2);

        KontaktPodaci kontaktPodaci2 = new KontaktPodaci();
        kontaktPodaci2.setBrojTelefona("062123132");
        kontaktPodaci2.setBrojFaksa("13333");
        kontaktPodaci2.setEPosta("nekiaaaaaaaaaaa@gmail.com");

        punomocnik.setKontaktPodaci(kontaktPodaci2);

        zahtevZaPriznanjePatenta.setNazivPronalaska(nazivPronalaska);
        zahtevZaPriznanjePatenta.setPodaciOPrijavama(podaciOPrijavama);
        zahtevZaPriznanjePatenta.setPodnosilac(podnosilac);
        zahtevZaPriznanjePatenta.setPronalazac(pronalazac);
        zahtevZaPriznanjePatenta.setPunomocnik(punomocnik);

        JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(zahtevZaPriznanjePatenta, new File("p1_primer1.xml"));

    }
}