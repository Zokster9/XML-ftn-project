package project.xmlproject.database;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;
import project.xmlproject.Util.AuthenticationUtilities;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
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

    public List<ZahtevZaPriznanjePatenta> getAllLoggedPerson(String email) throws Exception {
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

            String xPathExp = "//Zahtev_za_priznanje_patenta[Podnosilac/Kontakt_podaci/E_posta='" + email + "']";
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


    public List<ZahtevZaPriznanjePatenta> getByText(String text) throws Exception {
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

            String xPathExp = "/*[contains(., '" + text + "')]";
            //String xPathExp = "/*[contains(., 'Negde kod zeleznicke')]";
            ResourceSet result = xPathQueryService.query(xPathExp);
            ResourceIterator i = result.getIterator();
            XMLResource res = null;
            zahteviZaPriznanjePatenta = new ArrayList<>();
            while (i.hasMoreResources()) {
                res = (XMLResource) i.nextResource();
                System.out.println(res.getContent());

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

    public ZahtevZaPriznanjePatenta read(String collectionName, String documentName) throws Exception {

        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        System.out.println("[INFO] " + WriteMarshal.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;

        collectionId = "/db/xml-project/" + collectionName;
        documentId = documentName;

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res = null;

        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = null;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            System.out.println(col.getResourceCount());

            System.out.println("[INFO] Retrieving the document: " + documentId);
            res = (XMLResource) col.getResource(documentId);
            //System.out.println(res.getContent().toString());

            if (res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {

                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");
                JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);

                Unmarshaller unmarshaller = context.createUnmarshaller();

                zahtevZaPriznanjePatenta = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(res.getContentAsDOM());

                System.out.println("[INFO] Showing the document as JAXB instance: ");
                System.out.println(zahtevZaPriznanjePatenta);

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
        return zahtevZaPriznanjePatenta;
    }

    public ZahtevZaPriznanjePatenta write(String collectionName, String documentName, ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) throws Exception {

        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        System.out.println("[INFO] " + WriteMarshal.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;

        System.out.println("[INFO] Using defaults.");

        collectionId = "/db/xml-project/" + collectionName;
        documentId = documentName;


        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId);

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);


        // encapsulation of the database driver functionality
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);

        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = getOrCreateCollection(collectionId, conn);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // marshal the contents to an output stream
            marshaller.marshal(zahtevZaPriznanjePatenta, os);

            // link the stream to the XML resource
            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");

        } finally {

            //don't forget to cleanup
            /*
            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
             */

            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return zahtevZaPriznanjePatenta;
    }

    private static Collection getOrCreateCollection(String collectionUri, AuthenticationUtilities.ConnectionProperties conn) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0, conn);
    }

    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset, AuthenticationUtilities.ConnectionProperties conn) throws XMLDBException {

        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);

        // create the collection if it does not exist
        if(col == null) {

            if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String pathSegments[] = collectionUri.split("/");

            if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset, conn);
        } else {
            return col;
        }
    }
}
