package project.xmlproject.dto.creationDto;

import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResenjeZahtevaDto {

    private String datumResenja;

    private boolean zahtevJePrihvacen;

    private String sifra;

    private String obrazlozenje;

    private String referenca;

    public ResenjeZahtevaDto() {

    }

    public ResenjeZahtevaDto(ResenjeZahteva resenjeZahteva) {
        this.datumResenja = resenjeZahteva.getDatumResenja();
        this.zahtevJePrihvacen = resenjeZahteva.isZahtevJePrihvacen();
        this.sifra = resenjeZahteva.getSifra();
        this.obrazlozenje = resenjeZahteva.getObrazlozenje();
        this.referenca = resenjeZahteva.getReferenca();
    }

    public ResenjeZahtevaDto(String datumResenja, boolean zahtevJePrihvacen, String sifra, String obrazlozenje, String referenca) {
        this.datumResenja = datumResenja;
        this.zahtevJePrihvacen = zahtevJePrihvacen;
        this.sifra = sifra;
        this.obrazlozenje = obrazlozenje;
        this.referenca = referenca;
    }

    public String getDatumResenja() {
        return datumResenja;
    }

    public void setDatumResenja(String datumResenja) {
        this.datumResenja = datumResenja;
    }

    public boolean isZahtevJePrihvacen() {
        return zahtevJePrihvacen;
    }

    public void setZahtevJePrihvacen(boolean zahtevJePrihvacen) {
        this.zahtevJePrihvacen = zahtevJePrihvacen;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }

    public String getReferenca() {
        return referenca;
    }

    public void setReferenca(String referenca) {
        this.referenca = referenca;
    }
}
