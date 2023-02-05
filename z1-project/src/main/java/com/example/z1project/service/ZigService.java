package com.example.z1project.service;


import com.example.z1project.database.RDFDatabase;
import com.example.z1project.database.ZigDatabase;
import com.example.z1project.dto.ZahtevZaPriznanjeZigaDTO;
import com.example.z1project.marshall.MarshallZig;
import com.example.z1project.model.zig.ResenjeZahteva;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;
import com.example.z1project.repository.ResenjeZahtevaRepository;
import com.example.z1project.repository.ZigRepository;
import com.example.z1project.transformXML.ZigTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZigService {

    @Autowired
    private KorisnikService korisnikService;

    private final ZigRepository zigRepository = new ZigRepository();

    private final ZigDatabase zigDatabase = new ZigDatabase();

    private final ZigTransformation zigTransformation = new ZigTransformation();

    private final MarshallZig marshallZig = new MarshallZig();

    private final RDFDatabase rdfDatabase = new RDFDatabase();

    private final ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    public ZahtevZaPriznanjeZiga kreirajZahtev(ZahtevZaPriznanjeZigaDTO zahtevZaPriznanjeZigaDTO) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = marshallZig.marshalZahtevZaPriznanjeZiga(zahtevZaPriznanjeZigaDTO);
        return zigRepository.save(zahtevZaPriznanjeZiga);
    }

    public ZahtevZaPriznanjeZiga getZig(String brojPrijaveZiga) throws Exception {
        return zigRepository.getZig(brojPrijaveZiga);
    }

    public ZahtevZaPriznanjeZiga createZigHtml(String brojPrijave) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigDatabase.getByBrojPrijave(brojPrijave);
        String htmlFile = "src/main/resources/static/html/" + brojPrijave + ".html";
        zahtevZaPriznanjeZiga.setIsPdf(false);
        zigTransformation.generateHTML(htmlFile, zahtevZaPriznanjeZiga);
        return zahtevZaPriznanjeZiga;
    }

    public ZahtevZaPriznanjeZiga createZigPdf(String token, String brojPrijave) throws Exception {
        proveriKorisnika(token, true);
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigDatabase.getByBrojPrijave(brojPrijave);
        zahtevZaPriznanjeZiga.setIsPdf(true);
        String htmlFile = "src/main/resources/static/html/" + brojPrijave + ".html";
        String pdfFile = "src/main/resources/static/pdf/" + brojPrijave + ".pdf";
        zigTransformation.generateHTML(htmlFile, zahtevZaPriznanjeZiga);
        zigTransformation.generatePDF(htmlFile, pdfFile);
        return zahtevZaPriznanjeZiga;
    }

    public boolean proveriKorisnika(String token, boolean korisnikJeSluzbenik) throws Exception {
        return korisnikService.proveriKorisnika(token, korisnikJeSluzbenik);
    }

    public List<ZahtevZaPriznanjeZiga> dobaviSve(String token) throws Exception {
        if (proveriKorisnika(token, true)) {
            return zigRepository.getAll();
        } else {
            List<ZahtevZaPriznanjeZiga> povratna = new ArrayList<>();
            List<ZahtevZaPriznanjeZiga> zahtevi = zigRepository.getAll();
            for (ZahtevZaPriznanjeZiga zahtev : zahtevi) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuZahteva(
                        zahtev.getPodaciOPrijavi().getBrojPrijaveZiga());
                if (resenjeZahteva != null) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) povratna.add(zahtev);
                }
            }
            return povratna;
        }
    }

    public String kreirajRdfJson(String brojZiga) {
        return rdfDatabase.pronadjiRdfPoBrojuZiga(brojZiga);
    }

    public List<ZahtevZaPriznanjeZiga> dobaviPoTekstu(String token, String tekst) throws Exception {
        if (proveriKorisnika(token, true)) {
            return zigRepository.dobaviPoTekstu(tekst);
        } else {
            List<ZahtevZaPriznanjeZiga> povratna = new ArrayList<>();
            List<ZahtevZaPriznanjeZiga> zahtevi = zigRepository.dobaviPoTekstu(tekst);
            for (ZahtevZaPriznanjeZiga zahtev: zahtevi) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuZahteva(zahtev.getPodaciOPrijavi()
                        .getBrojPrijaveZiga());
                if (resenjeZahteva != null) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) povratna.add(zahtev);
                }
            }
            return povratna;
        }
    }

    public List<ZahtevZaPriznanjeZiga> dobaviPoMetapodacima(String token, String upit) throws Exception {
        if (proveriKorisnika(token, true)) {
            return zigRepository.dobaviPoMetapodacima(upit);
        } else {
            List<ZahtevZaPriznanjeZiga> povratna = new ArrayList<>();
            List<ZahtevZaPriznanjeZiga> zahtevi = zigRepository.dobaviPoMetapodacima(upit);
            for (ZahtevZaPriznanjeZiga zahtev: zahtevi) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuZahteva(zahtev.getPodaciOPrijavi()
                        .getBrojPrijaveZiga());
                if (resenjeZahteva != null) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) povratna.add(zahtev);
                }
            }
            return povratna;
        }
    }
}
