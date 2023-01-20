package app.userservice.marshal;

import app.userservice.dto.KorisnikDTO;
import app.userservice.model.Korisnik;

public class MarshalKorisnik {

    public MarshalKorisnik() {
    }

    public Korisnik marshalKorisnik(KorisnikDTO korisnikDTO) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        korisnik.setIme(korisnikDTO.getIme());
        korisnik.setPrezime(korisnikDTO.getPrezime());
        korisnik.setSifra(korisnikDTO.getSifra());
        korisnik.setKorisnikJeSluzbenik(korisnikDTO.isKorisnikJeSluzbenik());
        return korisnik;
    }
}
