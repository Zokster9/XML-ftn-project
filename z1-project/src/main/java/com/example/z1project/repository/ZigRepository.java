package com.example.z1project.repository;

import com.example.z1project.database.RDFDatabase;
import com.example.z1project.database.ReadUnmarshal;
import com.example.z1project.database.WriteMarshal;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

public class ZigRepository {

    private RDFDatabase rdfDatabase = new RDFDatabase();

    public ZahtevZaPriznanjeZiga save(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        String documentName = zahtevZaPriznanjeZiga.getPodaciOPrijavi().getBrojPrijaveZiga() + ".xml";
        zahtevZaPriznanjeZiga = writeMarshal.write("zigovi", documentName, zahtevZaPriznanjeZiga);
        rdfDatabase.createAndInsertRDF("src/main/resources/static/rdf/" +
                        zahtevZaPriznanjeZiga.getPodaciOPrijavi().getBrojPrijaveZiga() + ".rdf",
                zahtevZaPriznanjeZiga);
        return zahtevZaPriznanjeZiga;
    }

    public ZahtevZaPriznanjeZiga getZig(String brojPrijaveZiga) throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readZig("zigovi", brojPrijaveZiga + ".xml");
    }
}
