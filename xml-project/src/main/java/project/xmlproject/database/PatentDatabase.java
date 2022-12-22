package project.xmlproject.database;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import project.xmlproject.Util.AuthenticationUtilities;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

public class PatentDatabase {

    public List<ZahtevZaPriznanjePatenta> getAll() throws Exception {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = null;
        collectionId = "/db/xml-project/patenti";

        System.out.println("\t- collection ID: " + collectionId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = null;
        List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta;
        int sum;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "//Zahtev_za_priznanje_patenta";
            ResourceSet result = xPathQueryService.query(xPathExp);
            ResourceIterator i = result.getIterator();
            XMLResource res = null;
            zahteviZaPriznanjePatenta = new ArrayList<>();
            while (i.hasMoreResources()) {
                res = (XMLResource) i.nextResource();
                //System.out.println(res.getContent());

                JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                zahtevZaPriznanjePatenta = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(res.getContentAsDOM());
                zahteviZaPriznanjePatenta.add(zahtevZaPriznanjePatenta);
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
        return zahteviZaPriznanjePatenta;
    }

    public ZahtevZaPriznanjePatenta getByBrojPrijave(String brojPrijave) throws Exception {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = null;
        collectionId = "/db/xml-project/patenti";

        System.out.println("\t- collection ID: " + collectionId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = null;
        List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "//Zahtev_za_priznanje_patenta[Podaci_o_prijavama/Nova_prijava/Broj_prijave='" + brojPrijave + "']";
            ResourceSet result = xPathQueryService.query(xPathExp);
            XMLResource res = (XMLResource) result.getIterator().nextResource();
            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            zahtevZaPriznanjePatenta = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(res.getContentAsDOM());
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
        return zahtevZaPriznanjePatenta;
    }
}
