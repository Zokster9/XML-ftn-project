package com.example.z1project.database;

import com.example.z1project.Util.AuthenticationUtilities;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.List;

public class ZigDatabase {

    public ZahtevZaPriznanjeZiga getByBrojPrijave(String brojPrijave) throws Exception {
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
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "//Zahtev_za_priznanje_ziga[Podaci_o_prijavi/Broj_prijave_ziga='" + brojPrijave + "']";
            ResourceSet result = xPathQueryService.query(xPathExp);
            XMLResource res = (XMLResource) result.getIterator().nextResource();
            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            zahtevZaPriznanjeZiga = (ZahtevZaPriznanjeZiga) unmarshaller.unmarshal(res.getContentAsDOM());
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
        return zahtevZaPriznanjeZiga;
    }

}
