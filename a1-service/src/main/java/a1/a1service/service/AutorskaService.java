package a1.a1service.service;

import a1.a1service.database.RDFDatabase;
import a1.a1service.dto.KorisnikDTO;
import a1.a1service.dto.ObrazacAutorskoDeloCreationDTO;
import a1.a1service.marshal.MarshalAutorska;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.model.ResenjeZahteva;
import a1.a1service.repository.AutorskaRepository;
import a1.a1service.repository.ResenjeZahtevaRepository;
import a1.a1service.transform.AutorskaTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutorskaService {

    @Autowired
    private KorisnikService korisnikService;

    AutorskaRepository autorskaRepository = new AutorskaRepository();

    MarshalAutorska marshalAutorska = new MarshalAutorska();

    AutorskaTransform autorskaTransform = new AutorskaTransform();

    RDFDatabase rdfDatabase = new RDFDatabase();

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    public ObrazacAutorskoDelo kreirajZahtev(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) throws Exception {
        ObrazacAutorskoDelo obrazacAutorskoDelo = marshalAutorska.marshalAutorska(obrazacAutorskoDeloCreationDTO);
        return autorskaRepository.kreiraj(obrazacAutorskoDelo);
    }

    public  ObrazacAutorskoDelo dobaviAutorskoDelo(String brojAutorskogDela) throws Exception {
        return autorskaRepository.dobaviAutorsko(brojAutorskogDela);
    }

    public void kreirajHTML(String token, ObrazacAutorskoDelo obrazacAutorskoDelo) {
        String htmlFajl = "src/main/resources/static/html/" + obrazacAutorskoDelo.getBrojPrijave() + ".html";
        autorskaTransform.kreirajHTML(obrazacAutorskoDelo, htmlFajl);
    }

    public void kreirajPDF(String token, ObrazacAutorskoDelo obrazacAutorskoDelo) throws Exception {
        proveriKorisnika(token, true);
        String htmlFajl = "src/main/resources/static/html/" + obrazacAutorskoDelo.getBrojPrijave() + ".html";
        String pdfFajl = "src/main/resources/static/pdf/" + obrazacAutorskoDelo.getBrojPrijave() + ".pdf";
        autorskaTransform.kreirajPDF(htmlFajl, pdfFajl);
    }

    public List<ObrazacAutorskoDelo> dobaviSve(String token) throws Exception {
        if (proveriKorisnika(token, true)) {
            return autorskaRepository.dobaviSve();
        }else {
            List<ObrazacAutorskoDelo> povratna = new ArrayList<>();
            List<ObrazacAutorskoDelo> obrasci = autorskaRepository.dobaviSve();
            for (ObrazacAutorskoDelo obrazac: obrasci) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuAutorskog(obrazac.getBrojPrijave());
                if (resenjeZahteva != null) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) povratna.add(obrazac);
                }
            }
            return povratna;
        }
    }

    public String kreirajRdfJson(String brojAutorskog) {
        return rdfDatabase.pronadjiRdfPoBrojuObrasca(brojAutorskog);
    }

    public List<ObrazacAutorskoDelo> dobaviPoTekstu(String token, String tekst) throws Exception {
        if (proveriKorisnika(token, true)) {
            return autorskaRepository.dobaviPoTekstu(tekst);
        }else {
            List<ObrazacAutorskoDelo> povratna = new ArrayList<>();
            List<ObrazacAutorskoDelo> obrasci = autorskaRepository.dobaviPoTekstu(tekst);
            for (ObrazacAutorskoDelo obrazac: obrasci) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuAutorskog(obrazac.getBrojPrijave());
                if (resenjeZahteva != null) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) povratna.add(obrazac);
                }
            }
            return povratna;
        }
    }

    public List<ObrazacAutorskoDelo> dobaviPoMetapodacima(String token, String upit) throws Exception {
        if (proveriKorisnika(token, true)) {
            return autorskaRepository.dobaviPoMetapodacima(upit);
        }else {
            List<ObrazacAutorskoDelo> povratna = new ArrayList<>();
            List<ObrazacAutorskoDelo> obrasci = autorskaRepository.dobaviPoMetapodacima(upit);
            for (ObrazacAutorskoDelo obrazac: obrasci) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuAutorskog(obrazac.getBrojPrijave());
                if (resenjeZahteva != null) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) povratna.add(obrazac);
                }
            }
            return povratna;
        }
    }

    public boolean proveriKorisnika(String token, boolean korisnikJeSluzbenik) throws Exception {
        return korisnikService.proveriKorisnika(token, korisnikJeSluzbenik);
    }
}
