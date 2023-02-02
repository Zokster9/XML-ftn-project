package com.example.z1project.marshall;

import com.example.z1project.dto.*;
import com.example.z1project.model.zig.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MarshallZig {

    public ZahtevZaPriznanjeZiga marshalZahtevZaPriznanjeZiga(ZahtevZaPriznanjeZigaDTO zahtevZaPriznanjeZigaDTO) throws DatatypeConfigurationException {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = new ZahtevZaPriznanjeZiga();
        zahtevZaPriznanjeZiga.setPodnosiociPrijave(marshalPodnosioci(zahtevZaPriznanjeZigaDTO.getPodnosiociPrijave()));
        zahtevZaPriznanjeZiga.setPunomocnik(marshalPunomocnik(zahtevZaPriznanjeZigaDTO.getPunomocnik()));
        zahtevZaPriznanjeZiga.setZajednickiPredstavnikPodnosiocaPrijave(marshalZajednickiPredstavnikPodnosiocaPrijave(
                zahtevZaPriznanjeZigaDTO.getFizickiZajednickiPredstavnikPodnosiocaPrijave(), zahtevZaPriznanjeZigaDTO.getPravniZajednickiPredstavnikPodnosiocaPrijave()));
        zahtevZaPriznanjeZiga.setZig(marshalZig(zahtevZaPriznanjeZigaDTO.getZig()));
        zahtevZaPriznanjeZiga.setKlaseRobeIUsluga(marshalKlaseRobeIUsluga(zahtevZaPriznanjeZigaDTO.getKlaseRobeIUsluga()));
        zahtevZaPriznanjeZiga.setPravoPrvenstvaIOsnov(zahtevZaPriznanjeZigaDTO.getPravoPrvenstvaIOsnov());
        zahtevZaPriznanjeZiga.setPlaceneTakse(marshalPlaceneTakse(zahtevZaPriznanjeZigaDTO.getPlaceneTakse()));
        zahtevZaPriznanjeZiga.setPodaciOPrijavi(marshalPodaciOPrijavi(zahtevZaPriznanjeZigaDTO.getPodaciOPrijavi()));
        return zahtevZaPriznanjeZiga;
    }

    private ZahtevZaPriznanjeZiga.PodaciOPrijavi marshalPodaciOPrijavi(PodaciOPrijaviDTO podaciOPrijaviDTO) throws DatatypeConfigurationException {
        ZahtevZaPriznanjeZiga.PodaciOPrijavi podaciOPrijavi = new ZahtevZaPriznanjeZiga.PodaciOPrijavi();
        podaciOPrijavi.setPriloziUzZahtev(marshalPriloziUzZahtev(podaciOPrijaviDTO.getPriloziUzZahtev()));
        String milliseconds = String.valueOf(new Date().getTime());
        podaciOPrijavi.setBrojPrijaveZiga("Z-" + milliseconds.substring(0, 5) + "-" + milliseconds.substring(5, 7));
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        XMLGregorianCalendar xCal = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(cal);
        podaciOPrijavi.setDatumPodnosenja(xCal);
        return podaciOPrijavi;
    }

    private ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev marshalPriloziUzZahtev(PriloziUzZahtevDTO priloziUzZahtevDTO) {
        ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev priloziUzZahtev = new ZahtevZaPriznanjeZiga.PodaciOPrijavi.PriloziUzZahtev();
        priloziUzZahtev.setDokazOPravuPrvenstva(marshalPrilogUzZahtev(priloziUzZahtevDTO.getDokazOPravuPrvenstva()));
        priloziUzZahtev.setPunomocje(marshalPrilogUzZahtev(priloziUzZahtevDTO.getPunomocje()));
        priloziUzZahtev.setDokazOUplatiTakse(marshalPrilogUzZahtev(priloziUzZahtevDTO.getDokazOUplatiTakse()));
        priloziUzZahtev.setPrimerakZnaka(marshalPrilogUzZahtev(priloziUzZahtevDTO.getPrimerakZnaka()));
        priloziUzZahtev.setSpisakRobeIUsluga(marshalPrilogUzZahtev(priloziUzZahtevDTO.getSpisakRobeIUsluga()));
        priloziUzZahtev.setOpstiAktOKolektivnomZigu(marshalPrilogUzZahtev(priloziUzZahtevDTO.getOpstiAktOKolektivnomZigu()));
        priloziUzZahtev.setGeneralnoPunomocjeRanijePrilozeno(priloziUzZahtevDTO.isGeneralnoPunomocjeRanijePrilozeno());
        priloziUzZahtev.setPunomocjeCeBitiNaknadnoDostavljeno(priloziUzZahtevDTO.isPunomocjeCeBitiNaknadnoDostavljeno());
        return priloziUzZahtev;
    }

    private TPrilogUzZahtev marshalPrilogUzZahtev(PrilogUzZahtevDTO prilogUzZahtevDTO) {
        if (prilogUzZahtevDTO.getNazivDokumenta() == null) return new TPrilogUzZahtev();
        TPrilogUzZahtev prilogUzZahtev = new TPrilogUzZahtev();
        prilogUzZahtev.setNazivDokumenta(prilogUzZahtevDTO.getNazivDokumenta());
        prilogUzZahtev.setPutanjaDokumenta(prilogUzZahtevDTO.getPutanjaDokumenta());
        return prilogUzZahtev;
    }

    private ZahtevZaPriznanjeZiga.PlaceneTakse marshalPlaceneTakse(PlaceneTakseDTO placeneTakseDTO) {
        ZahtevZaPriznanjeZiga.PlaceneTakse placeneTakse = new ZahtevZaPriznanjeZiga.PlaceneTakse();
        placeneTakse.setOsnovnaTaksa(placeneTakseDTO.getOsnovnaTaksa());
        placeneTakse.setTaksaZaKlase(marshalTaksaZaKlase(placeneTakseDTO.getTaksaZaKlase()));
        placeneTakse.setTaksaZaGrafickoResenje(placeneTakseDTO.getTaksaZaGrafickoResenje());
        placeneTakse.setUkupnaTaksa(placeneTakseDTO.getUkupnaTaksa());
        return placeneTakse;
    }

    private ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase marshalTaksaZaKlase(TaksaZaKlaseDTO taksaZaKlaseDTO) {
        ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase taksaZaKlase = new ZahtevZaPriznanjeZiga.PlaceneTakse.TaksaZaKlase();
        taksaZaKlase.setBrojKlasa(taksaZaKlaseDTO.getBrojKlasa());
        taksaZaKlase.setVrednost(taksaZaKlaseDTO.getVrednost());
        return taksaZaKlase;
    }

    private ZahtevZaPriznanjeZiga.KlaseRobeIUsluga marshalKlaseRobeIUsluga(KlaseRobeIUslugaDTO klaseRobeIUslugaDTO) {
        ZahtevZaPriznanjeZiga.KlaseRobeIUsluga klaseRobeIUsluga = new ZahtevZaPriznanjeZiga.KlaseRobeIUsluga();
        klaseRobeIUsluga.getKlasa().addAll(klaseRobeIUslugaDTO.getKlasa());
        return klaseRobeIUsluga;
    }

    private ZahtevZaPriznanjeZiga.Zig marshalZig(ZigDTO zigDTO) {
        ZahtevZaPriznanjeZiga.Zig zig = new ZahtevZaPriznanjeZiga.Zig();
        zig.setIzgledZnaka(marshalIzgledZnaka(zigDTO.getIzgledZnaka()));
        zig.setTipZnaka(marshalTipZnaka(zigDTO.getTipZnaka()));
        zig.setTipZiga(marshalTipZiga(zigDTO.getTipZiga()));
        zig.setNaznaceneBoje(marshalNaznaceneBoje(zigDTO.getNaznaceneBoje()));
        zig.setTransliteracijaZnaka(zigDTO.getTransliteracijaZnaka());
        zig.setOpisZnaka(zigDTO.getOpisZnaka());
        zig.setPrevodZnaka(zigDTO.getPrevodZnaka());
        return zig;
    }

    private ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje marshalNaznaceneBoje(NaznaceneBojeDTO naznaceneBojeDTO) {
        ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje naznaceneBoje = new ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje();
        if (naznaceneBojeDTO.getBoja() == null) return new ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje();
        naznaceneBoje.getBoja().addAll(naznaceneBojeDTO.getBoja());
        return naznaceneBoje;
    }

    private ZahtevZaPriznanjeZiga.Zig.TipZiga marshalTipZiga(TipZigaDTO tipZigaDTO) {
        ZahtevZaPriznanjeZiga.Zig.TipZiga tipZiga = new ZahtevZaPriznanjeZiga.Zig.TipZiga();
        tipZiga.setIndividualniZig(tipZigaDTO.isIndividualniZig());
        tipZiga.setKolektivniZig(tipZigaDTO.isKolektivniZig());
        tipZiga.setZigGarancije(tipZigaDTO.isZigGarancije());
        return tipZiga;
    }

    private ZahtevZaPriznanjeZiga.Zig.TipZnaka marshalTipZnaka(TipZnakaDTO tipZnakaDTO) {
        ZahtevZaPriznanjeZiga.Zig.TipZnaka tipZnaka = new ZahtevZaPriznanjeZiga.Zig.TipZnaka();
        tipZnaka.setVerbalniZnak(tipZnakaDTO.isVerbalniZnak());
        tipZnaka.setGrafickiZnak(tipZnakaDTO.isGrafickiZnak());
        tipZnaka.setKombinovaniZnak(tipZnakaDTO.isKombinovaniZnak());
        tipZnaka.setTrodimenzionalniZnak(tipZnakaDTO.isTrodimenzionalniZnak());
        tipZnaka.setDrugaVrstaZnaka(tipZnakaDTO.isDrugaVrstaZnaka());
        return tipZnaka;
    }

    private ZahtevZaPriznanjeZiga.Zig.IzgledZnaka marshalIzgledZnaka(IzgledZnakaDTO izgledZnakaDTO) {
        ZahtevZaPriznanjeZiga.Zig.IzgledZnaka izgledZnaka = new ZahtevZaPriznanjeZiga.Zig.IzgledZnaka();
        izgledZnaka.setImageUrl(izgledZnakaDTO.getImageUrl());
        return izgledZnaka;
    }

    private TLice marshalZajednickiPredstavnikPodnosiocaPrijave(FizickoLiceDTO fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO,
                                                                PravnoLiceDTO pravniZajednickiPredstavnikPodnosiocaPrijaveDTO) {
        TLice zajednickiPredstavnikPodnosiocaPrijave = new TFizickoLice();
        if (fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO.getIme() == null && pravniZajednickiPredstavnikPodnosiocaPrijaveDTO.getNaziv() == null) {
            return new TFizickoLice();
        } else {
            if (fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO.getIme() != null) {
                ((TFizickoLice) zajednickiPredstavnikPodnosiocaPrijave).setIme(fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO.getIme());
                ((TFizickoLice) zajednickiPredstavnikPodnosiocaPrijave).setPrezime(fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO.getPrezime());
                zajednickiPredstavnikPodnosiocaPrijave.setAdresa(marshalAdresa(fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO.getAdresa()));
                zajednickiPredstavnikPodnosiocaPrijave.setKontaktPodaci(marshalKontaktPodaci(fizickiZajednickiPredstavnikPodnosiocaPrijaveDTO.getKontaktPodaci()));
            } else if (pravniZajednickiPredstavnikPodnosiocaPrijaveDTO.getNaziv() != null) {
                zajednickiPredstavnikPodnosiocaPrijave = new TPravnoLice();
                ((TPravnoLice) zajednickiPredstavnikPodnosiocaPrijave).setNaziv(pravniZajednickiPredstavnikPodnosiocaPrijaveDTO.getNaziv());
                zajednickiPredstavnikPodnosiocaPrijave.setAdresa(marshalAdresa(pravniZajednickiPredstavnikPodnosiocaPrijaveDTO.getAdresa()));
                zajednickiPredstavnikPodnosiocaPrijave.setKontaktPodaci(marshalKontaktPodaci(pravniZajednickiPredstavnikPodnosiocaPrijaveDTO.getKontaktPodaci()));
            }
            return zajednickiPredstavnikPodnosiocaPrijave;
        }
    }

    private TFizickoLice marshalPunomocnik(FizickoLiceDTO punomocnikDTO) {
        TFizickoLice punomocnik = new TFizickoLice();
        if (punomocnikDTO.getIme() == null) {
            return new TFizickoLice();
        }
        punomocnik.setIme(punomocnikDTO.getIme());
        punomocnik.setPrezime(punomocnikDTO.getPrezime());
        punomocnik.setAdresa(marshalAdresa(punomocnikDTO.getAdresa()));
        punomocnik.setKontaktPodaci(marshalKontaktPodaci(punomocnikDTO.getKontaktPodaci()));
        return punomocnik;
    }

    private ZahtevZaPriznanjeZiga.PodnosiociPrijave marshalPodnosioci(PodnosiociPrijaveDTO podnosiociPrijaveDTO) {
        ZahtevZaPriznanjeZiga.PodnosiociPrijave podnosiociPrijave = new ZahtevZaPriznanjeZiga.PodnosiociPrijave();
        if (!podnosiociPrijaveDTO.getFizickiPodnosiociPrijave().isEmpty()) {
            podnosiociPrijaveDTO.getFizickiPodnosiociPrijave().forEach(fizickiPodnosilac -> {
                TFizickoLice fizickoLice = new TFizickoLice();
                fizickoLice.setIme(fizickiPodnosilac.getIme());
                fizickoLice.setPrezime(fizickiPodnosilac.getPrezime());
                fizickoLice.setAdresa(marshalAdresa(fizickiPodnosilac.getAdresa()));
                fizickoLice.setKontaktPodaci(marshalKontaktPodaci(fizickiPodnosilac.getKontaktPodaci()));
                podnosiociPrijave.getPodnosilacPrijave().add(fizickoLice);
            });
        }
        if (!podnosiociPrijaveDTO.getPravniPodnosiociPrijave().isEmpty()) {
            podnosiociPrijaveDTO.getPravniPodnosiociPrijave().forEach(pravniPodnosilac -> {
                TPravnoLice pravnoLice = new TPravnoLice();
                pravnoLice.setNaziv(pravniPodnosilac.getNaziv());
                pravnoLice.setAdresa(marshalAdresa(pravniPodnosilac.getAdresa()));
                pravnoLice.setKontaktPodaci(marshalKontaktPodaci(pravniPodnosilac.getKontaktPodaci()));
                podnosiociPrijave.getPodnosilacPrijave().add(pravnoLice);
            });
        }
        return podnosiociPrijave;
    }

    private KontaktPodaci marshalKontaktPodaci(KontaktPodaciDTO kontaktPodaciDTO) {
        KontaktPodaci kontaktPodaci = new KontaktPodaci();
        kontaktPodaci.setBrojFaksa(kontaktPodaciDTO.getBrojFaksa());
        kontaktPodaci.setEmail(kontaktPodaciDTO.getEmail());
        kontaktPodaci.setBrojTelefona(kontaktPodaciDTO.getBrojTelefona());
        return kontaktPodaci;
    }

    private Adresa marshalAdresa(AdresaDTO adresaDTO) {
        Adresa adresa = new Adresa();
        adresa.setBroj(adresaDTO.getBroj());
        adresa.setDrzava(adresaDTO.getDrzava());
        adresa.setMesto(adresaDTO.getMesto());
        adresa.setUlica(adresaDTO.getUlica());
        adresa.setPostanskiBroj(adresaDTO.getPostanskiBroj());
        return adresa;
    }
}
