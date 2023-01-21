package project.xmlproject.marshal;

import project.xmlproject.dto.creationDto.KorisnikDTO;
import project.xmlproject.dto.creationDto.ResenjeZahtevaDto;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;

import java.sql.Timestamp;

public class MarshalResenjeZahteva {

    public MarshalResenjeZahteva() {

    }

    public ResenjeZahteva marshalResenjeZahteva(ResenjeZahtevaDto resenjeZahtevaDto, KorisnikDTO korisnikDTO, String option) {
        ResenjeZahteva resenjeZahteva = new ResenjeZahteva();

        if (option.equals("create")){
            long miliseconds = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String date = timestamp.toString().substring(0, 10);
            resenjeZahteva.setDatumResenja(date);
            resenjeZahteva.setSifra('S' + String.valueOf(miliseconds));
        }
        else {
            resenjeZahteva.setDatumResenja(resenjeZahtevaDto.getDatumResenja());
            resenjeZahteva.setSifra(resenjeZahteva.getSifra());
        }
        resenjeZahteva.setZahtevJePrihvacen(resenjeZahtevaDto.isZahtevJePrihvacen());
        resenjeZahteva.setObrazlozenje(resenjeZahtevaDto.getObrazlozenje());
        resenjeZahteva.setReferenca(resenjeZahtevaDto.getReferenca());
        resenjeZahteva.setNaziv(korisnikDTO.getIme() + ' ' + korisnikDTO.getPrezime());
        resenjeZahteva.setRefId(resenjeZahteva.getReferenca());
        return resenjeZahteva;
    }

}
