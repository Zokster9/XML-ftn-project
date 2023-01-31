package com.example.z1project.dto;

import java.util.List;

public class KlaseRobeIUslugaDTO {

    List<Integer> klasa;

    public KlaseRobeIUslugaDTO() {
    }

    public KlaseRobeIUslugaDTO(List<Integer> klasa) {
        this.klasa = klasa;
    }

    public List<Integer> getKlasa() {
        return klasa;
    }

    public void setKlasa(List<Integer> klasa) {
        this.klasa = klasa;
    }
}
