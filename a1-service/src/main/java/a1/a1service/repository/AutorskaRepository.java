package a1.a1service.repository;

import a1.a1service.database.ReadUnmarshal;
import a1.a1service.database.WriteMarshal;
import a1.a1service.model.ObrazacAutorskoDelo;

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