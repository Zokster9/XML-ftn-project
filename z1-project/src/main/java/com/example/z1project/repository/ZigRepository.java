package com.example.z1project.repository;

import com.example.z1project.database.RDFDatabase;
import com.example.z1project.database.ReadUnmarshal;
import com.example.z1project.database.WriteMarshal;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

public class ZigRepository {

    private RDFDatabase rdfDatabase = new RDFDatabase();

    public  ZahtevZaPriznanjeZiga save(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
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
