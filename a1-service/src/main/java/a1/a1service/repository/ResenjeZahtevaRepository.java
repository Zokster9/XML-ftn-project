package a1.a1service.repository;

import a1.a1service.database.ResenjeZahtevaDatabase;
import a1.a1service.model.ResenjeZahteva;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.List;

public class ResenjeZahtevaRepository {

    ResenjeZahtevaDatabase resenjeZahtevaDatabase = new ResenjeZahtevaDatabase();

    public ResenjeZahteva kreiraj(ResenjeZahteva resenjeZahteva) throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.write("resenje-zahteva-autorska", resenjeZahteva.getBrojResenjaZahteva() + ".xml", resenjeZahteva);
    }

    public ResenjeZahteva dobaviPoBrojuAutorskog(String brojAutorskog) throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.dobaviPoBrojuAutorskog(brojAutorskog);
    }

    public List<ResenjeZahteva> dobaviSve() throws XMLDBException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return resenjeZahtevaDatabase.dobaviSve();
    }
}
