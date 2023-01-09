package a1.a1service.dto;

import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.model.TFizickoLice;
import a1.a1service.model.TPravnoLice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
public class ObrazacAutorskoDeloDTO {

    @XmlElement
    private FizickoLiceDTO fizickoLiceDTO;

    @XmlElement
    private PravnoLiceDTO pravnoLiceDTO;

    @XmlElement
    private PunomocnikDTO punomocnikDTO;

    @XmlElement
    private PodaciOAutorskomDeluDTO podaciOAutorskomDeluDTO;

    @XmlElement
    private PriloziUzPrijavuDTO priloziUzPrijavuDTO;

    @XmlElement
    private String brojPrijave;

    @XmlElement
    private XMLGregorianCalendar datumPrijave;

    public ObrazacAutorskoDeloDTO() {
    }

    public ObrazacAutorskoDeloDTO(ObrazacAutorskoDelo obrazacAutorskoDelo) {
        if (obrazacAutorskoDelo.getPodnosilac() instanceof TFizickoLice) this.fizickoLiceDTO = new FizickoLiceDTO((TFizickoLice) obrazacAutorskoDelo.getPodnosilac());
        else this.pravnoLiceDTO = new PravnoLiceDTO((TPravnoLice) obrazacAutorskoDelo.getPodnosilac());
        if (obrazacAutorskoDelo.getPunomocnik() != null) this.punomocnikDTO = new PunomocnikDTO(obrazacAutorskoDelo.getPunomocnik());
        this.podaciOAutorskomDeluDTO = new PodaciOAutorskomDeluDTO(obrazacAutorskoDelo.getPodaciOAutorskomDelu());
        this.brojPrijave = obrazacAutorskoDelo.getBrojPrijave();
        this.datumPrijave = obrazacAutorskoDelo.getDatumPrijave();
        this.priloziUzPrijavuDTO = new PriloziUzPrijavuDTO(obrazacAutorskoDelo.getPriloziUzPrijavu());
    }

    public FizickoLiceDTO getFizickoLiceDTO() {
        return fizickoLiceDTO;
    }

    public PravnoLiceDTO getPravnoLiceDTO() {
        return pravnoLiceDTO;
    }

    public PunomocnikDTO getPunomocnikDTO() {
        return punomocnikDTO;
    }

    public PodaciOAutorskomDeluDTO getPodaciOAutorskomDeluDTO() {
        return podaciOAutorskomDeluDTO;
    }

    public PriloziUzPrijavuDTO getPriloziUzPrijavuDTO() {
        return priloziUzPrijavuDTO;
    }

    public String getBrojPrijave() {
        return brojPrijave;
    }

    public XMLGregorianCalendar getDatumPrijave() {
        return datumPrijave;
    }
}
