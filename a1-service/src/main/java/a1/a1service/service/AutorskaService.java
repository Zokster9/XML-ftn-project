package a1.a1service.service;

import a1.a1service.database.RDFDatabase;
import a1.a1service.dto.KorisnikDTO;
import a1.a1service.dto.ObrazacAutorskoDeloCreationDTO;
import a1.a1service.marshal.MarshalAutorska;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.repository.AutorskaRepository;
import a1.a1service.transform.AutorskaTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.List;

@Service
public class AutorskaService {

    @Autowired
    private RestTemplate restTemplate;

    AutorskaRepository autorskaRepository = new AutorskaRepository();

    MarshalAutorska marshalAutorska = new MarshalAutorska();

    AutorskaTransform autorskaTransform = new AutorskaTransform();

    RDFDatabase rdfDatabase = new RDFDatabase();

    public ObrazacAutorskoDelo kreirajZahtev(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) throws Exception {
        ObrazacAutorskoDelo obrazacAutorskoDelo = marshalAutorska.marshalAutorska(obrazacAutorskoDeloCreationDTO);
        return autorskaRepository.kreiraj(obrazacAutorskoDelo);
    }

    public  ObrazacAutorskoDelo dobaviAutorskoDelo(String brojAutorskogDela) throws Exception {
        return autorskaRepository.dobaviAutorsko(brojAutorskogDela);
    }

    public void kreirajHTML(ObrazacAutorskoDelo obrazacAutorskoDelo) {
        String htmlFajl = "src/main/resources/static/html/" + obrazacAutorskoDelo.getBrojPrijave() + ".html";
        autorskaTransform.kreirajHTML(obrazacAutorskoDelo, htmlFajl);
    }

    public void kreirajPDF(ObrazacAutorskoDelo obrazacAutorskoDelo) throws IOException {
        String htmlFajl = "src/main/resources/static/html/" + obrazacAutorskoDelo.getBrojPrijave() + ".html";
        String pdfFajl = "src/main/resources/static/pdf/" + obrazacAutorskoDelo.getBrojPrijave() + ".pdf";
        autorskaTransform.kreirajPDF(htmlFajl, pdfFajl);
    }

    public List<ObrazacAutorskoDelo> dobaviSve() throws Exception {
        return autorskaRepository.dobaviSve();
    }

    public String kreirajRdfJson(String brojAutorskog) {
        return rdfDatabase.pronadjiRdfPoBrojuObrasca(brojAutorskog);
    }

    public List<ObrazacAutorskoDelo> dobaviPoTekstu(String tekst) throws IOException, ClassNotFoundException, XMLDBException, InstantiationException, IllegalAccessException {
        return autorskaRepository.dobaviPoTekstu(tekst);
    }

    public List<ObrazacAutorskoDelo> dobaviPoMetapodacima(String upit) throws Exception {
        return autorskaRepository.dobaviPoMetapodacima(upit);
    }

    public boolean proveriKorisnika(String token, boolean korisnikJeSluzbenik) {
        final String uri = "http://localhost:9003/auth/get/" + token;

        ResponseEntity<KorisnikDTO> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<KorisnikDTO>() {
                });
        KorisnikDTO korisnikDTO = responseEntity.getBody();
        if (korisnikDTO != null) {
            return korisnikDTO.isKorisnikJeSluzbenik() == korisnikJeSluzbenik;
        }
        return false;
    }
}
