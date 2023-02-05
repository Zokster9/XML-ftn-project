package com.example.z1project.repository;

import com.example.z1project.database.RDFDatabase;
import com.example.z1project.database.ResenjeZahtevaDatabase;
import com.example.z1project.database.ZigDatabase;
import com.example.z1project.model.zig.ResenjeZahteva;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.List;

public class ResenjeZahtevaRepository {

    ResenjeZahtevaDatabase resenjeZahtevaDatabase = new ResenjeZahtevaDatabase();
    ZigDatabase zigDatabase = new ZigDatabase();
    ZigRepository zigRepository = new ZigRepository();

    public ResenjeZahteva kreiraj(ResenjeZahteva resenjeZahteva) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigDatabase.getByBrojPrijave(resenjeZahteva.getReferenca());
        String resenjeZahtevaNaziv = resenjeZahteva.getSifra();
        if (resenjeZahteva.isZahtevJePrihvacen()) {
            zahtevZaPriznanjeZiga.getPodaciOPrijavi().setDatumPrihvatanja(resenjeZahteva.getDatumResenja());
        } else {
            resenjeZahteva.setSifra("");
        }
        zigRepository.save(zahtevZaPriznanjeZiga);
        return resenjeZahtevaDatabase.write("resenje-zahteva-zigovi",
                resenjeZahteva.getBrojResenjaZahteva() + ".xml", resenjeZahteva);
    }

    public List<ResenjeZahteva> dobaviSve() throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.dobaviSve();
    }

    public ResenjeZahteva dobaviPoBrojuZahteva(String brojPrijaveZiga) throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.dobaviPoBrojuZahteva(brojPrijaveZiga);
    }
}
