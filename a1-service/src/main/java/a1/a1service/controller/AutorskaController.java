package a1.a1service.controller;

import a1.a1service.dto.ObrazacAutorskoDeloCreationDTO;
import a1.a1service.dto.ObrazacAutorskoDeloDTO;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.service.AutorskaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "autorska")
public class AutorskaController {

    @Autowired
    private AutorskaService autorskaService;

    @PostMapping(value = "/dodaj-autorska", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ObrazacAutorskoDeloDTO> kreirajZahtev(@RequestBody ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) {
        try {
            ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.kreirajZahtev(obrazacAutorskoDeloCreationDTO);
            return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.CREATED);
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
    public ResponseEntity<ObrazacAutorskoDeloDTO> dobaviObrazacHTML(@PathVariable("brojAutorskog") String brojAutorskog) {
        try {
            ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.dobaviAutorskoDelo(brojAutorskog);
            autorskaService.kreirajHTML(obrazacAutorskoDelo);
            return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/dobavi-pdf/{brojAutorskog}", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ObrazacAutorskoDeloDTO> dobaviObrazacPDF(@PathVariable("brojAutorskog") String brojAutorskog) {
        try {
            ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.dobaviAutorskoDelo(brojAutorskog);
            autorskaService.kreirajHTML(obrazacAutorskoDelo);
            autorskaService.kreirajPDF(obrazacAutorskoDelo);
            return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
