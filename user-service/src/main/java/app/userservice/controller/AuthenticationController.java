package app.userservice.controller;

import app.userservice.dto.KorisnikDTO;
import app.userservice.dto.LoginDTO;
import app.userservice.dto.TokenDTO;
import app.userservice.model.Korisnik;
import app.userservice.service.KorisnikService;
import app.userservice.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthenticationController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value = "/login", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
            Korisnik korisnik = korisnikService.dobaviKorisnika(loginDTO.getKorisnickoIme());
            if (korisnik == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            if (korisnik.getSifra().equals(loginDTO.getLozinka())) {
                String token = tokenUtils.generateToken(korisnik.getKorisnickoIme(), korisnik.isKorisnikJeSluzbenik());
                return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
            }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{token}", produces = "application/xml")
    public ResponseEntity<KorisnikDTO> dobaviKorisnikaPomocuTokena(@PathVariable("token") String token) {
        try {
            String korisnickoIme = tokenUtils.getUsernameFromToken(token);
            Korisnik korisnik = korisnikService.dobaviKorisnika(korisnickoIme);
            return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
