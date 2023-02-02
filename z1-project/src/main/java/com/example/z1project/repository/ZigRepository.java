package com.example.z1project.repository;

import com.example.z1project.Util.AuthenticationUtilities;
import com.example.z1project.database.RDFDatabase;
import com.example.z1project.database.ReadUnmarshal;
import com.example.z1project.database.WriteMarshal;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;
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

public class ZigRepository {

    private RDFDatabase rdfDatabase = new RDFDatabase();

    public ZahtevZaPriznanjeZiga save(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        String documentName = zahtevZaPriznanjeZiga.getPodaciOPrijavi().getBrojPrijaveZiga() + ".xml";
        zahtevZaPriznanjeZiga = writeMarshal.write("zigovi", documentName, zahtevZaPriznanjeZiga);
        rdfDatabase.createAndInsertRDF("src/main/resources/static/rdf/" +
                        zahtevZaPriznanjeZiga.getPodaciOPrijavi().getBrojPrijaveZiga() + ".rdf",
                zahtevZaPriznanjeZiga);
        return zahtevZaPriznanjeZiga;
    }

    public ZahtevZaPriznanjeZiga getZig(String brojPrijaveZiga) throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readZig("zigovi", brojPrijaveZiga + ".xml");
    }

    public List<ZahtevZaPriznanjeZiga> getAll() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {

        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = null;
        collectionId = "/db/xml-project/zigovi";

        System.out.println("\t- collection ID: " + collectionId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = null;
        List<ZahtevZaPriznanjeZiga> zahteviZaPriznanjeZiga;
        int sum;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "//Zahtev_za_priznanje_ziga";
            ResourceSet result = xPathQueryService.query(xPathExp);
            ResourceIterator i = result.getIterator();
            XMLResource res = null;
            zahteviZaPriznanjeZiga = new ArrayList<>();
            while (i.hasMoreResources()) {
                res = (XMLResource) i.nextResource();
                //System.out.println(res.getContent());

                JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                zahtevZaPriznanjeZiga = (ZahtevZaPriznanjeZiga) unmarshaller.unmarshal(res.getContentAsDOM());
                zahteviZaPriznanjeZiga.add(zahtevZaPriznanjeZiga);
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
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
        return zahteviZaPriznanjeZiga;
    }
}
