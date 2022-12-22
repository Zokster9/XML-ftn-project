package project.xmlproject.repository;

import project.xmlproject.database.PatentDatabase;
import project.xmlproject.database.ResenjeZahtevaDatabase;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;

public class ResenjeZahtevaRepository {

    PatentDatabase patentDatabase = new PatentDatabase();
    ResenjeZahtevaDatabase resenjeZahtevaDatabase = new ResenjeZahtevaDatabase();
    public ResenjeZahteva save(ResenjeZahteva resenjeZahteva) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentDatabase.read("patenti", resenjeZahteva.getReferenca() + ".xml");
        String priznatiDatumPrijave;
        String resenjeZahtevaNaziv = resenjeZahteva.getSifra();
        if (resenjeZahteva.isZahtevJePrihvacen()) {
            priznatiDatumPrijave = resenjeZahteva.getDatumResenja();
        }
        else {
            priznatiDatumPrijave = "neprihvaceno";
            resenjeZahteva.setSifra("");
        }
        zahtevZaPriznanjePatenta.getPodaciOPrijavama().getNovaPrijava().setPriznatiDatumPrijave(priznatiDatumPrijave);
        ZahtevZaPriznanjePatenta updatedZahtev = patentDatabase.write("patenti", resenjeZahteva.getReferenca() + ".xml", zahtevZaPriznanjePatenta);
        return resenjeZahtevaDatabase.write("resenja-zahteva-patenti", resenjeZahtevaNaziv + ".xml", resenjeZahteva);

    }
}
