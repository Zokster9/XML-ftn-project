package project.xmlproject.database;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
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
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
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

            deleteFile(rdfFile);


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

    private ArrayList<String> initializeOperators() {
        ArrayList<String> operators = new ArrayList<>();
        operators.add("=");
        operators.add("<=");
        operators.add(">=");
        operators.add("!=");
        operators.add(">");
        operators.add("<");
        return operators;
    }

    private ArrayList<String> initializeInverseOperators() {
        ArrayList<String> operators = new ArrayList<>();
        operators.add("!=");
        operators.add(">");
        operators.add("<");
        operators.add("=");
        operators.add("<=");
        operators.add(">=");
        return operators;
    }

    private ArrayList<String> initializeLogicalOperators() {
        ArrayList<String> logicalOperators = new ArrayList<>();
        logicalOperators.add("I");
        logicalOperators.add("ILI");
        logicalOperators.add("NE");
        return logicalOperators;
    }


    public List<String> findByMetadata(String unformattedQuery) {
        ArrayList<String> operators = initializeOperators();
        ArrayList<String> inverseOperators = initializeInverseOperators();
        ArrayList<String> logicalOperators = initializeLogicalOperators();
        ArrayList<String> queryConnectors = new ArrayList<>();
        ArrayList<ArrayList<String>> patents = new ArrayList<>();
        boolean nextQueryIsNegative = false;
        String[] filterElements = unformattedQuery.split(" ");
        ArrayList<String> filterElementsPreprocessed = new ArrayList<>();
        int indexToBeSkipped = -1;

        for (int i = 0; i < filterElements.length; i++) {
            System.out.println(filterElements[i]);
            if (i == indexToBeSkipped) {
                continue;
            }
            if (!operators.contains(filterElements[i]) && !logicalOperators.contains(filterElements[i]) && i != filterElements.length - 1) {
                if (!operators.contains(filterElements[i + 1]) && !logicalOperators.contains(filterElements[i + 1])) {
                    String concatenate = filterElements[i] + ' ' + filterElements[i + 1];
                    filterElementsPreprocessed.add(concatenate);
                    indexToBeSkipped = i + 1;
                } else {
                    filterElementsPreprocessed.add(filterElements[i]);
                }
            } else {
                filterElementsPreprocessed.add(filterElements[i]);
            }
        }
        for (String filtere :
                filterElementsPreprocessed) {
            System.out.println(filtere);
        }
        String filter = "";
        for (int i = 0; i < filterElementsPreprocessed.size(); i++) {
            if (i != filterElementsPreprocessed.size() - 1 && operators.contains(filterElementsPreprocessed.get(i + 1))) {
                filter += " ?p = ex:" + filterElementsPreprocessed.get(i) + " ";
            } else if (logicalOperators.contains(filterElementsPreprocessed.get(i).toUpperCase())) {
                filter += "NEWQUERY";
                if (filterElementsPreprocessed.get(i).equalsIgnoreCase("I")) {
                    queryConnectors.add("INTERSECT");
                    nextQueryIsNegative = false;
                } else if (filterElementsPreprocessed.get(i).equalsIgnoreCase("ILI")) {
                    queryConnectors.add("UNION");
                    nextQueryIsNegative = false;
                } else {
                    queryConnectors.add("INTERSECT");
                    nextQueryIsNegative = true;
                }
            } else if (i > 0 && operators.contains(filterElementsPreprocessed.get(i - 1))) {
                if (!nextQueryIsNegative) {
                    filter += " ?o " + filterElementsPreprocessed.get(i - 1) + " '" + filterElementsPreprocessed.get(i) + "' ";
                } else {
                    String operator = inverseOperators.get(operators.indexOf(filterElementsPreprocessed.get(i - 1)));
                    filter += " ?o " + operator + " '" + filterElementsPreprocessed.get(i) + "' ";
                }
            } else if (operators.contains(filterElementsPreprocessed.get(i))) {
                filter += "&& ";
            } else {
                filter += filterElementsPreprocessed.get(i);
            }
        }

        String[] filters = filter.split("NEWQUERY");

        for (String currentQuery : filters) {
            String queryString = "PREFIX ex: <http://www.ftn.uns.ac.rs/patent/>\n" +
                    "SELECT DISTINCT ?g\n" +
                    "WHERE {\n" +
                    "  GRAPH ?g {\n" +
                    "    ?s ?p ?o .\n" +
                    "    FILTER ( " + currentQuery + " )\n" +
                    "  }\n" +
                    "}";
            System.out.println(queryString);
            Query query = QueryFactory.create(queryString);
            try (QueryExecution quexec = QueryExecutionFactory.sparqlService("http://localhost:9001/fuseki/PatentDataset/", query)) {
                ResultSet resultSet = quexec.execSelect();
                ArrayList<String> patentNumbersForThisQuery = new ArrayList<>();
                while (resultSet.hasNext()) {
                    QuerySolution solution = resultSet.next();
                    patentNumbersForThisQuery.add(solution.get("g").toString());
                }
                patents.add(patentNumbersForThisQuery);
            }
        }
        ArrayList<String> finalPatentNumbers = new ArrayList<>();
        for (int i = 0; i < patents.size(); i++) {
            if (queryConnectors.size() == 0) {
                finalPatentNumbers.addAll(patents.get(i));
                break;
            }
            if (i == patents.size() - 1) {
                break;
            }
            ArrayList<String> firstList;
            if (i == 0) {
                firstList = patents.get(i);
            } else {
                firstList = finalPatentNumbers;
            }
            if (queryConnectors.get(i).equals("INTERSECT")) {
                Set<String> result = firstList.stream()
                        .distinct()
                        .filter(patents.get(i + 1)::contains)
                        .collect(Collectors.toSet());
                finalPatentNumbers.clear();
                finalPatentNumbers.addAll(result);
            } else if (queryConnectors.get(i).equals("UNION")) {
                Set<String> result = new HashSet<>();
                result.addAll(firstList);
                result.addAll(patents.get(i + 1));
                finalPatentNumbers.clear();
                finalPatentNumbers.addAll(result);
            }
        }
        ArrayList<String> clearedPatentNumbers = new ArrayList<>();
        for (String patentNumber : finalPatentNumbers) {
            clearedPatentNumbers.add(patentNumber.split("/")[patentNumber.split("/").length - 1]);
        }
        return clearedPatentNumbers;
    }

    public String findRdfByPatentNumberAndGenerateFile(String patentNumber) {

        String queryString1 = "PREFIX ex:<http://localhost:9001/fuseki/PatentDataset/data/>\n" +
                "SELECT ?s ?p ?o\n" +
                "FROM ex:" + patentNumber + "\n" +
                "WHERE {\n" +
                "  ?s ?p ?o .\n" +
                "}";
        Query query = QueryFactory.create(queryString1);
        try (QueryExecution quexec = QueryExecutionFactory.sparqlService("http://localhost:9001/fuseki/PatentDataset/", query)) {
            ResultSet resultSet = quexec.execSelect();
                //FileOutputStream out = new FileOutputStream("src/main/resources/static/rdf/" + patentNumber + ".rdf");
                //ResultSetFormatter.outputAsXML(out, resultSet);
                //out.close();
            return ResultSetFormatter.asXMLString(resultSet);
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

    public void deleteFile(String filePath) {
        //"src/main/resources/static/rdf/P1671907119478.rdf"
        Path path = Paths.get(filePath);
        try {
            // Delete file or directory
            Files.delete(path);
            System.out.println("File or directory deleted successfully");
        } catch (NoSuchFileException ex) {
            System.out.printf("No such file or directory: %s\n", path);
        } catch (DirectoryNotEmptyException ex) {
            System.out.printf("Directory %s is not empty\n", path);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        RDFDatabase rdfDatabase = new RDFDatabase();
        //rdfDatabase.generateReport("23.12.2022.", "25.12.2022.");
        //rdfDatabase.findByMetadata("Engleski_naziv_pronalaska = JSONPrimer ILI Naziv_podnosioca = Marko Markovic");
        //rdfDatabase.findByMetadata("Priznati_datum_prijave = 2022-12-24 NE Naziv_podnosioca = Nesto");
        String json = rdfDatabase.findRdfByPatentNumberAndGenerateFile("P1671907119478");
        System.out.println(json);
    }
}
