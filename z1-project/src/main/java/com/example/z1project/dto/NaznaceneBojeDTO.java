package com.example.z1project.dto;

import java.util.List;

public class NaznaceneBojeDTO {

    private List<String> boja;

    public NaznaceneBojeDTO() {
    }

    public NaznaceneBojeDTO(List<String> boja) {
        this.boja = boja;
    }

    public List<String> getBoja() {
        return boja;
    }

    public void setBoja(List<String> boja) {
        this.boja = boja;
    }
}
