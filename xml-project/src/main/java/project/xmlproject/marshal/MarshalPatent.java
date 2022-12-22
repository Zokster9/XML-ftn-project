package project.xmlproject.marshal;

import project.xmlproject.dto.creationDto.AdresaCreationDto;
import project.xmlproject.dto.creationDto.KontaktPodaciCreationDto;
import project.xmlproject.dto.creationDto.PriznanjePravaPrvenstvaCreationDto;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Objects;

public class MarshalPatent {

    public MarshalPatent() {

    }

    public ZahtevZaPriznanjePatenta marshalPatent(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto, String option)
            throws JAXBException, IOException {

        //root
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = new ZahtevZaPriznanjePatenta();

        //root elements
        //1. element: podaciOPrijavama
        ZahtevZaPriznanjePatenta.PodaciOPrijavama podaciOPrijavama = new ZahtevZaPriznanjePatenta.PodaciOPrijavama();

        //subelements of podaciOPrijavama: NovaPrijava, DodatnaPrijava, PriznanjaPravaPrventsva
        NovaPrijava novaPrijava = marshalNovaPrijava(zahtevZaPriznanjePatentaCreationDto, option);
        DodatnaPrijava dodatnaPrijava = marshalDodatnaPrijava(zahtevZaPriznanjePatentaCreationDto);
        ZahtevZaPriznanjePatenta.PodaciOPrijavama.PriznanjaPravaPrvenstva priznanjaPravaPrvenstva = marshalPriznanjaPravaPrvenstva(zahtevZaPriznanjePatentaCreationDto);

        podaciOPrijavama.setNovaPrijava(novaPrijava);
        podaciOPrijavama.setDodatnaPrijava(dodatnaPrijava);
        podaciOPrijavama.setPriznanjaPravaPrvenstva(priznanjaPravaPrvenstva);

        ZahtevZaPriznanjePatenta.NazivPronalaska nazivPronalaska = marshalNazivPronalska(zahtevZaPriznanjePatentaCreationDto);

        ZahtevZaPriznanjePatenta.Podnosilac podnosilac = marshalPodnosilac(zahtevZaPriznanjePatentaCreationDto);

        ZahtevZaPriznanjePatenta.Pronalazac pronalazac = marshalPronalazac(zahtevZaPriznanjePatentaCreationDto);

        ZahtevZaPriznanjePatenta.Punomocnik punomocnik = marshalPunomocnik(zahtevZaPriznanjePatentaCreationDto);

        zahtevZaPriznanjePatenta.setPodaciOPrijavama(podaciOPrijavama);
        zahtevZaPriznanjePatenta.setNazivPronalaska(nazivPronalaska);
        zahtevZaPriznanjePatenta.setPodnosilac(podnosilac);
        zahtevZaPriznanjePatenta.setPronalazac(pronalazac);
        zahtevZaPriznanjePatenta.setPunomocnik(punomocnik);

        return zahtevZaPriznanjePatenta;
    }

    public NovaPrijava marshalNovaPrijava(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto, String option) {

        NovaPrijava novaPrijava = new NovaPrijava();

        if (option.equals("create")) {
            long miliseconds = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String date = timestamp.toString().substring(0, 10);

            novaPrijava.setBrojPrijave('P'+String.valueOf(miliseconds));
            novaPrijava.setDatumPrijave(date);
            novaPrijava.setPriznatiDatumPrijave("");
        }
        else {
            novaPrijava.setBrojPrijave(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave());
            novaPrijava.setDatumPrijave(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getDatumPrijave());
            novaPrijava.setPriznatiDatumPrijave(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getPriznatiDatumPrijave());
        }

        return novaPrijava;
    }

    public DodatnaPrijava marshalDodatnaPrijava(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        DodatnaPrijava dodatnaPrijava = new DodatnaPrijava();
        DodatnaPrijava.TipPrijave tipPrijave = new DodatnaPrijava.TipPrijave();
        if (Objects.equals(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getDodatnaPrijava().getTipPrijave(), "dopunska")) {
            tipPrijave.setDopunskaPrijava("");
        } else {
            tipPrijave.setIzdvojenaPrijava("");
        }
        dodatnaPrijava.setTipPrijave(tipPrijave);
        dodatnaPrijava.setBrojPrvobitnePrijave(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getDodatnaPrijava().getBrojPrvobitnePrijave());
        dodatnaPrijava.setDatumPodnosenjaPrijave(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getDodatnaPrijava().getDatumPodnosenjaPrijave());
        return dodatnaPrijava;
    }

    public ZahtevZaPriznanjePatenta.PodaciOPrijavama.PriznanjaPravaPrvenstva marshalPriznanjaPravaPrvenstva(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        ZahtevZaPriznanjePatenta.PodaciOPrijavama.PriznanjaPravaPrvenstva priznanjaPravaPrvenstva = new ZahtevZaPriznanjePatenta.PodaciOPrijavama.PriznanjaPravaPrvenstva();
        for (PriznanjePravaPrvenstvaCreationDto p : zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getPriznanjaPravaPrvenstva()) {
            priznanjaPravaPrvenstva.getPriznanjePravaPrvenstva().add(marshalPriznanjePravaPrvenstva(p));
        }
        return priznanjaPravaPrvenstva;
    }

    public PriznanjePravaPrvenstva marshalPriznanjePravaPrvenstva(PriznanjePravaPrvenstvaCreationDto priznanjePravaPrvenstvaCreationDto) {
        PriznanjePravaPrvenstva priznanjePravaPrvenstva = new PriznanjePravaPrvenstva();
        priznanjePravaPrvenstva.setDatumPrijave(priznanjePravaPrvenstvaCreationDto.getDatumPrijave());
        priznanjePravaPrvenstva.setBrojRanijePrijave(priznanjePravaPrvenstvaCreationDto.getBrojRanijePrijave());
        priznanjePravaPrvenstva.setDvoslovnaOznakaDrzaveOrganizacije(priznanjePravaPrvenstvaCreationDto.getDvoslovnaOznakaDrzaveOrganizacije());
        return priznanjePravaPrvenstva;
    }

    public ZahtevZaPriznanjePatenta.NazivPronalaska marshalNazivPronalska(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        ZahtevZaPriznanjePatenta.NazivPronalaska nazivPronalaska = new ZahtevZaPriznanjePatenta.NazivPronalaska();
        nazivPronalaska.setSrpskiNaziv(zahtevZaPriznanjePatentaCreationDto.getNazivPronalaska().getSrpskiNaziv());
        nazivPronalaska.setEngleskiNaziv(zahtevZaPriznanjePatentaCreationDto.getNazivPronalaska().getEngleskiNaziv());
        return nazivPronalaska;
    }

    public ZahtevZaPriznanjePatenta.Podnosilac marshalPodnosilac(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        ZahtevZaPriznanjePatenta.Podnosilac podnosilac = new ZahtevZaPriznanjePatenta.Podnosilac();
        podnosilac.setAdresa(marshalAdresa(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getAdresa()));
        podnosilac.setKontaktPodaci(marshalKontaktPodaci(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getKontaktPodaci()));
        podnosilac.setDrzavljanstvo(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getDrzavljanstvo());
        podnosilac.setNaziv(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getNaziv());
        podnosilac.setPodnosilacJePronalazac(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getPodnosilacJePronalazac());
        podnosilac.setNacinDostavljanja(marshalNacinDostavljanja(zahtevZaPriznanjePatentaCreationDto));
        return podnosilac;
    }

    public ZahtevZaPriznanjePatenta.Pronalazac marshalPronalazac(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        ZahtevZaPriznanjePatenta.Pronalazac pronalazac = new ZahtevZaPriznanjePatenta.Pronalazac();
        pronalazac.setAdresa(marshalAdresa(zahtevZaPriznanjePatentaCreationDto.getPronalazac().getAdresa()));
        pronalazac.setKontaktPodaci(marshalKontaktPodaci(zahtevZaPriznanjePatentaCreationDto.getPunomocnik().getKontaktPodaci()));
        pronalazac.setNaziv(zahtevZaPriznanjePatentaCreationDto.getPronalazac().getNaziv());
        pronalazac.setZeliBitiUPrijavi(zahtevZaPriznanjePatentaCreationDto.getPronalazac().getZeliBitiUPrijavi());
        return pronalazac;
    }

    public ZahtevZaPriznanjePatenta.Punomocnik marshalPunomocnik(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        ZahtevZaPriznanjePatenta.Punomocnik punomocnik = new ZahtevZaPriznanjePatenta.Punomocnik();
        punomocnik.setAdresa(marshalAdresa(zahtevZaPriznanjePatentaCreationDto.getPunomocnik().getAdresa()));
        punomocnik.setKontaktPodaci(marshalKontaktPodaci(zahtevZaPriznanjePatentaCreationDto.getPunomocnik().getKontaktPodaci()));
        punomocnik.setNaziv(zahtevZaPriznanjePatentaCreationDto.getPunomocnik().getNaziv());
        punomocnik.setZajednickiPredstavnik(zahtevZaPriznanjePatentaCreationDto.getPunomocnik().getZajednickiPredstavnik());
        ZahtevZaPriznanjePatenta.Punomocnik.TipPunomocnika tipPunomocnika = new ZahtevZaPriznanjePatenta.Punomocnik.TipPunomocnika();
        if (zahtevZaPriznanjePatentaCreationDto.getPunomocnik().getTipPunomocnika().equals("zastupanje")){
            tipPunomocnika.setPunomocnikZaZastupanje("");
        }
        else {
            tipPunomocnika.setPunomocnikZaPrijemPismena("");
        }
        punomocnik.setTipPunomocnika(tipPunomocnika);
        return punomocnik;
    }

    public Adresa marshalAdresa(AdresaCreationDto adresaCreationDto) {
        Adresa adresa = new Adresa();
        adresa.setPostanskiBroj(adresaCreationDto.getPostanskiBroj());
        adresa.setUlicaIBroj(adresaCreationDto.getUlicaIBroj());
        adresa.setDrzava(adresaCreationDto.getDrzava());
        adresa.setMesto(adresaCreationDto.getMesto());
        return adresa;
    }

    public KontaktPodaci marshalKontaktPodaci(KontaktPodaciCreationDto kontaktPodaciCreationDto) {
        KontaktPodaci kontaktPodaci = new KontaktPodaci();
        kontaktPodaci.setBrojFaksa(kontaktPodaciCreationDto.getBrojFaksa());
        kontaktPodaci.setBrojTelefona(kontaktPodaciCreationDto.getBrojTelefona());
        kontaktPodaci.setEPosta(kontaktPodaciCreationDto.getePosta());
        return kontaktPodaci;
    }

    public ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja marshalNacinDostavljanja(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja nacinDostavljanja = new ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja();
        if (zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getNacinDostavljanja().getNacinDostavljanja().equals("elektronski")) {
            ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja.Elektronski elektronski = new ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja.Elektronski();
            elektronski.setEmail(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getNacinDostavljanja().getEmail());
            nacinDostavljanja.setElektronski(elektronski);
        } else {
            ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja.Papirni papirni = new ZahtevZaPriznanjePatenta.Podnosilac.NacinDostavljanja.Papirni();
            papirni.setAdresa(marshalAdresa(zahtevZaPriznanjePatentaCreationDto.getPodnosilac().getNacinDostavljanja().getAdresa()));
            nacinDostavljanja.setPapirni(papirni);
        }
        return nacinDostavljanja;
    }
}
