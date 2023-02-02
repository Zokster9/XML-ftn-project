package com.example.z1project.service;

import com.example.z1project.database.RDFDatabase;
import com.example.z1project.dto.KorisnikDTO;
import com.example.z1project.dto.ReportDatesDTO;
import com.example.z1project.dto.ResenjeZahtevaDTO;
import com.example.z1project.marshall.MarshalResenjeZahteva;
import com.example.z1project.model.zig.ResenjeZahteva;
import com.example.z1project.repository.ResenjeZahtevaRepository;
import com.example.z1project.transformXML.ZigTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ResenjeZahtevaService {

    @Autowired
    private KorisnikService korisnikService;

    MarshalResenjeZahteva marshalResenjeZahteva = new MarshalResenjeZahteva();

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    ZigTransformation zigTransformation = new ZigTransformation();

    RDFDatabase rdfDatabase = new RDFDatabase();


    public boolean proveriKorisnika(String token, boolean korisnikJeSluzbenik) throws Exception {
        return korisnikService.proveriKorisnika(token, korisnikJeSluzbenik);
    }

    public ResenjeZahteva dodajResenjeZahteva(String token, ResenjeZahtevaDTO resenjeZahtevaDTO) throws Exception {
        KorisnikDTO korisnikDTO = korisnikService.dobaviKorisnika(token);
        ResenjeZahteva resenjeZahteva = marshalResenjeZahteva.marshalResenjeZahteva(resenjeZahtevaDTO, korisnikDTO);
        return resenjeZahtevaRepository.kreiraj(resenjeZahteva);
    }

    public void kreirajIzvestaj(ReportDatesDTO reportDatesDTO) throws DatatypeConfigurationException {
        rdfDatabase.kreirajIzvestaj(konvertujDatum(reportDatesDTO.getPocetniDatum()), konvertujDatum(reportDatesDTO.getKrajnjiDatum()));
    }

    private XMLGregorianCalendar konvertujDatum(Date date) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }
}
