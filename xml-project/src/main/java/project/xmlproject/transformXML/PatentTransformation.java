package project.xmlproject.transformXML;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
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

    //public static final String HTML_FILE = "src/main/resources/project/xmlproject/html/patent.html";

    public static final String OUTPUT_FILE = "src/main/java/project/xmlproject/pdf/patent.pdf";

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
