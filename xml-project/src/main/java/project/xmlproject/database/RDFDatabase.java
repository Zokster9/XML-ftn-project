package project.xmlproject.database;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.jena.graph.Node;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
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
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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

    public void generateReport(String startDateString, String endDateString) throws ParseException {

        int zahtevi = 0;
        int prihvaceniZahtevi = 0;
        int odbijeniZahtevi = 0;

        Date startDate = new SimpleDateFormat("dd.MM.yyyy.").parse(startDateString);
        Date endDate = new SimpleDateFormat("dd.MM.yyyy.").parse(endDateString);

        String queryString = "select ?s ?p ?o {graph ?g {?s ?p ?o}}";
        Query query = QueryFactory.create(queryString);

        try (QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:9001/fuseki/PatentDataset/", query)) {
            ResultSet resultSet = qexec.execSelect();

            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.next();
                String s = solution.get("s").toString();
                String p = solution.get("p").toString();
                String o = solution.get("o").toString();
                if (p.contains("Datum_prijave")) {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(o);
                    if (startDate.compareTo(date) <= 0 && endDate.compareTo(date) >= 0) {
                        zahtevi++;
                    }
                }
            }
            ResenjeZahtevaDatabase resenjeZahtevaDatabase = new ResenjeZahtevaDatabase();
            List<ResenjeZahteva> resenjaZahteva = resenjeZahtevaDatabase.getAll();
            for (ResenjeZahteva resenjeZahteva : resenjaZahteva) {
                Date resenjeZahtevaDate = new SimpleDateFormat("yyyy-MM-dd").parse(resenjeZahteva.getDatumResenja());
                if (startDate.compareTo(resenjeZahtevaDate) <= 0 && endDate.compareTo(resenjeZahtevaDate) >= 0) {
                    if (resenjeZahteva.isZahtevJePrihvacen()) {
                        prihvaceniZahtevi++;
                    } else {
                        odbijeniZahtevi++;
                    }
                }
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/static/pdf/izvestaj.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 20, BaseColor.BLACK);
            Chunk chunk = new Chunk("IZVESTAJ U PERIODU OD " + startDateString + " DO " + endDateString, font);
            document.add(chunk);
            document.add(new Paragraph("\n\n"));

            PdfPTable table = new PdfPTable(3);
            addTableHeader(table);
            addRows(table, zahtevi, prihvaceniZahtevi, odbijeniZahtevi);
            document.add(table);
            document.close();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addRows(PdfPTable table, int zahtevi, int prihvaceniZahtevi, int odbijeniZahtevi) {
        table.addCell(String.valueOf(zahtevi));
        table.addCell(String.valueOf(prihvaceniZahtevi));
        table.addCell(String.valueOf(odbijeniZahtevi));
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Broj podnetih zahteva", "Broj prihvacenih zahteva", "Broj odbijenih zahteva")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
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

    public static void main(String[] args) throws IOException, ParseException {
        RDFDatabase rdfDatabase = new RDFDatabase();
        rdfDatabase.generateReport("23.12.2022.", "25.12.2022.");
    }

}
