package project.xmlproject.service;

import org.springframework.stereotype.Service;
import project.xmlproject.database.RDFDatabase;
import project.xmlproject.dto.creationDto.KorisnikDTO;
import project.xmlproject.dto.creationDto.ReportDatesDto;
import project.xmlproject.dto.creationDto.ResenjeZahtevaDto;
import project.xmlproject.marshal.MarshalResenjeZahteva;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
import project.xmlproject.repository.ResenjeZahtevaRepository;
import project.xmlproject.transformXML.PatentTransformation;

import java.text.ParseException;

@Service
public class ResenjeZahtevaService {

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    MarshalResenjeZahteva marshalResenjeZahteva = new MarshalResenjeZahteva();
    RDFDatabase rdfDatabase = new RDFDatabase();

    PatentTransformation patentTransformation = new PatentTransformation();

    public ResenjeZahteva addResenjeZahteva(ResenjeZahtevaDto resenjeZahtevaDto, KorisnikDTO korisnikDTO) throws Exception {
        ResenjeZahteva resenjeZahteva = marshalResenjeZahteva.marshalResenjeZahteva(resenjeZahtevaDto, korisnikDTO, "create");
        return resenjeZahtevaRepository.save(resenjeZahteva);
    }

    public void createReport(ReportDatesDto reportDatesDto) throws ParseException {
        rdfDatabase.generateReport(reportDatesDto.getStartDate(), reportDatesDto.getEndDate());
    }

    public ResenjeZahteva getResenjeZahtevaByReferenca(String patentNumber) throws Exception {
        ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.findByReferenca(patentNumber);
        patentTransformation.generateResenjeZahtevaHTML("src/main/resources/static/html/"
                + resenjeZahteva.getReferenca() +
                "_resenje.html", resenjeZahteva);
        return resenjeZahteva;
    }
}
