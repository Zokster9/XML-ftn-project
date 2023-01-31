package com.example.z1project.Util;

import com.example.z1project.model.zig.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class ZigExample {

    public ZigExample() {
    }

    public void marshallZig() throws DatatypeConfigurationException, JAXBException, SAXException {
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

        podnosiociPrijave.getPodnosilacPrijave().add(podnosilacPrijave);

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
        Collections.addAll(klaseRobeIUsluga.getKlasa(), 1, 2, 12);

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
        TPrilogUzZahtev primerakZnaka = new TPrilogUzZahtev();
        primerakZnaka.setNazivDokumenta("znak.jpg");

        // sub elements: nazivDokumenta
        TPrilogUzZahtev dokazOUplatiTakse = new TPrilogUzZahtev();
        dokazOUplatiTakse.setNazivDokumenta("dokument.pdf");

        priloziUzZahtev.setPrimerakZnaka(primerakZnaka);
        priloziUzZahtev.setDokazOUplatiTakse(dokazOUplatiTakse);

        podaciOPrijavi.setBrojPrijaveZiga("Z-23456/23");
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

        JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
        Marshaller mar = context.createMarshaller();
//        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        Schema schema = schemaFactory.newSchema(new File("./src/main/resources/xsd/z1.xsd"));
//        mar.setSchema(schema);
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(zahtevZaPriznanjeZiga, new File("./src/main/resources/data/z1_primer1.xml"));
    }

    public void unmarshallZig() throws Exception {
        JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
//        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        Schema schema = schemaFactory.newSchema(new File("./src/main/resources/xsd/z1.xsd"));
//        unmarshaller.setSchema(schema);
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = (ZahtevZaPriznanjeZiga) unmarshaller.unmarshal(new File("./src/main/resources/data/z1_primer1.xml"));
        printZahtevZaPriznanjeZiga(zahtevZaPriznanjeZiga);
    }

    public void printZahtevZaPriznanjeZiga(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) {
        System.out.println("Zahtev za priznanje ziga");
        printPodnosiociPrijave(zahtevZaPriznanjeZiga.getPodnosiociPrijave());
        printPunomocnik(zahtevZaPriznanjeZiga.getPunomocnik());
        printZajednickiPredstavnikPodnosiocaPrijave(zahtevZaPriznanjeZiga.getZajednickiPredstavnikPodnosiocaPrijave());
        printZig(zahtevZaPriznanjeZiga.getZig());
        printKlaseRobe(zahtevZaPriznanjeZiga.getKlaseRobeIUsluga());
        printPlaceneTakse(zahtevZaPriznanjeZiga.getPlaceneTakse());
        printPodaciOPrijavi(zahtevZaPriznanjeZiga.getPodaciOPrijavi());
    }

    private void printPodnosiociPrijave(ZahtevZaPriznanjeZiga.PodnosiociPrijave podnosiociPrijave) {
        System.out.println("\tPodnosioci prijava:");
        podnosiociPrijave.getPodnosilacPrijave().forEach(this::printPodnosilacPrijave);
    }

    private void printPunomocnik(TLice punomocnik) {
        System.out.println("\tPunomocnik:");
        if (punomocnik != null) printPodnosilacPrijave(punomocnik);
    }

    private void printZajednickiPredstavnikPodnosiocaPrijave(TLice zajednickiPredstavnikPodnosiocaPrijave) {
        System.out.println("\tZajednicki predstavnik podnosioca prijave:");
        if (zajednickiPredstavnikPodnosiocaPrijave != null) printPodnosilacPrijave(zajednickiPredstavnikPodnosiocaPrijave);
    }

    private void printPodnosilacPrijave(TLice podnosilacPrijave) {
        System.out.println("\t\t{");
        TFizickoLice fizickoLice;
        TPravnoLice pravnoLice;
        if (podnosilacPrijave instanceof TFizickoLice) {
            fizickoLice = (TFizickoLice) podnosilacPrijave;
            System.out.println("\t\t\tIme: " + fizickoLice.getIme());
            System.out.println("\t\t\tPrezime: " + fizickoLice.getPrezime());
        } else {
            pravnoLice = (TPravnoLice) podnosilacPrijave;
            System.out.println("\t\t\tNaziv: " + pravnoLice.getNaziv());
        }
        System.out.println("\t\t\tUlica: " + podnosilacPrijave.getAdresa().getUlica());
        System.out.println("\t\t\tBroj: " + podnosilacPrijave.getAdresa().getBroj());
        System.out.println("\t\t\tMesto: " + podnosilacPrijave.getAdresa().getMesto());
        System.out.println("\t\t\tDrzava: " + podnosilacPrijave.getAdresa().getDrzava());
        System.out.println("\t\t\tPostanski broj: " + podnosilacPrijave.getAdresa().getPostanskiBroj());
        System.out.println("\t\t\tEmail: " + podnosilacPrijave.getKontaktPodaci().getEmail());
        System.out.println("\t\t\tBroj telefona: " + podnosilacPrijave.getKontaktPodaci().getBrojTelefona());
        System.out.println("\t\t\tBroj faksa: " + podnosilacPrijave.getKontaktPodaci().getBrojFaksa());
        System.out.println("\t\t},");
    }

    private void printZig(ZahtevZaPriznanjeZiga.Zig zig) {
        System.out.println("\tZig:");
        System.out.println("\t\t{");
        printTipZiga(zig.getTipZiga());
        printTipZnaka(zig.getTipZnaka());
        printNaznaceneBoje(zig.getNaznaceneBoje());
        System.out.println("\t\t\tIzgled znaka: " + zig.getIzgledZnaka().getImageUrl());
        System.out.println("\t\t\tTransliteracija znaka: " + zig.getTransliteracijaZnaka());
        System.out.println("\t\t\tPrevod znaka: " + zig.getPrevodZnaka());
        System.out.println("\t\t\tOpis znaka: " + zig.getOpisZnaka());
        System.out.println("\t\t},");
    }

    private void printTipZiga(ZahtevZaPriznanjeZiga.Zig.TipZiga tipZiga) {
        String tip = "";
        if (tipZiga.isIndividualniZig() != null && tipZiga.isIndividualniZig()) tip = "individualni zig";
        else if (tipZiga.isKolektivniZig() != null && tipZiga.isKolektivniZig()) tip = "kolektivni zig";
        else tip = "zig garancije";
        System.out.println("\t\t\tTip ziga: " + tip);
    }

    private void printTipZnaka(ZahtevZaPriznanjeZiga.Zig.TipZnaka tipZnaka) {
        String tip = "";
        if (tipZnaka.isVerbalniZnak() != null && tipZnaka.isVerbalniZnak()) tip = "verbalni znak";
        else if (tipZnaka.isGrafickiZnak() != null && tipZnaka.isGrafickiZnak()) tip = "graficki znak";
        else if (tipZnaka.isKombinovaniZnak() != null && tipZnaka.isKombinovaniZnak()) tip = "kombinovani znak";
        else if (tipZnaka.isTrodimenzionalniZnak() != null && tipZnaka.isTrodimenzionalniZnak()) tip = "trodimenzionalni znak";
        else tip = "druga vrsta znaka";
        System.out.println("\t\t\tTip znaka: " + tip);
    }

    private void printNaznaceneBoje(ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje naznaceneBoje) {
        System.out.println("\t\t\tNaznacene boje:");
        naznaceneBoje.getBoja().forEach(this::printBoja);
    }

    private void printBoja(String boja) {
        System.out.println("\t\t\t\t{");
        System.out.println("\t\t\t\t\tBoja: " + boja);
        System.out.println("\t\t\t\t},");
    }

    private void printKlaseRobe(ZahtevZaPriznanjeZiga.KlaseRobeIUsluga klaseRobeIUsluga) {
        System.out.println("\tKlase robe i usluga:");
        klaseRobeIUsluga.getKlasa().forEach(this::printKlase);
    }

    private void printKlase(int klasa) {
        System.out.println("\t\t{");
        System.out.println("\t\t\tKlasa: " + klasa);
        System.out.println("\t\t},");
    }

    private void printPlaceneTakse(ZahtevZaPriznanjeZiga.PlaceneTakse placeneTakse) {
        System.out.println("\tPlacene takse:");
        System.out.println("\t\t{");
        System.out.println("\t\t\tOsnovna taksa: " + placeneTakse.getOsnovnaTaksa());
        printTaksaZaKlase(placeneTakse.getTaksaZaKlase());
        System.out.println("\t\t\tZa graficko resenje: " + placeneTakse.getTaksaZaGrafickoResenje());
        System.out.println("\t\t\tUkupno: " + placeneTakse.getUkupnaTaksa());
        System.out.println("\t\t},");
    }

    private void printTaksaZaKlase(ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase taksaZaKlase) {
        System.out.println("\t\t\tZa " + taksaZaKlase.getBrojKlasa() + " klasa: " + taksaZaKlase.getVrednost());
    }

    private void printPodaciOPrijavi(ZahtevZaPriznanjeZiga.PodaciOPrijavi podaciOPrijavi) {
        System.out.println("\tPodaci o prijavi:");
        System.out.println("\t\t{");
        System.out.println("\t\t\tBroj prijave ziga: " + podaciOPrijavi.getBrojPrijaveZiga());
        System.out.println("\t\t\tDatum podnosenja: " + podaciOPrijavi.getDatumPodnosenja());
        printPriloziUzZahtev(podaciOPrijavi.getPriloziUzZahtev());
        System.out.println("\t\t},");
    }

    private void printPriloziUzZahtev(ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev priloziUzZahtev) {
        System.out.println("\t\t\tPrilozi uz zahtev:");
        System.out.println("\t\t\t\t{");
        System.out.println("\t\t\t\t\tPrimerak znaka: " + priloziUzZahtev.getPrimerakZnaka().getNazivDokumenta());
        printPunomocje(priloziUzZahtev.getPunomocje());
        System.out.println("\t\t\t\t\tGeneralno punomocje ranije prilozeno: " + priloziUzZahtev.isGeneralnoPunomocjeRanijePrilozeno());
        System.out.println("\t\t\t\t\tPunomocje ce biti naknadno dostavljeno: " + priloziUzZahtev.isPunomocjeCeBitiNaknadnoDostavljeno());
        printOpstiAktOKolektivnomZigu(priloziUzZahtev.getOpstiAktOKolektivnomZigu());
        printDokazOPravuPrventsva(priloziUzZahtev.getDokazOPravuPrvenstva());
        System.out.println("\t\t\t\t\tDokaz o uplati takse: " + priloziUzZahtev.getDokazOUplatiTakse().getNazivDokumenta());
        System.out.println("\t\t\t\t},");
    }

    private void printDokazOPravuPrventsva(TPrilogUzZahtev dokazOPravuPrvenstva) {
        String vrednost = "";
        if (dokazOPravuPrvenstva != null) {
            vrednost = dokazOPravuPrvenstva.getNazivDokumenta();
        }
        System.out.println("\t\t\t\t\tDokaz o pravu prvenstva: " + vrednost);
    }

    private void printOpstiAktOKolektivnomZigu(TPrilogUzZahtev opstiAktOKolektivnomZigu) {
        String vrednost = "";
        if (opstiAktOKolektivnomZigu != null) {
            vrednost = opstiAktOKolektivnomZigu.getNazivDokumenta();
        }
        System.out.println("\t\t\t\t\tOpsti akt o kolektivnom zigu/zigu garancije: " + vrednost);
    }

    private void printPunomocje(TPrilogUzZahtev punomocje) {
        String vrednost = "";
        if (punomocje != null) {
            vrednost = punomocje.getNazivDokumenta();
        }
        System.out.println("\t\t\t\t\tPunomocje: " + vrednost);
    }

    private void printUsluga(String usluga) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t{");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tNaziv: " + usluga);
        System.out.println("\t\t\t\t\t\t\t\t\t\t},");
    }

}
