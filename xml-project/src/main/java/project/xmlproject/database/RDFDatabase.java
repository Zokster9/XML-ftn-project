package project.xmlproject.database;

import org.apache.jena.graph.Node;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import org.json.JSONObject;
import org.json.XML;
import project.xmlproject.Util.ConnectionUtilities;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RDFDatabase {

    public static final String XSL_TO_RDF_FILE = "/xslt/metadata.xsl";

    public static String insertData(String graphURI, String ntriples) {
        return String.format("INSERT DATA { GRAPH <%1$s> { %2$s } }", graphURI, ntriples);
    }

    public static String selectData(String graphURI, String sparqlCondition) {
        return String.format("SELECT * FROM <%1$s> WHERE { %2$s }", graphURI, sparqlCondition);
    }

    public void createAndInsertRDF(String rdfFile, ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            InputStream resourceAsStream = getClass().getResourceAsStream(XSL_TO_RDF_FILE);
            StreamSource xslt = new StreamSource(resourceAsStream);
            Transformer transformer = factory.newTransformer(xslt);

            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
            //MarshalPatent marshalPatent = new MarshalPatent();
            //ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = marshalPatent.marshalPatent(zahtevZaPriznanjePatentaCreationDto, "read");
            JAXBSource source = new JAXBSource(context, zahtevZaPriznanjePatenta);
            System.out.println("Source" + source);
            StreamResult result = new StreamResult(new FileOutputStream(rdfFile));

            transformer.transform(source, result);

            ConnectionUtilities.ConnectionProperties conn = ConnectionUtilities.loadProperties();

            // Creates a default model
            Model model = ModelFactory.createDefaultModel();
            String brojPrijave = zahtevZaPriznanjePatenta.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave();
            String RDF_FILE = "src/main/resources/static/rdf/" + brojPrijave + ".rdf";
            model.read(RDF_FILE);

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            model.write(out, "N-TRIPLES");

            System.out.println("[INFO] Rendering model as RDF/XML...");
            model.write(System.out, "RDF/XML");

            // Creating the first named graph and updating it with RDF data
            System.out.println("[INFO] Writing the triples to a named graph \"" + brojPrijave + "\".");
            String sparqlUpdate = insertData(conn.dataEndpoint + brojPrijave, new String(out.toByteArray()));
            System.out.println(sparqlUpdate);

            // UpdateRequest represents a unit of execution
            UpdateRequest update = UpdateFactory.create(sparqlUpdate);

            UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
            processor.execute();


        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateReport() throws IOException {

        ConnectionUtilities.ConnectionProperties conn = ConnectionUtilities.loadProperties();
        System.out.println(conn.dataEndpoint + "metadata2");
        String sparqlQuery = selectData(conn.dataEndpoint + "P1671903993206", "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the SPARQL endpoint, iterate over the result set...
        ResultSet results = query.execSelect();
        ResultSetFormatter.outputAsXML(System.out, results);
        String varName;
        RDFNode varValue;

        while(results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next() ;
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println(varName + ": " + varValue);
            }
            System.out.println();
        }

        query.close() ;

        System.out.println("[INFO] End.");
    }

    //Vrv drugacije
    public void createJSONFromRDF(ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta) throws IOException {

        String docNumber = zahtevZaPriznanjePatenta.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave();
        String line = "";
        String path = "src/main/resources/static/rdf/" + docNumber + ".rdf";

        StringBuilder xml = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            xml.append(line);
        }
        JSONObject jsonData = XML.toJSONObject(xml.toString());
        String jsonString = jsonData.toString();
        FileWriter file = new FileWriter("src/main/resources/static/json/" + docNumber + ".json");
        file.write(jsonString);
        file.close();
    }

    public static void main(String[] args) throws IOException {
        RDFDatabase rdfDatabase = new RDFDatabase();
        rdfDatabase.generateReport();
    }

}