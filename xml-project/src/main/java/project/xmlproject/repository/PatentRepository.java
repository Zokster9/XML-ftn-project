package project.xmlproject.repository;

import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

public class PatentRepository {

    public ZahtevZaPriznanjePatenta save(ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        return writeMarshal.write("patenti", "p3.xml", zahtevZaPriznanjePatenta);
    }

    public ZahtevZaPriznanjePatenta getPatent() throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.read("patenti", "p2.xml");
    }
}
