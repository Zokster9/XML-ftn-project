package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class KlaseRobeIUslugaDTO {

    @XmlElement
    List<Integer> klasa;

    public KlaseRobeIUslugaDTO() {
    }

    public KlaseRobeIUslugaDTO(ZahtevZaPriznanjeZiga.KlaseRobeIUsluga klaseRobeIUsluga) {
        this.klasa = klaseRobeIUsluga.getKlasa();
    }

    public List<Integer> getKlasa() {
        return klasa;
    }

    public void setKlasa(List<Integer> klasa) {
        this.klasa = klasa;
    }
}
