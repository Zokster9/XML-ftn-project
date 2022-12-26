package project.xmlproject.repository;

import project.xmlproject.database.PatentDatabase;
import project.xmlproject.database.RDFDatabase;
import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

import java.util.ArrayList;
import java.util.List;

public class PatentRepository {

    private PatentDatabase patentDatabase = new PatentDatabase();
    private RDFDatabase rdfDatabase = new RDFDatabase();

    public ZahtevZaPriznanjePatenta save(ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();

        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatentaSaved = writeMarshal.write("patenti",
                zahtevZaPriznanjePatenta.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".xml",
                zahtevZaPriznanjePatenta);
        rdfDatabase.createAndInsertRDF(
                "src/main/resources/static/rdf/" + zahtevZaPriznanjePatentaSaved.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave() + ".rdf",
                zahtevZaPriznanjePatentaSaved);
        rdfDatabase.createJSONFromRDF(zahtevZaPriznanjePatenta);
        return zahtevZaPriznanjePatentaSaved;
    }

    public ZahtevZaPriznanjePatenta getPatent() throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.read("patenti", "P1671441144098.xml");
    }

    public List<ZahtevZaPriznanjePatenta> getAllPatenti() throws Exception {
        return patentDatabase.getAll();
    }

    public List<ZahtevZaPriznanjePatenta> getPatentsByText(String text) throws Exception {
        return patentDatabase.getByText(text);
    }

    public List<ZahtevZaPriznanjePatenta> getPatentsByMetadata(String query) throws Exception {
        List<String> patentNumbers = rdfDatabase.findByMetadata(query);
        List<ZahtevZaPriznanjePatenta> zahtevi = new ArrayList<>();
        for (String patentNumber : patentNumbers) {
            ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentDatabase.read("patenti", patentNumber + ".xml");
            zahtevi.add(zahtevZaPriznanjePatenta);
        }
        return zahtevi;
    }
}
