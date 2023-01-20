package app.userservice.repository;

import app.userservice.database.ReadUnmarshal;
import app.userservice.database.WriteMarshal;
import app.userservice.model.Korisnik;

public class KorisnikRepository {

    public Korisnik kreiraj(Korisnik korisnik) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        return writeMarshal.writeKorisnik("korisnici", korisnik.getKorisnickoIme() + ".xml", korisnik);
    }

    public Korisnik dobaviKorisnika(String korisnickoIme) throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readKorisnik("korisnici", korisnickoIme + ".xml");
    }
}
