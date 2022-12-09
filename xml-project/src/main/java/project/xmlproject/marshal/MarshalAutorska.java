package project.xmlproject.marshal;

import project.xmlproject.dto.autorska.*;
import project.xmlproject.model.autorska.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MarshalAutorska {

    public MarshalAutorska() {
    }

    public ObrazacAutorskoDelo marshalAutorska(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) throws DatatypeConfigurationException {
        ObrazacAutorskoDelo obrazacAutorskoDelo = new ObrazacAutorskoDelo();

        obrazacAutorskoDelo.setPodnosilac(marshalPodnosilac(obrazacAutorskoDeloCreationDTO));

        obrazacAutorskoDelo.setPunomocnik(marshalPunomocnik(obrazacAutorskoDeloCreationDTO));

        obrazacAutorskoDelo.setPodaciOAutorskomDelu(marshalPodaciOAutorskomDelu(obrazacAutorskoDeloCreationDTO.getPodaciOAutorskomDeluDTO()));

        obrazacAutorskoDelo.setPriloziUzPrijavu(marshalPriloziUzPrijavu(obrazacAutorskoDeloCreationDTO.getPriloziUzPrijavuDTO()));

        obrazacAutorskoDelo.setBrojPrijave(marshalGenerisanjeBrojaObrasca());

        obrazacAutorskoDelo.setDatumPrijave(marshalGenerisanjeDatumaPrijave());

        return obrazacAutorskoDelo;
    }

    public String marshalGenerisanjeBrojaObrasca() {
        String brojObrasca = "A-";
        Date now = new Date();
        brojObrasca += String.valueOf(now.getTime());
        return brojObrasca;
    }

    public XMLGregorianCalendar marshalGenerisanjeDatumaPrijave() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }

    public TLice marshalPodnosilac(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) {
        if (obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO() != null) {
            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setIme(obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO().getIme());
            podnosilac.setPrezime(obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO().getPrezime());
            podnosilac.setDrzavljanstvo(obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO().getDrzavljanstvo());
            podnosilac.setEmail(obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO().getEmail());
            podnosilac.setTelefon(obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO().getTelefon());
            Adresa adresa = marshalAdresa(obrazacAutorskoDeloCreationDTO.getFizickoLiceDTO().getAdresaLica());
            podnosilac.setAdresaLica(adresa);
            return podnosilac;
        } else {
            TPravnoLice podnosilac = new TPravnoLice();
            podnosilac.setEmail(obrazacAutorskoDeloCreationDTO.getPravnoLiceDTO().getEmail());
            podnosilac.setTelefon(obrazacAutorskoDeloCreationDTO.getPravnoLiceDTO().getTelefon());
            podnosilac.setPoslovnoIme(obrazacAutorskoDeloCreationDTO.getPravnoLiceDTO().getPoslovnoIme());
            Adresa adresa = marshalAdresa(obrazacAutorskoDeloCreationDTO.getPravnoLiceDTO().getSediste());
            podnosilac.setSediste(adresa);
            return podnosilac;
        }
    }

    public Punomocnik marshalPunomocnik(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) {
        if (obrazacAutorskoDeloCreationDTO.getPunomocnikDTO() != null) {
            Punomocnik punomocnik = new Punomocnik();
            punomocnik.setIme(obrazacAutorskoDeloCreationDTO.getPunomocnikDTO().getIme());
            punomocnik.setPrezime(obrazacAutorskoDeloCreationDTO.getPunomocnikDTO().getPrezime());
            Adresa adresa = marshalAdresa(obrazacAutorskoDeloCreationDTO.getPunomocnikDTO().getAdresa());
            punomocnik.setAdresa(adresa);
            return punomocnik;
        } else {
            return null;
        }
    }

    public PodaciOAutorskomDelu marshalPodaciOAutorskomDelu(PodaciOAutorskomDeluDTO podaciOAutorskomDeluDTO) {
        PodaciOAutorskomDelu podaciOAutorskomDelu = new PodaciOAutorskomDelu();
        podaciOAutorskomDelu.setNaslov(podaciOAutorskomDeluDTO.getNaslov());
        podaciOAutorskomDelu.setAlternativniNaslov(podaciOAutorskomDeluDTO.getAlternativniNaslov());
        podaciOAutorskomDelu.setVrsta(podaciOAutorskomDeluDTO.getVrsta());
        podaciOAutorskomDelu.setFormaZapisa(podaciOAutorskomDeluDTO.getFormaZapisa());
        podaciOAutorskomDelu.setNaslovAutorskogDelaPrerade(podaciOAutorskomDeluDTO.getNaslovAutorskogDelaPrerade());
        podaciOAutorskomDelu.setStvorenoURadnomOdnosu(podaciOAutorskomDeluDTO.getStvorenoURadnomOdnosu());
        podaciOAutorskomDelu.setAnonimniAutor(podaciOAutorskomDeluDTO.isAnonimniAutor());
        if (!podaciOAutorskomDeluDTO.isAnonimniAutor()) {
            podaciOAutorskomDelu.setAutori(marshalPodaciOAutorima(podaciOAutorskomDeluDTO.getAutori()));
        }
        return podaciOAutorskomDelu;
    }

    public List<PodaciOAutoru> marshalPodaciOAutorima(List<PodaciOAutoruDTO> autoriDTO) {
        List<PodaciOAutoru> autori = new ArrayList<>();
        for (PodaciOAutoruDTO autorDTO: autoriDTO) {
            PodaciOAutoru podaciOAutoru = new PodaciOAutoru();
            podaciOAutoru.setIme(autorDTO.getIme());
            podaciOAutoru.setPrezime(autorDTO.getPrezime());
            podaciOAutoru.setZnak(autorDTO.getZnak());
            podaciOAutoru.setDrzavljanstvo(autorDTO.getDrzavljanstvo());
            podaciOAutoru.setGodinaSmrti(autorDTO.getGodinaSmrti());
            Adresa adresa = marshalAdresa(autorDTO.getAdresa());
            podaciOAutoru.setAdresa(adresa);
            autori.add(podaciOAutoru);
        }
        return autori;
    }

    public PriloziUzPrijavu marshalPriloziUzPrijavu(PriloziUzPrijavuDTO priloziUzPrijavuDTO) {
        PriloziUzPrijavu priloziUzPrijavu = new PriloziUzPrijavu();
        priloziUzPrijavu.setOpisAutorskogDela(priloziUzPrijavuDTO.getOpisAutorskogDela());
        priloziUzPrijavu.setPrimerAutorskogDela(priloziUzPrijavuDTO.getPrimerAutorskogDela());
        return priloziUzPrijavu;
    }

    public Adresa marshalAdresa(AdresaDTO adresaDTO) {
        Adresa adresa = new Adresa();
        adresa.setDrzava(adresaDTO.getDrzava());
        adresa.setPostanskiBroj(adresaDTO.getPostanskiBroj());
        adresa.setBroj(adresaDTO.getBroj());
        adresa.setGrad(adresaDTO.getGrad());
        adresa.setUlica(adresaDTO.getUlica());
        return adresa;
    }
}
