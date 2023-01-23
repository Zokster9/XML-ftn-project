package a1.a1service.controller;

import a1.a1service.dto.ObrazacAutorskoDeloCreationDTO;
import a1.a1service.dto.ObrazacAutorskoDeloDTO;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.service.AutorskaService;
import a1.a1service.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "autorska")
public class AutorskaController {

    @Autowired
    private AutorskaService autorskaService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value = "/dodaj-autorska", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ObrazacAutorskoDeloDTO> kreirajZahtev(@RequestBody ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (autorskaService.proveriKorisnika(token, false)) {
                ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.kreirajZahtev(obrazacAutorskoDeloCreationDTO);
                return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-autorsko/{brojAutorskog}", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ObrazacAutorskoDeloDTO> dobaviObrazacZaAutorsko(@PathVariable("brojAutorskog") String brojAutorskog) {
        try {
            ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.dobaviAutorskoDelo(brojAutorskog);
            return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-html/{brojAutorskog}", produces = "application/xml", consumes = "application/xml")
    public ResponseEntity<ObrazacAutorskoDeloDTO> dobaviObrazacHTML(@PathVariable("brojAutorskog") String brojAutorskog, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.dobaviAutorskoDelo(brojAutorskog);
            autorskaService.kreirajHTML(token, obrazacAutorskoDelo);
            return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-pdf/{brojAutorskog}", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ObrazacAutorskoDeloDTO> dobaviObrazacPDF(@PathVariable("brojAutorskog") String brojAutorskog, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.dobaviAutorskoDelo(brojAutorskog);
            autorskaService.kreirajHTML(token, obrazacAutorskoDelo);
            autorskaService.kreirajPDF(token, obrazacAutorskoDelo);
            return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-sve", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<List<ObrazacAutorskoDeloDTO>> dobaviSve(HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            List<ObrazacAutorskoDelo> obrasci = autorskaService.dobaviSve(token);
            List<ObrazacAutorskoDeloDTO> obrazacAutorskoDeloDTOS = new ArrayList<>();
            for (ObrazacAutorskoDelo obrazac: obrasci) {
                obrazacAutorskoDeloDTOS.add(new ObrazacAutorskoDeloDTO(obrazac));
            }
            return new ResponseEntity<>(obrazacAutorskoDeloDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-rdf/{brojAutorskog}", produces = "application/xml")
    public ResponseEntity<String> dobaviRDF(@PathVariable(value = "brojAutorskog") String brojAutorskog, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (autorskaService.proveriKorisnika(token, true)) {
                String rdf = autorskaService.kreirajRdfJson(brojAutorskog);
                return new ResponseEntity<>(rdf, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-json/{brojAutorskog}", produces = "application/json")
    public ResponseEntity<String> dobaviJSON(@PathVariable("brojAutorskog") String brojAutorskog, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (autorskaService.proveriKorisnika(token, true)) {
                String rdf = autorskaService.kreirajRdfJson(brojAutorskog);
                return new ResponseEntity<>(rdf, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-tekst/{tekst}", produces = "application/xml")
    public ResponseEntity<List<ObrazacAutorskoDeloDTO>> dobaviPoTekstu(@PathVariable("tekst") String tekst, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            List<ObrazacAutorskoDelo> obrasci = autorskaService.dobaviPoTekstu(token, tekst);
            List<ObrazacAutorskoDeloDTO> obrazacAutorskoDeloDTOS = new ArrayList<>();
            for (ObrazacAutorskoDelo obrazac: obrasci) {
                obrazacAutorskoDeloDTOS.add(new ObrazacAutorskoDeloDTO(obrazac));
            }
            return new ResponseEntity<>(obrazacAutorskoDeloDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-metapodaci/{upit}", produces = "application/xml")
    public ResponseEntity<List<ObrazacAutorskoDeloDTO>> dobaviPoMetapodacima(@PathVariable("upit") String upit, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            List<ObrazacAutorskoDelo> obrasci = autorskaService.dobaviPoMetapodacima(token, upit);
            List<ObrazacAutorskoDeloDTO> obrazacAutorskoDeloDTOS = new ArrayList<>();
            for (ObrazacAutorskoDelo obrazac: obrasci) {
                obrazacAutorskoDeloDTOS.add(new ObrazacAutorskoDeloDTO(obrazac));
            }
            return new ResponseEntity<>(obrazacAutorskoDeloDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
