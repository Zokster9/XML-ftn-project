package project.xmlproject.service;

import org.springframework.stereotype.Service;
import project.xmlproject.database.RDFDatabase;
import project.xmlproject.dto.creationDto.ReportDatesDto;
import project.xmlproject.dto.creationDto.ResenjeZahtevaDto;
import project.xmlproject.marshal.MarshalResenjeZahteva;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
import project.xmlproject.repository.ResenjeZahtevaRepository;

import java.text.ParseException;

@Service
public class ResenjeZahtevaService {

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    MarshalResenjeZahteva marshalResenjeZahteva = new MarshalResenjeZahteva();
    RDFDatabase rdfDatabase = new RDFDatabase();

    public ResenjeZahteva addResenjeZahteva(ResenjeZahtevaDto resenjeZahtevaDto) throws Exception {
        ResenjeZahteva resenjeZahteva = marshalResenjeZahteva.marshalResenjeZahteva(resenjeZahtevaDto, "create");
        return resenjeZahtevaRepository.save(resenjeZahteva);
    }

    public void createReport(ReportDatesDto reportDatesDto) throws ParseException {
        rdfDatabase.generateReport(reportDatesDto.getStartDate(), reportDatesDto.getEndDate());
    }
}
