package project.xmlproject.repository;

import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.model.autorska.ObrazacAutorskoDelo;

public class AutorskaRepository {

    public ObrazacAutorskoDelo kreiraj(ObrazacAutorskoDelo obrazacAutorskoDelo) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        return writeMarshal.writeAutorska("autorska", obrazacAutorskoDelo.getBrojPrijave() + ".xml", obrazacAutorskoDelo);
    }

    public ObrazacAutorskoDelo dobaviAutorsko(String brojAutorskogDela) throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readAutorska("autorska", brojAutorskogDela + ".xml");
    }
}
