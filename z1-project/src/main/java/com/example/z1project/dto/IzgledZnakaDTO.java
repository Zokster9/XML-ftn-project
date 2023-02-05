package com.example.z1project.dto;

import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class IzgledZnakaDTO {

    @XmlElement
    private String imageUrl;

    public IzgledZnakaDTO() {
    }

    public IzgledZnakaDTO(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public IzgledZnakaDTO(ZahtevZaPriznanjeZiga.Zig.IzgledZnaka izgledZnaka) {
        this.imageUrl = izgledZnaka.getImageUrl();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
