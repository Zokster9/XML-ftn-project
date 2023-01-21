package project.xmlproject.repository;

import project.xmlproject.database.PatentDatabase;
import project.xmlproject.database.RDFDatabase;
import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.model.patent.PriznanjePravaPrvenstva;
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
        //rdfDatabase.createJSONFromRDF(zahtevZaPriznanjePatenta);
        return zahtevZaPriznanjePatentaSaved;
    }

    public ZahtevZaPriznanjePatenta getPatent() throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.read("patenti", "P1671441144098.xml");
    }

    public List<ZahtevZaPriznanjePatenta> getAllPatenti() throws Exception {
        return patentDatabase.getAll();
    }

    public List<ZahtevZaPriznanjePatenta> getAllPatentiByUlogovani(String email) throws Exception {
        return patentDatabase.getAllLoggedPerson(email);
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

    public List<ZahtevZaPriznanjePatenta> getReferencedPatents(String patentNumber) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentDatabase.getByBrojPrijave(patentNumber);
        List<ZahtevZaPriznanjePatenta> referenciraniZahtevi = new ArrayList<>();
        ZahtevZaPriznanjePatenta prvobitnaPrijava;
        try{
            prvobitnaPrijava = patentDatabase.getByBrojPrijave(zahtevZaPriznanjePatenta.getPodaciOPrijavama().getDodatnaPrijava().getBrojPrvobitnePrijave());
            referenciraniZahtevi.add(prvobitnaPrijava);
        } catch (NullPointerException e) {
            System.out.println("Non existing patent");
        }

        for (PriznanjePravaPrvenstva priznanjePravaPrvenstva :
                zahtevZaPriznanjePatenta.getPodaciOPrijavama().getPriznanjaPravaPrvenstva().getPriznanjePravaPrvenstva()) {
            try {
                ZahtevZaPriznanjePatenta zahtev = patentDatabase.getByBrojPrijave(priznanjePravaPrvenstva.getBrojRanijePrijave());
                referenciraniZahtevi.add(zahtev);
            } catch (NullPointerException e) {
                System.out.println("Non existing patent");
            }

        }
        for (ZahtevZaPriznanjePatenta zahtev : referenciraniZahtevi) {
            System.out.println(zahtev.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave());
        }
        return referenciraniZahtevi;
    }

    public static void main(String[] args) throws Exception {
        PatentRepository patentRepository = new PatentRepository();
        patentRepository.getReferencedPatents("P1671903952390");
    }
}
