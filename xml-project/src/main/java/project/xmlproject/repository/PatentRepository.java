package project.xmlproject.repository;

import project.xmlproject.database.PatentDatabase;
import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

import java.util.List;

public class PatentRepository {

    private PatentDatabase patentDatabase = new PatentDatabase();

    public ZahtevZaPriznanjePatenta save(ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();

        return writeMarshal.write("patenti",
                zahtevZaPriznanjePatenta.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".xml",
                zahtevZaPriznanjePatenta);
    }

    public ZahtevZaPriznanjePatenta getPatent() throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.read("patenti", "P1671441144098.xml");
    }

    public List<ZahtevZaPriznanjePatenta> getAllPatenti() throws Exception {
        return patentDatabase.getAll();
    }
}
