package com.example.z1project.database;

import com.example.z1project.Util.ConnectionUtilities;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

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
import java.util.*;
import java.util.stream.Collectors;

public class RDFDatabase {

    public static final String XSL_TO_RDF_FILE = "/xslt/metadata.xsl";

    public static String insertData(String graphURI, String ntriples) {
        return String.format("INSERT DATA { GRAPH <%1$s> { %2$s } }", graphURI, ntriples);
    }

    public static String selectData(String graphURI, String sparqlCondition) {
        return String.format("SELECT * FROM <%1$s> WHERE { %2$s }", graphURI, sparqlCondition);
    }

    public void createAndInsertRDF(String rdfFile, ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            InputStream resourceAsStream = getClass().getResourceAsStream(XSL_TO_RDF_FILE);
            StreamSource xslt = new StreamSource(resourceAsStream);
            Transformer transformer = factory.newTransformer(xslt);

            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjeZiga.class);
            JAXBSource source = new JAXBSource(context, zahtevZaPriznanjeZiga);
            StreamResult result = new StreamResult(new FileOutputStream(rdfFile));

            transformer.transform(source, result);

            ConnectionUtilities.ConnectionProperties conn = ConnectionUtilities.loadProperties();

            // Creates a default model
            Model model = ModelFactory.createDefaultModel();
            String brojPrijave = zahtevZaPriznanjeZiga.getPodaciOPrijavi().getBrojPrijaveZiga();
            model.read(rdfFile);

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            model.write(out, "N-TRIPLES");

            System.out.println("[INFO] Rendering model as RDF/XML...");
            model.write(System.out, "RDF/XML");

            // Creating the first named graph and updating it with RDF data
            System.out.println("[INFO] Writing the triples to a named graph \"" + brojPrijave + "\".");
            String sparqlUpdate = insertData(conn.dataEndpoint + brojPrijave, new String(out.toByteArray()));

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

    public String pronadjiRdfPoBrojuZiga(String brojZiga) {
        String queryString1 = "PREFIX ex:<http://localhost:8080/fuseki/zigovi-dataset/data/>\n" +
                "SELECT ?s ?p ?o\n" +
                "FROM ex:" + brojZiga + "\n" +
                "WHERE {\n" +
                "  ?s ?p ?o .\n" +
                "}";
        Query query = QueryFactory.create(queryString1);
        try (QueryExecution quexec = QueryExecutionFactory.sparqlService("http://localhost:8080/fuseki/zigovi-dataset/", query)) {
            ResultSet resultSet = quexec.execSelect();
            //FileOutputStream out = new FileOutputStream("src/main/resources/static/rdf/" + patentNumber + ".rdf");
            //ResultSetFormatter.outputAsXML(out, resultSet);
            //out.close();
            return ResultSetFormatter.asXMLString(resultSet);
        }
    }

    public List<String> pronadjiPoMetapodacima(String unformattedQuery) {
        Map<String, Object> procesiranje = procesirajFiltere(unformattedQuery);

        String filter = (String) procesiranje.get("filter");
        String[] filters = filter.split("NEWQUERY");
        ArrayList<String> queryConnectors = (ArrayList<String>) procesiranje.get("queryConnectors");

        ArrayList<ArrayList<String>> zigovi = izvrsiUpite(filters);
        return obradaRezultataUpita(zigovi, queryConnectors);
    }

    private Map<String, Object> procesirajFiltere(String unformattedQuery) {
        ArrayList<String> filterElementsPreprocessed = prvaObradaFiltera(unformattedQuery);
        return drugaObradaFiltera(filterElementsPreprocessed);
    }
    private ArrayList<String> prvaObradaFiltera(String unformattedQuery) {
        ArrayList<String> operators = inicijalizacijaOperatora();
        ArrayList<String> logicalOperators = inicijalizacijaLogickihOperatora();
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
        return filterElementsPreprocessed;
    }

    private ArrayList<String> inicijalizacijaOperatora() {
        ArrayList<String> operatori = new ArrayList<>();
        operatori.add("=");
        operatori.add("!=");
        return operatori;
    }

    private ArrayList<String> inicijalizacijaLogickihOperatora() {
        ArrayList<String> logicalOperators = new ArrayList<>();
        logicalOperators.add("I");
        logicalOperators.add("ILI");
        logicalOperators.add("NE");
        return logicalOperators;
    }

    private Map<String, Object> drugaObradaFiltera(ArrayList<String> filterElementsPreprocessed) {
        ArrayList<String> operators = inicijalizacijaOperatora();
        ArrayList<String> inverseOperators = inicijalizacijaInverznihOperatora();
        ArrayList<String> logicalOperators = inicijalizacijaLogickihOperatora();
        ArrayList<String> queryConnectors = new ArrayList<>();
        boolean nextQueryIsNegative = false;
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
        Map<String, Object> retVal = new HashMap<>();
        retVal.put("filter", filter);
        retVal.put("queryConnectors", queryConnectors);
        return retVal;
    }

    private ArrayList<String> inicijalizacijaInverznihOperatora() {
        ArrayList<String> operators = new ArrayList<>();
        operators.add("!=");
        operators.add("=");
        return operators;
    }

    private ArrayList<ArrayList<String>> izvrsiUpite(String[] filters) {
        ArrayList<ArrayList<String>> zigovi = new ArrayList<>();
        for (String currentQuery : filters) {
            String queryString = "PREFIX ex: <http://www.ftn.uns.ac.rs/zig/>\n" +
                    "SELECT DISTINCT ?g\n" +
                    "WHERE {\n" +
                    "  GRAPH ?g {\n" +
                    "    ?s ?p ?o .\n" +
                    "    FILTER ( " + currentQuery + " )\n" +
                    "  }\n" +
                    "}";
            System.out.println(queryString);
            Query query = QueryFactory.create(queryString);
            try (QueryExecution quexec = QueryExecutionFactory.sparqlService("http://localhost:8080/fuseki/zigovi-dataset/", query)) {
                ResultSet resultSet = quexec.execSelect();
                ArrayList<String> zigNumbersForThisQuery = new ArrayList<>();
                while (resultSet.hasNext()) {
                    QuerySolution solution = resultSet.next();
                    zigNumbersForThisQuery.add(solution.get("g").toString());
                }
                zigovi.add(zigNumbersForThisQuery);
            }
        }
        return zigovi;
    }

    private ArrayList<String> obradaRezultataUpita(ArrayList<ArrayList<String>> zigovi, ArrayList<String> queryConnectors) {
        ArrayList<String> finalBrojZigovi = new ArrayList<>();
        for (int i = 0; i < zigovi.size(); i++) {
            if (queryConnectors.size() == 0) {
                finalBrojZigovi.addAll(zigovi.get(i));
                break;
            }
            if (i == zigovi.size() - 1) {
                break;
            }
            ArrayList<String> firstList;
            if (i == 0) {
                firstList = zigovi.get(i);
            } else {
                firstList = finalBrojZigovi;
            }
            if (queryConnectors.get(i).equals("INTERSECT")) {
                Set<String> result = firstList.stream()
                        .distinct()
                        .filter(zigovi.get(i + 1)::contains)
                        .collect(Collectors.toSet());
                finalBrojZigovi.clear();
                finalBrojZigovi.addAll(result);
            } else if (queryConnectors.get(i).equals("UNION")) {
                Set<String> result = new HashSet<>();
                result.addAll(firstList);
                result.addAll(zigovi.get(i + 1));
                finalBrojZigovi.clear();
                finalBrojZigovi.addAll(result);
            }
        }
        ArrayList<String> clearedBrojZigovi = new ArrayList<>();
        for (String brojZig : finalBrojZigovi) {
            clearedBrojZigovi.add(brojZig.split("/")[brojZig.split("/").length - 1]);
        }
        return clearedBrojZigovi;
    }

}