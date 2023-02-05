package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class NaznaceneBojeDTO {

    @XmlElement
    private List<String> boja;

    public NaznaceneBojeDTO() {
        boja = new ArrayList<>();
    }

    public NaznaceneBojeDTO(String boja) {

    }

    public NaznaceneBojeDTO(List<String> boja) {
        this.boja = boja;
    }

    public NaznaceneBojeDTO(ZahtevZaPriznanjeZiga.Zig.NaznaceneBoje naznaceneBoje) {
        this.boja = naznaceneBoje.getBoja();
    }

    public List<String> getBoja() {
        return boja;
    }

    public void setBoja(List<String> boja) {
        this.boja = boja;
    }
}
