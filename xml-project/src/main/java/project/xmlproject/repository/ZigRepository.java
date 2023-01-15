package project.xmlproject.repository;

import project.xmlproject.database.RDFDatabase;
import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.model.zig.ZahtevZaPriznanjeZiga;

public class ZigRepository {

    private RDFDatabase rdfDatabase = new RDFDatabase();

    public ZahtevZaPriznanjeZiga save(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        zahtevZaPriznanjeZiga = writeMarshal.write("zigovi", "z1.xml", zahtevZaPriznanjeZiga);
        rdfDatabase.createAndInsertRDF("src/main/resources/static/rdf/" +
                        zahtevZaPriznanjeZiga.getPodaciOPrijavi().getBrojPrijaveZiga() + ".rdf",
                zahtevZaPriznanjeZiga);
        return zahtevZaPriznanjeZiga;
    }

    public ZahtevZaPriznanjeZiga getZig() throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readZig("zigovi", "z1.xml");
    }
}
