package project.xmlproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.service.PatentService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value="patenti")
public class PatentController {

    @Autowired
    private PatentService patentService;

    @PostMapping(value="/add-patent", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> addPatent(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.addPatent(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta), HttpStatus.OK);
    }

    // Po necemu pretrazivati, poslati nesto sa fronta, nmp
    @GetMapping(value="/get-patent", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatent() throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.getPatent();
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta), HttpStatus.OK);
    }
}
