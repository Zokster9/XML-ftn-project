package project.xmlproject.transformXML;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import project.xmlproject.Util.AuthenticationUtilities;
import project.xmlproject.Util.ConnectionUtilities;
import project.xmlproject.XmlProjectApplication;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.marshal.MarshalPatent;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.repository.PatentRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class PatentTransformation {

    private static DocumentBuilderFactory documentFactory;

    private static TransformerFactory transformerFactory;

    public static final String XSL_FILE = "/xslt/patent.xsl";
    public static final String XSL_TO_RDF_FILE = "/xslt/metadata.xsl";

    private static final String METADATA_GRAPH_URI = "/metadata";

    //public static final String HTML_FILE = "src/main/resources/project/xmlproject/html/patent.html";

    public static final String OUTPUT_FILE = "src/main/java/project/xmlproject/pdf/patent.pdf";

    public static String dropAll() {
        return "DROP ALL";
    }

    public static String insertData(String graphURI, String ntriples) {
        return String.format("INSERT DATA { GRAPH <%1$s> { %2$s } }", graphURI, ntriples);
    }

    static {

        /* Inicijalizacija DOM fabrike */
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        /* Inicijalizacija Transformer fabrike */
        transformerFactory = TransformerFactory.newInstance();

    }
    //springhow.com/spring-boot-pdf-generation/
     public void generatePDF(String html, String pdf) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(pdf));
        pdfDocument.setDefaultPageSize(new PageSize(780, 2000));
        HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(html)), pdfDocument);
    }

    public void generateRDF(String rdfFile, ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            InputStream resourceAsStream = getClass().getResourceAsStream(XSL_TO_RDF_FILE);
            StreamSource xslt = new StreamSource(resourceAsStream);
            Transformer transformer = factory.newTransformer(xslt);

            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
            MarshalPatent marshalPatent = new MarshalPatent();
            ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = marshalPatent.marshalPatent(zahtevZaPriznanjePatentaCreationDto, "read");
            JAXBSource source = new JAXBSource(context, zahtevZaPriznanjePatenta);
            System.out.println("Source" + source);
            StreamResult result = new StreamResult(new FileOutputStream(rdfFile));

            transformer.transform(source, result);

            ConnectionUtilities.ConnectionProperties conn = ConnectionUtilities.loadProperties();

            // Creates a default model
            Model model = ModelFactory.createDefaultModel();
            //TODO Ne pronalazi putanju
            model.read(XSL_TO_RDF_FILE);

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            model.write(out, "N-TRIPLES");

            System.out.println("[INFO] Rendering model as RDF/XML...");
            model.write(System.out, "RDF/XML");

            // Delete all of the triples in all of the named graphs
            UpdateRequest request = UpdateFactory.create() ;
            request.add(dropAll());

            /*
             * Create UpdateProcessor, an instance of execution of an UpdateRequest.
             * UpdateProcessor sends update request to a remote SPARQL update service.
             */
            UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
            processor.execute();

            // Creating the first named graph and updating it with RDF data
            System.out.println("[INFO] Writing the triples to a named graph \"" + METADATA_GRAPH_URI + "\".");
            String sparqlUpdate = insertData(conn.dataEndpoint + METADATA_GRAPH_URI, new String(out.toByteArray()));
            System.out.println(sparqlUpdate);

            // UpdateRequest represents a unit of execution
            UpdateRequest update = UpdateFactory.create(sparqlUpdate);

            processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
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

    public void generateHTML(String htmlFile, ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        //actimem.com/java/xslt-with-jaxb
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            InputStream resourceAsStream = getClass().getResourceAsStream(XSL_FILE);
            System.out.println(resourceAsStream);
            StreamSource xslt = new StreamSource(resourceAsStream);
            Transformer transformer = factory.newTransformer(xslt);

            JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
            MarshalPatent marshalPatent = new MarshalPatent();
            ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = marshalPatent.marshalPatent(zahtevZaPriznanjePatentaCreationDto, "read");
            JAXBSource source = new JAXBSource(context, zahtevZaPriznanjePatenta);
            System.out.println("Source" + source);
            StreamResult result = new StreamResult(new FileOutputStream(htmlFile));

            transformer.transform(source, result);

            TransformerFactory factory1 = TransformerFactory.newInstance();
            InputStream resourceAsStream1 = getClass().getResourceAsStream(XSL_TO_RDF_FILE);
            StreamSource xslt1 = new StreamSource(resourceAsStream1);
            Transformer transformer1 = factory1.newTransformer(xslt1);
            StreamResult result1 = new StreamResult(new FileOutputStream("src/main/resources/rdf/neki.rdf"));

            transformer1.transform(source, result1);

            ConnectionUtilities.ConnectionProperties conn = ConnectionUtilities.loadProperties();

            // Creates a default model
            Model model = ModelFactory.createDefaultModel();
            model.read(XSL_TO_RDF_FILE);

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            model.write(out, "N-TRIPLES");

            System.out.println("[INFO] Rendering model as RDF/XML...");
            model.write(System.out, "RDF/XML");

            // Delete all of the triples in all of the named graphs
            UpdateRequest request = UpdateFactory.create() ;
            request.add(dropAll());

            /*
             * Create UpdateProcessor, an instance of execution of an UpdateRequest.
             * UpdateProcessor sends update request to a remote SPARQL update service.
             */
            UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
            processor.execute();

            // Creating the first named graph and updating it with RDF data
            System.out.println("[INFO] Writing the triples to a named graph \"" + METADATA_GRAPH_URI + "\".");
            String sparqlUpdate = insertData(conn.dataEndpoint + METADATA_GRAPH_URI, new String(out.toByteArray()));
            System.out.println(sparqlUpdate);

            // UpdateRequest represents a unit of execution
            UpdateRequest update = UpdateFactory.create(sparqlUpdate);

            processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
            processor.execute();

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
