package a1.a1service.service;

import a1.a1service.database.RDFDatabase;
import a1.a1service.dto.IzvestajDatumiDTO;
import a1.a1service.dto.KorisnikDTO;
import a1.a1service.dto.ResenjeZahtevaDTO;
import a1.a1service.marshal.MarshalResenjeZahteva;
import a1.a1service.model.ResenjeZahteva;
import a1.a1service.repository.ResenjeZahtevaRepository;
import a1.a1service.transform.AutorskaTransform;
import com.itextpdf.kernel.pdf.PdfDocument;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private EmailService emailService;

    MarshalResenjeZahteva marshalResenjeZahteva = new MarshalResenjeZahteva();

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    AutorskaTransform autorskaTransform = new AutorskaTransform();

    RDFDatabase rdfDatabase = new RDFDatabase();

    public ResenjeZahteva dodajResenjeZahteva(String token, ResenjeZahtevaDTO resenjeZahtevaDTO) throws Exception {
        KorisnikDTO korisnikDTO = korisnikService.dobaviKorisnika(token);
        ResenjeZahteva resenjeZahteva = marshalResenjeZahteva.marshalResenjeZahteva(resenjeZahtevaDTO, korisnikDTO);
        resenjeZahteva = resenjeZahtevaRepository.kreiraj(resenjeZahteva);
        kreirajHtmlPdf(resenjeZahteva);
        emailService.posaljiMejlZaZahtev(resenjeZahteva);
        return resenjeZahteva;
    }

    private void kreirajHtmlPdf(ResenjeZahteva resenjeZahteva) throws IOException {
        autorskaTransform.kreirajResenjeZahtevaHTML("src/main/resources/static/html/"
                + resenjeZahteva.getReferenca() +
                "_resenje.html", resenjeZahteva);
        autorskaTransform.kreirajPDF("src/main/resources/static/html/" + resenjeZahteva.getReferenca() + "_resenje.html",
                "src/main/resources/static/pdf/" + resenjeZahteva.getReferenca() + "_resenje.pdf" );
    }

    public ResenjeZahteva dobaviPoBrojuAutorskog(String token, String brojAutorskog) throws Exception {
        korisnikService.proveriKorisnika(token, true);
        ResenjeZahteva resenjeZahteva = resenjeZahtevaRepository.dobaviPoBrojuAutorskog(brojAutorskog);
        autorskaTransform.kreirajResenjeZahtevaHTML("src/main/resources/static/html/"
                + resenjeZahteva.getReferenca() +
                "_resenje.html", resenjeZahteva);
        return resenjeZahteva;
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

    public List<ResenjeZahteva> dobaviSve(String token) throws Exception {
        korisnikService.proveriKorisnika(token, true);
        return resenjeZahtevaRepository.dobaviSve();
    }

    public boolean proveriKorisnika(String token, boolean korisnikJeSluzbenik) throws Exception {
        return korisnikService.proveriKorisnika(token, korisnikJeSluzbenik);
    }
}
