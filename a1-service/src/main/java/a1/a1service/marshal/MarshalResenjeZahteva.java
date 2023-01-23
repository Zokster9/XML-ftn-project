package a1.a1service.marshal;

import a1.a1service.dto.KorisnikDTO;
import a1.a1service.dto.ResenjeZahtevaDTO;
import a1.a1service.model.ResenjeZahteva;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MarshalResenjeZahteva {

    public ResenjeZahteva marshalResenjeZahteva(ResenjeZahtevaDTO resenjeZahtevaDTO, KorisnikDTO sluzbenik) throws DatatypeConfigurationException {
        ResenjeZahteva resenjeZahteva = new ResenjeZahteva();
        resenjeZahteva.setBrojResenjaZahteva(marshalGenerisanjeSifre("RZ-"));
        if (resenjeZahtevaDTO.isZahtevJePrihvacen()) {
            resenjeZahteva.setSifra(marshalGenerisanjeSifre("S-"));
        }else {
            resenjeZahteva.setObrazlozenje(resenjeZahtevaDTO.getObrazlozenje());
        }
        resenjeZahteva.setReferenca(resenjeZahtevaDTO.getReferenca());
        resenjeZahteva.setZahtevJePrihvacen(resenjeZahtevaDTO.isZahtevJePrihvacen());
        resenjeZahteva.setImeSluzbenika(sluzbenik.getIme());
        resenjeZahteva.setPrezimeSluzbenika(sluzbenik.getPrezime());
        resenjeZahteva.setDatumResenja(marshalGenerisanjeDatumaResenja());
        return resenjeZahteva;
    }

    private String marshalGenerisanjeSifre(String brojObrasca) {
        Date now = new Date();
        brojObrasca += String.valueOf(now.getTime());
        return brojObrasca;
    }

    private XMLGregorianCalendar marshalGenerisanjeDatumaResenja() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }
}
