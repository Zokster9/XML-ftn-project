package project.xmlproject.service;

import project.xmlproject.database.RDFDatabase;
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

    PatentRepository patentRepository = new PatentRepository();
    PatentTransformation patentTransformation = new PatentTransformation();
    RDFDatabase rdfDatabase = new RDFDatabase();

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

    public void createPatentHtml(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        String htmlFile = "src/main/resources/static/html/" + zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".html";
        patentTransformation.generateHTML(htmlFile, zahtevZaPriznanjePatentaCreationDto);
    }

    public void createPatentPdf(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws IOException {
        String htmlFile = "src/main/resources/static/html/" + zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".html";
        String pdfFile = "src/main/resources/static/pdf/" + zahtevZaPriznanjePatentaCreationDto.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".pdf";
        patentTransformation.generatePDF(htmlFile, pdfFile);
    }
}
