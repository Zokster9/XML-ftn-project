package project.xmlproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.dto.autorska.ObrazacAutorskoDeloCreationDTO;
import project.xmlproject.dto.autorska.ObrazacAutorskoDeloDTO;
import project.xmlproject.model.autorska.ObrazacAutorskoDelo;
import project.xmlproject.service.AutorskaService;

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
}
