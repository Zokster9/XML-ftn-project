package com.example.z1project.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class ReportDatesDTO {

    @XmlElement
    private Date pocetniDatum;

    @XmlElement
    private Date krajnjiDatum;

    public ReportDatesDTO() {
    }

    public Date getPocetniDatum() {
        return pocetniDatum;
    }

    public Date getKrajnjiDatum() {
        return krajnjiDatum;
    }
}