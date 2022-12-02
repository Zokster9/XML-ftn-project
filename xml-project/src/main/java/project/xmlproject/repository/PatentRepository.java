package project.xmlproject.repository;

import project.xmlproject.database.WriteMarshal;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

public class PatentRepository {

    public void save(ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        writeMarshal.write("patenti", "p2.xml", zahtevZaPriznanjePatenta);
    }
}
