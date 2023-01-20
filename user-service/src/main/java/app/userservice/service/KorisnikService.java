package app.userservice.service;

import app.userservice.database.WriteMarshal;
import app.userservice.dto.KorisnikDTO;
import app.userservice.marshal.MarshalKorisnik;
import app.userservice.model.Korisnik;
import app.userservice.repository.KorisnikRepository;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    MarshalKorisnik marshalKorisnik = new MarshalKorisnik();

    KorisnikRepository korisnikRepository = new KorisnikRepository();

    public Korisnik registracija(KorisnikDTO korisnikDTO) throws Exception {
        Korisnik korisnik = korisnikRepository.dobaviKorisnika(korisnikDTO.getKorisnickoIme());
        if (korisnik != null) throw new Exception("Korisnik sa zadatim korisnickim imenom vec postoji.");
        korisnik = marshalKorisnik.marshalKorisnik(korisnikDTO);
        return korisnikRepository.kreiraj(korisnik);
    }

    public Korisnik dobaviKorisnika(String korisnickoIme) throws Exception {
        return korisnikRepository.dobaviKorisnika(korisnickoIme);
    }
}
