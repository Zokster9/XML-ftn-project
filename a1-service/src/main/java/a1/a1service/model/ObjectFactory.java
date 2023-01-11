package a1.a1service.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the rs.ac.uns.ftn.autorska package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.autorska
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.ObrazacAutorskoDelo }
     *
     */
    public ObrazacAutorskoDelo createObrazacAutorskoDelo() {
        return new ObrazacAutorskoDelo();
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.Punomocnik }
     *
     */
    public Punomocnik createPunomocnik() {
        return new Punomocnik();
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.PodaciOAutorskomDelu }
     *
     */
    public PodaciOAutorskomDelu createPodaciOAutorskomDelu() {
        return new PodaciOAutorskomDelu();
    }

    /**
     * Create an instance of {@link PriloziUzPrijavu }
     *
     */
    public PriloziUzPrijavu createPriloziUzPrijavu() {
        return new PriloziUzPrijavu();
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.TFizickoLice }
     *
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.TPravnoLice }
     *
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.Adresa }
     *
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link rs.ac.uns.ftn.autorska.PodaciOAutoru }
     *
     */
    public PodaciOAutoru createPodaciOAutoru() {
        return new PodaciOAutoru();
    }

}
