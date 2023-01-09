package a1.a1service.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ObrazacAutorskoDeloCreationDTO {

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

    public ObrazacAutorskoDeloCreationDTO() {
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
}
