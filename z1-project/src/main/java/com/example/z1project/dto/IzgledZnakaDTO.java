package com.example.z1project.dto;

public class IzgledZnakaDTO {

    private String imageUrl;

    public IzgledZnakaDTO() {
    }

    public IzgledZnakaDTO(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
