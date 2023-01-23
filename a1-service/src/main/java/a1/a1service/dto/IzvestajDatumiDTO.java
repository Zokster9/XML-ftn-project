package a1.a1service.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class IzvestajDatumiDTO {

    @XmlElement
    private Date pocetniDatum;

    @XmlElement
    private Date krajnjiDatum;

    public IzvestajDatumiDTO() {
    }

    public Date getPocetniDatum() {
        return pocetniDatum;
    }

    public Date getKrajnjiDatum() {
        return krajnjiDatum;
    }
}
