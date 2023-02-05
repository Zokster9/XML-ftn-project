package com.example.z1project.dto;

import com.example.z1project.model.zig.TFizickoLice;
import com.example.z1project.model.zig.TPravnoLice;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class PodnosiociPrijaveDTO {

    @XmlElement
    private List<FizickoLiceDTO> fizickiPodnosiociPrijave = new ArrayList<>();
    @XmlElement
    private List<PravnoLiceDTO> pravniPodnosiociPrijave = new ArrayList<>();

    public PodnosiociPrijaveDTO() {
    }

    public PodnosiociPrijaveDTO(List<FizickoLiceDTO> fizickiPodnosiociPrijave, List<PravnoLiceDTO> pravniPodnosiociPrijave) {
        this.fizickiPodnosiociPrijave = fizickiPodnosiociPrijave;
        this.pravniPodnosiociPrijave = pravniPodnosiociPrijave;
    }

    public PodnosiociPrijaveDTO(ZahtevZaPriznanjeZiga.PodnosiociPrijave fizickiPodnosiociPrijave) {
        this.fizickiPodnosiociPrijave = new ArrayList<>();
        this.pravniPodnosiociPrijave = new ArrayList<>();
        fizickiPodnosiociPrijave.getPodnosilacPrijave().forEach(podnosilacPrijave -> {
            if (podnosilacPrijave instanceof TFizickoLice) {
                FizickoLiceDTO fizickoLice = new FizickoLiceDTO();
                fizickoLice.setIme(((TFizickoLice) podnosilacPrijave).getIme());
                fizickoLice.setPrezime(((TFizickoLice) podnosilacPrijave).getPrezime());
                fizickoLice.setAdresa(new AdresaDTO(podnosilacPrijave.getAdresa()));
                fizickoLice.setKontaktPodaci(new KontaktPodaciDTO(podnosilacPrijave.getKontaktPodaci()));
                this.fizickiPodnosiociPrijave.add(fizickoLice);
            } else {
                PravnoLiceDTO pravnoLice = new PravnoLiceDTO();
                pravnoLice.setNaziv(((TPravnoLice) podnosilacPrijave).getNaziv());
                pravnoLice.setAdresa(new AdresaDTO(podnosilacPrijave.getAdresa()));
                pravnoLice.setKontaktPodaci(new KontaktPodaciDTO(podnosilacPrijave.getKontaktPodaci()));
                this.pravniPodnosiociPrijave.add(pravnoLice);
            }
        });
    }

    public List<FizickoLiceDTO> getFizickiPodnosiociPrijave() {
        return fizickiPodnosiociPrijave;
    }

    public void setFizickiPodnosiociPrijave(List<FizickoLiceDTO> fizickiPodnosiociPrijave) {
        this.fizickiPodnosiociPrijave = fizickiPodnosiociPrijave;
    }

    public List<PravnoLiceDTO> getPravniPodnosiociPrijave() {
        return pravniPodnosiociPrijave;
    }

    public void setPravniPodnosiociPrijave(List<PravnoLiceDTO> pravniPodnosiociPrijave) {
        this.pravniPodnosiociPrijave = pravniPodnosiociPrijave;
    }
}
