package a1.a1service.controller;

import a1.a1service.dto.IzvestajDatumiDTO;
import a1.a1service.dto.ResenjeZahtevaDTO;
import a1.a1service.model.ResenjeZahteva;
import a1.a1service.service.ResenjeZahtevaService;
import a1.a1service.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "resenja-zahteva")
public class ResenjeZahtevaController {

    @Autowired
    private ResenjeZahtevaService resenjeZahtevaService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value="/dodaj-resenje-zahteva", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ResenjeZahtevaDTO> dodajResenjeZahteva(@RequestBody ResenjeZahtevaDTO resenjeZahtevaDTO, HttpServletRequest request) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (resenjeZahtevaService.proveriKorisnika(token, true)) {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaService.dodajResenjeZahteva(token, resenjeZahtevaDTO);
                return new ResponseEntity<>(new ResenjeZahtevaDTO(resenjeZahteva), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-po-broju-zahteva/{brojAutorskog}", produces = "application/xml")
    public ResponseEntity<ResenjeZahtevaDTO> dobaviPoBrojuZahteva(@PathVariable(value = "brojAutorskog") String brojAutorskog, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            ResenjeZahteva resenjeZahteva = resenjeZahtevaService.dobaviPoBrojuAutorskog(token, brojAutorskog);
            return new ResponseEntity<>(new ResenjeZahtevaDTO(resenjeZahteva), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/kreiraj-izvestaj", produces = "application/xml", consumes = "application/xml")
    public ResponseEntity<IzvestajDatumiDTO> kreirajIzvestaj(@RequestBody IzvestajDatumiDTO izvestajDatumiDTO, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (resenjeZahtevaService.proveriKorisnika(token, true)) {
                resenjeZahtevaService.kreirajIzvestaj(izvestajDatumiDTO);
                return new ResponseEntity<>(izvestajDatumiDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-sve", produces = "application/xml")
    public ResponseEntity<List<ResenjeZahtevaDTO>> dobaviSvaResenja(HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            List<ResenjeZahteva> resenjaZahteva = resenjeZahtevaService.dobaviSve(token);
            List<ResenjeZahtevaDTO> resenjeZahtevaDTOS = new ArrayList<>();
            for (ResenjeZahteva resenjeZahteva: resenjaZahteva) {
                resenjeZahtevaDTOS.add(new ResenjeZahtevaDTO(resenjeZahteva));
            }
            return new ResponseEntity<>(resenjeZahtevaDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
