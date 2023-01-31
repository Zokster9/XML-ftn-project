package com.example.z1project.dto;

import java.util.List;

public class PodnosiociPrijaveDTO {

    private List<LiceDTO> podnosilacPrijave;

    public PodnosiociPrijaveDTO() {
    }

    public PodnosiociPrijaveDTO(List<LiceDTO> podnosilacPrijave) {
        this.podnosilacPrijave = podnosilacPrijave;
    }

    public List<LiceDTO> getPodnosilacPrijave() {
        return podnosilacPrijave;
    }

    public void setPodnosilacPrijave(List<LiceDTO> podnosilacPrijave) {
        this.podnosilacPrijave = podnosilacPrijave;
    }
}
