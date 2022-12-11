package project.xmlproject.repository;

import project.xmlproject.database.ReadUnmarshal;
import project.xmlproject.database.WriteMarshal;
import project.xmlproject.model.zig.ZahtevZaPriznanjeZiga;

public class ZigRepository {

    public ZahtevZaPriznanjeZiga save(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        return writeMarshal.write("zigovi", "z1.xml", zahtevZaPriznanjeZiga);
    }

    public ZahtevZaPriznanjeZiga getZig() throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readZig("zigovi", "z1.xml");
    }
}
