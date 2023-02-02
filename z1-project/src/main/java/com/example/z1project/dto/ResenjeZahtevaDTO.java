package com.example.z1project.dto;

import com.example.z1project.model.zig.ResenjeZahteva;
import javax.xml.datatype.XMLGregorianCalendar;

public class ResenjeZahtevaDTO {

    protected String brojResenjaZahteva;
    protected XMLGregorianCalendar datumResenja;
    protected boolean zahtevJePrihvacen;
    protected String sifra;
    protected String obrazlozenje;
    protected String referenca;
    protected String imeSluzbenika;
    protected String prezimeSluzbenika;

    public ResenjeZahtevaDTO() {
    }

    public ResenjeZahtevaDTO(ResenjeZahteva resenjeZahteva) {
        this.brojResenjaZahteva = resenjeZahteva.getBrojResenjaZahteva();
        this.datumResenja = resenjeZahteva.getDatumResenja();
        this.zahtevJePrihvacen = resenjeZahteva.isZahtevJePrihvacen();
        this.sifra = resenjeZahteva.getSifra();
        this.obrazlozenje = resenjeZahteva.getObrazlozenje();
        this.referenca = resenjeZahteva.getReferenca();
        this.imeSluzbenika = resenjeZahteva.getImeSluzbenika();
        this.prezimeSluzbenika = resenjeZahteva.getPrezimeSluzbenika();
    }

    public String getBrojResenjaZahteva() {
        return brojResenjaZahteva;
    }

    public XMLGregorianCalendar getDatumResenja() {
        return datumResenja;
    }

    public boolean isZahtevJePrihvacen() {
        return zahtevJePrihvacen;
    }

    public String getSifra() {
        return sifra;
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public String getReferenca() {
        return referenca;
    }

    public String getImeSluzbenika() {
        return imeSluzbenika;
    }

    public String getPrezimeSluzbenika() {
        return prezimeSluzbenika;
    }
}
