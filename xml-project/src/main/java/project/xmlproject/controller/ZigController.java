package project.xmlproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.Util.ZigExample;
import project.xmlproject.model.zig.*;
import project.xmlproject.service.ZigService;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
@RequestMapping(value = "/zigovi")
public class ZigController {

    @Autowired
    private ZigService zigService;

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createZig() throws Exception {
        // root
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = new ZahtevZaPriznanjeZiga();

        // root elements
        // 1. element: podnosiociPrijave
        // sub elements: podnosilacPrijave
        ZahtevZaPriznanjeZiga.PodnosiociPrijave podnosiociPrijave = new ZahtevZaPriznanjeZiga.PodnosiociPrijave();

        // sub elements: ime, prezime, Adresa, KontaktPodaci
        TFizickoLice podnosilacPrijave = new TFizickoLice();
        podnosilacPrijave.setIme("Teodor");
        podnosilacPrijave.setPrezime("Teodorovic");

        // sub elements of podnosiocPrijave: Adresa, KontaktPodaci
        Adresa adresa = new Adresa();
        adresa.setUlica("Suboticka");
        adresa.setBroj("34");
        adresa.setMesto("Subotica");
        adresa.setDrzava("Srbija");
        adresa.setPostanskiBroj(24000);

        KontaktPodaci kontaktPodaci = new KontaktPodaci();
        kontaktPodaci.setEmail("teki.sakal@gmail.com");
        kontaktPodaci.setBrojTelefona("+381642949430");
        kontaktPodaci.setBrojFaksa("4234223");

        podnosilacPrijave.setAdresa(adresa);
        podnosilacPrijave.setKontaktPodaci(kontaktPodaci);

        TPravnoLice pravnoLice = new TPravnoLice();

        Adresa adresa1 = new Adresa();
        adresa1.setUlica("Ulica Firmi");
        adresa1.setBroj("13/2");
        adresa1.setMesto("Novi Sad");
        adresa1.setDrzava("Srbija");
        adresa1.setPostanskiBroj(21000);

        KontaktPodaci kontaktPodaci1 = new KontaktPodaci();
        kontaktPodaci1.setEmail("firma@gmail.com");
        kontaktPodaci1.setBrojTelefona("+381642956023");
        kontaktPodaci1.setBrojFaksa("383838");

        pravnoLice.setNaziv("Firma za zigove");
        pravnoLice.setAdresa(adresa1);
        pravnoLice.setKontaktPodaci(kontaktPodaci1);

        podnosiociPrijave.getPodnosilacPrijave().add(podnosilacPrijave);
        podnosiociPrijave.getPodnosilacPrijave().add(pravnoLice);

        // 2. element: Zig
        // sub elements: tipZiga, tipZnaka, izgledZnaka, naznaceneBoje, opisZnaka
        ZahtevZaPriznanjeZiga.Zig zig = new ZahtevZaPriznanjeZiga.Zig();

        // sub elements: individualniZig, kolektivniZig, zigGarancije
        ZahtevZaPriznanjeZiga.Zig.TipZiga tipZiga = new ZahtevZaPriznanjeZiga.Zig.TipZiga();
        tipZiga.setIndividualniZig(true);

        // sub elements: verbalniZnak, grafickiZnak, kombinovaniZnak, trodimenzionalniZnak, drugaVrstaZnaka
        ZahtevZaPriznanjeZiga.Zig.TipZnaka tipZnaka = new ZahtevZaPriznanjeZiga.Zig.TipZnaka();
        tipZnaka.setGrafickiZnak(true);

        // attributes: imageUrl
        ZahtevZaPriznanjeZiga.Zig.IzgledZnaka izgledZnaka = new ZahtevZaPriznanjeZiga.Zig.IzgledZnaka();
        izgledZnaka.setImageUrl("slika.jpg");

        // sub elements: boja
        ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje naznaceneBoje = new ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje();
        naznaceneBoje.getBoja().add("Crvena");
        naznaceneBoje.getBoja().add("Plava");

        zig.setTipZiga(tipZiga);
        zig.setTipZnaka(tipZnaka);
        zig.setIzgledZnaka(izgledZnaka);
        zig.setNaznaceneBoje(naznaceneBoje);
        zig.setOpisZnaka("Ovo je lep znak");

        // 3. element: KlaseRobeIUsluga
        // sub elements: klasa
        ZahtevZaPriznanjeZiga.KlaseRobeIUsluga klaseRobeIUsluga = new ZahtevZaPriznanjeZiga.KlaseRobeIUsluga();
        for (int i = 0; i < 45; i++) {
            klaseRobeIUsluga.getKlasa().add(0);
        }
        //Collections.addAll(klaseRobeIUsluga.getKlasa(), 1, 2, 12);

        klaseRobeIUsluga.getKlasa().set(0, 1);
        klaseRobeIUsluga.getKlasa().set(1, 2);
        klaseRobeIUsluga.getKlasa().set(11, 12);

        // 4. element: PlaceneTakse
        // sub elements: osnovnaTaksa, taksaZaKlase, taksaZaGrafickoResenje, ukupnaTaksa
        ZahtevZaPriznanjeZiga.PlaceneTakse placeneTakse = new ZahtevZaPriznanjeZiga.PlaceneTakse();

        // sub elements: value, brojKlasa
        ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase taksaZaKlase = new ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase();
        taksaZaKlase.setVrednost(345.23);
        taksaZaKlase.setBrojKlasa(klaseRobeIUsluga.getKlasa().size());

        placeneTakse.setOsnovnaTaksa(1564.65);
        placeneTakse.setTaksaZaKlase(taksaZaKlase);
        placeneTakse.setTaksaZaGrafickoResenje(243.23);
        placeneTakse.setUkupnaTaksa(placeneTakse.getOsnovnaTaksa() + placeneTakse.getTaksaZaKlase().getVrednost() +
                placeneTakse.getTaksaZaGrafickoResenje());

        // 5. element: PodaciOPrijavi
        // sub elements: PriloziUzZahtev, brojPrijaveZiga, datumPodnosenja
        ZahtevZaPriznanjeZiga.PodaciOPrijavi podaciOPrijavi = new ZahtevZaPriznanjeZiga.PodaciOPrijavi();

        // sub elements: PrimerakZnaka, SpisakRobeIUsluga, DokazOUplatiTakse
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev priloziUzZahtev = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev();

        // sub elements: nazivDokumenta
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.PrimerakZnaka primerakZnaka = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.PrimerakZnaka();
        primerakZnaka.setNazivDokumenta("znak.jpg");

        // sub elements: spisak
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga spisakRobeIUsluga = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga();

        // sub elements: klasa, usluge
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak spisak1 = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak();
        spisak1.setKlasa(1);
        // sub elements for Usluge: naziv
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak.Usluge usluge1 = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak.Usluge();
        Collections.addAll(usluge1.getNaziv(),"Deterdzentni aditivi za benzin", "aktivni ugalj");
        spisak1.setUsluge(usluge1);

        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak spisak2 = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak();
        spisak2.setKlasa(2);
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak.Usluge usluge2 = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak.Usluge();
        Collections.addAll(usluge2.getNaziv(),"Boje za cipele", "Belo olovo");
        spisak2.setUsluge(usluge2);

        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak spisak3 = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak();
        spisak3.setKlasa(12);
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak.Usluge usluge3 = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.SpisakRobeIUsluga.Spisak.Usluge();
        Collections.addAll(usluge3.getNaziv(),"Helikopteri", "Ronilacka zvona");
        spisak3.setUsluge(usluge3);

        Collections.addAll(spisakRobeIUsluga.getSpisak(), spisak1, spisak2, spisak3);

        // sub elements: nazivDokumenta
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.DokazOUplatiTakse dokazOUplatiTakse = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev.DokazOUplatiTakse();
        dokazOUplatiTakse.setNazivDokumenta("dokument.pdf");

        priloziUzZahtev.setPrimerakZnaka(primerakZnaka);
        priloziUzZahtev.setSpisakRobeIUsluga(spisakRobeIUsluga);
        priloziUzZahtev.setDokazOUplatiTakse(dokazOUplatiTakse);

        podaciOPrijavi.setBrojPrijaveZiga("Z-23456-25");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        XMLGregorianCalendar xCal = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(cal);
        podaciOPrijavi.setDatumPodnosenja(xCal);
        podaciOPrijavi.setPriloziUzZahtev(priloziUzZahtev);
        zahtevZaPriznanjeZiga.setPodnosiociPrijave(podnosiociPrijave);
        zahtevZaPriznanjeZiga.setZig(zig);
        zahtevZaPriznanjeZiga.setKlaseRobeIUsluga(klaseRobeIUsluga);
        zahtevZaPriznanjeZiga.setPlaceneTakse(placeneTakse);
        zahtevZaPriznanjeZiga.setPodaciOPrijavi(podaciOPrijavi);
        zigService.addZig(zahtevZaPriznanjeZiga);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/retrieve")
    public ResponseEntity<Void> getZig() throws Exception {
        ZigExample zigExample = new ZigExample();
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigService.getZig();

        TPravnoLice pravnoLice = new TPravnoLice();

        Adresa adresa = new Adresa();
        adresa.setUlica("Ulica Firmi");
        adresa.setBroj("13/2");
        adresa.setMesto("Novi Sad");
        adresa.setDrzava("Srbija");
        adresa.setPostanskiBroj(21000);

        KontaktPodaci kontaktPodaci = new KontaktPodaci();
        kontaktPodaci.setEmail("firma@gmail.com");
        kontaktPodaci.setBrojTelefona("+381642956023");
        kontaktPodaci.setBrojFaksa("383838");

        pravnoLice.setNaziv("Firma za zigove");
        pravnoLice.setAdresa(adresa);
        pravnoLice.setKontaktPodaci(kontaktPodaci);

        zahtevZaPriznanjeZiga.setZajednickiPredstavnikPodnosiocaPrijave(zahtevZaPriznanjeZiga.getPodnosiociPrijave().getPodnosilacPrijave().get(0));
        zahtevZaPriznanjeZiga.getPodnosiociPrijave().getPodnosilacPrijave().add(pravnoLice);

        zigExample.printZahtevZaPriznanjeZiga(zahtevZaPriznanjeZiga);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/create-zig-html/{brojPrijave}", produces = "application/xml")
    public ResponseEntity<Void> getZigHTML(@PathVariable String brojPrijave) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjePatenta = zigService.createZigHtml(brojPrijave);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/create-zig-pdf/{brojPrijave}", produces = "application/xml")
    public ResponseEntity<Void> getZigPDF(@PathVariable String brojPrijave) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjePatenta = zigService.createZigPdf(brojPrijave);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
