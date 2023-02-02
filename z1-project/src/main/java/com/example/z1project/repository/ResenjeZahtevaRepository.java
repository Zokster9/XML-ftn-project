package com.example.z1project.repository;

import com.example.z1project.database.ResenjeZahtevaDatabase;
import com.example.z1project.model.zig.ResenjeZahteva;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.List;

public class ResenjeZahtevaRepository {

    ResenjeZahtevaDatabase resenjeZahtevaDatabase = new ResenjeZahtevaDatabase();

    public ResenjeZahteva kreiraj(ResenjeZahteva resenjeZahteva) throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.write("resenje-zahteva-zigovi", resenjeZahteva.getBrojResenjaZahteva() + ".xml", resenjeZahteva);
    }

    public List<ResenjeZahteva> dobaviSve() throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.dobaviSve();
    }
}
