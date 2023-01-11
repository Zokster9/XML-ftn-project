package a1.a1service.repository;

import a1.a1service.database.RDFDatabase;
import a1.a1service.database.ReadUnmarshal;
import a1.a1service.database.WriteMarshal;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.util.AuthenticationUtilities;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutorskaRepository {

    RDFDatabase rdfDatabase = new RDFDatabase();

    public ObrazacAutorskoDelo kreiraj(ObrazacAutorskoDelo obrazacAutorskoDelo) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        ObrazacAutorskoDelo obrazacAutorskoDeloSacuvan = writeMarshal.writeAutorska("autorska", obrazacAutorskoDelo.getBrojPrijave() + ".xml", obrazacAutorskoDelo);
        rdfDatabase.kreirajRDF(
                "src/main/resources/static/rdf/" + obrazacAutorskoDelo.getBrojPrijave() + ".rdf",
                obrazacAutorskoDeloSacuvan);
        return obrazacAutorskoDeloSacuvan;
    }

    public ObrazacAutorskoDelo dobaviAutorsko(String brojAutorskogDela) throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readAutorska("autorska", brojAutorskogDela + ".xml");
    }

    public List<ObrazacAutorskoDelo> dobaviSve() throws Exception {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = null;
        collectionId = "/db/xml-project/autorska";

        System.out.println("\t- collection ID: " + collectionId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ObrazacAutorskoDelo obrazacAutorskoDelo = null;
        List<ObrazacAutorskoDelo> obrasci;
        int sum;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "//obrazac_autorsko_delo";
            ResourceSet result = xPathQueryService.query(xPathExp);
            ResourceIterator i = result.getIterator();
            XMLResource res = null;
            obrasci = new ArrayList<>();
            while (i.hasMoreResources()) {
                res = (XMLResource) i.nextResource();
                //System.out.println(res.getContent());

                JAXBContext context = JAXBContext.newInstance(ObrazacAutorskoDelo.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                obrazacAutorskoDelo = (ObrazacAutorskoDelo) unmarshaller.unmarshal(res.getContentAsDOM());
                obrasci.add(obrazacAutorskoDelo);
            }
        } finally {
            //don't forget to clean up!

            /*
            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
            */

            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return obrasci;
    }

    public List<ObrazacAutorskoDelo> dobaviPoTekstu(String tekst) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = null;
        collectionId = "/db/xml-project/autorska";

        System.out.println("\t- collection ID: " + collectionId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ObrazacAutorskoDelo obrazacAutorskoDelo = null;
        List<ObrazacAutorskoDelo> obrasci = null;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "/*[contains(., '" + tekst + "')]";
            //String xPathExp = "/*[contains(., 'Negde kod zeleznicke')]";
            ResourceSet result = xPathQueryService.query(xPathExp);
            ResourceIterator i = result.getIterator();
            XMLResource res = null;
            obrasci = new ArrayList<>();
            while (i.hasMoreResources()) {
                res = (XMLResource) i.nextResource();
                System.out.println(res.getContent());

                JAXBContext context = JAXBContext.newInstance(ObrazacAutorskoDelo.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                obrazacAutorskoDelo = (ObrazacAutorskoDelo) unmarshaller.unmarshal(res.getContentAsDOM());
                obrasci.add(obrazacAutorskoDelo);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            //don't forget to clean up!

            /*
            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
            */

            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return obrasci;
    }

    public List<ObrazacAutorskoDelo> dobaviPoMetapodacima(String upit) throws Exception {
        List<String> brojeviObrazaca = rdfDatabase.pronadjiPoMetapodacima(upit);
        List<ObrazacAutorskoDelo> obrasci = new ArrayList<>();
        for (String brojObrasca : brojeviObrazaca) {
            ObrazacAutorskoDelo obrazacAutorskoDelo = dobaviAutorsko(brojObrasca);
            obrasci.add(obrazacAutorskoDelo);
        }
        return obrasci;
    }
}