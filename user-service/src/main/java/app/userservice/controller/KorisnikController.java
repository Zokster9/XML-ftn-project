package app.userservice.controller;

import app.userservice.dto.KorisnikDTO;
import app.userservice.model.Korisnik;
import app.userservice.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping(value = "/registracija", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<KorisnikDTO> registracija(@RequestBody KorisnikDTO korisnikDTO) {
        try {
            Korisnik korisnik = korisnikService.registracija(korisnikDTO);
            return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
