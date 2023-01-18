package project.xmlproject.repository;

import project.xmlproject.database.PatentDatabase;
import project.xmlproject.database.RDFDatabase;
import project.xmlproject.database.ResenjeZahtevaDatabase;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;

public class ResenjeZahtevaRepository {

    PatentDatabase patentDatabase = new PatentDatabase();
    ResenjeZahtevaDatabase resenjeZahtevaDatabase = new ResenjeZahtevaDatabase();
    RDFDatabase rdfDatabase = new RDFDatabase();
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
        rdfDatabase.createAndInsertRDF("src/main/resources/static/rdf/" + updatedZahtev.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".rdf", updatedZahtev);
        return resenjeZahtevaDatabase.write("resenja-zahteva-patenti", resenjeZahtevaNaziv + ".xml", resenjeZahteva);

    }

    public ResenjeZahteva findByReferenca(String patentNumber) throws Exception {
        return resenjeZahtevaDatabase.getByPatentNumber(patentNumber);
    }
}
