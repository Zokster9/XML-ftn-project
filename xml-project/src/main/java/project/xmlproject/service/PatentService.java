package project.xmlproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import project.xmlproject.database.PatentDatabase;
import project.xmlproject.database.RDFDatabase;
import project.xmlproject.dto.creationDto.KorisnikDTO;
import project.xmlproject.marshal.MarshalPatent;
import org.springframework.stereotype.Service;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.repository.PatentRepository;
import project.xmlproject.transformXML.PatentTransformation;

import java.io.IOException;
import java.util.List;

@Service
public class PatentService {

    @Autowired
    private RestTemplate restTemplate;

    PatentRepository patentRepository = new PatentRepository();
    PatentTransformation patentTransformation = new PatentTransformation();
    RDFDatabase rdfDatabase = new RDFDatabase();

    PatentDatabase patentDatabase = new PatentDatabase();

    MarshalPatent marshalPatent = new MarshalPatent();
    public ZahtevZaPriznanjePatenta addPatent(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = marshalPatent.marshalPatent(zahtevZaPriznanjePatentaCreationDto, "create");
        return patentRepository.save(zahtevZaPriznanjePatenta);
    }

    public ZahtevZaPriznanjePatenta getPatent() throws Exception {
        return patentRepository.getPatent();
    }

    public List<ZahtevZaPriznanjePatenta> getAllPatenti() throws Exception {
        return patentRepository.getAllPatenti();
    }

    public List<ZahtevZaPriznanjePatenta> getAllPatentiByKorisnik(String email) throws Exception {
        return patentRepository.getAllPatentiByUlogovani(email);
    }

    public ZahtevZaPriznanjePatenta createPatentHtml(String brojPrijave) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentDatabase.getByBrojPrijave(brojPrijave);
        String htmlFile = "src/main/resources/static/html/" + brojPrijave + ".html";
        patentTransformation.generateHTML(htmlFile, zahtevZaPriznanjePatenta);
        return zahtevZaPriznanjePatenta;
    }

    public ZahtevZaPriznanjePatenta createPatentPdf(String brojPrijave) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentDatabase.getByBrojPrijave(brojPrijave);
        String htmlFile = "src/main/resources/static/html/" + brojPrijave + ".html";
        String pdfFile = "src/main/resources/static/pdf/" + brojPrijave + ".pdf";
        patentTransformation.generateHTML(htmlFile, zahtevZaPriznanjePatenta);
        patentTransformation.generatePDF(htmlFile, pdfFile);
        return zahtevZaPriznanjePatenta;
    }

    public String createPatentRdfJson(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        return rdfDatabase.findRdfByPatentNumberAndGenerateFile(zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave());
    }

    public List<ZahtevZaPriznanjePatenta> getPatentsByText(String text) throws Exception {
        return patentRepository.getPatentsByText(text);
    }

    public List<ZahtevZaPriznanjePatenta> getPatentsByMetadata(String query) throws Exception {
        return patentRepository.getPatentsByMetadata(query);
    }

    public List<ZahtevZaPriznanjePatenta> getReferencedPatents(String patentNumber) throws Exception {
        return patentRepository.getReferencedPatents(patentNumber);
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

    public KorisnikDTO pronadjiKorisnika(String token) {
        final String uri = "http://localhost:9003/auth/get/" + token;

        ResponseEntity<KorisnikDTO> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<KorisnikDTO>() {
                });
        return responseEntity.getBody();
    }
}
