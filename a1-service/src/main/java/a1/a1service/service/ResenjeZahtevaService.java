package a1.a1service.service;

import a1.a1service.database.RDFDatabase;
import a1.a1service.dto.IzvestajDatumiDTO;
import a1.a1service.dto.ResenjeZahtevaDTO;
import a1.a1service.marshal.MarshalResenjeZahteva;
import a1.a1service.model.ResenjeZahteva;
import a1.a1service.repository.ResenjeZahtevaRepository;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ResenjeZahtevaService {

    MarshalResenjeZahteva marshalResenjeZahteva = new MarshalResenjeZahteva();

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    RDFDatabase rdfDatabase = new RDFDatabase();

    public ResenjeZahteva dodajResenjeZahteva(ResenjeZahtevaDTO resenjeZahtevaDTO) throws DatatypeConfigurationException, XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ResenjeZahteva resenjeZahteva = marshalResenjeZahteva.marshalResenjeZahteva(resenjeZahtevaDTO);
        return resenjeZahtevaRepository.kreiraj(resenjeZahteva);
    }

    public ResenjeZahteva dobaviPoBrojuAutorskog(String brojAutorskog) throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaRepository.dobaviPoBrojuAutorskog(brojAutorskog);
    }

    public void kreirajIzvestaj(IzvestajDatumiDTO izvestajDatumiDTO) throws DatatypeConfigurationException {
        rdfDatabase.kreirajIzvestaj(konvertujDatum(izvestajDatumiDTO.getPocetniDatum()), konvertujDatum(izvestajDatumiDTO.getKrajnjiDatum()));
    }

    private XMLGregorianCalendar konvertujDatum(Date date) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }

    public List<ResenjeZahteva> dobaviSve() throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaRepository.dobaviSve();
    }
}
