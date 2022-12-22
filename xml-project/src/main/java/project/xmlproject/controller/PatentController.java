package project.xmlproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.service.PatentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="patenti")
public class PatentController {

    @Autowired
    private PatentService patentService;

    @PostMapping(value="/add-patent", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> addPatent(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.addPatent(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    // Po necemu pretrazivati, poslati nesto sa fronta, nmp
    @GetMapping(value="/get-patent", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatent() throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta =  patentService.getPatent();
        //ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto = new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read");
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    @GetMapping(value="/get-all-patenti", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getAll() throws Exception {
        List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta = patentService.getAllPatenti();
        List<ZahtevZaPriznanjePatentaCreationDto> zahteviZaPriznanjePatentaCreationDto = new ArrayList<>();
        for (ZahtevZaPriznanjePatenta z : zahteviZaPriznanjePatenta) {
            zahteviZaPriznanjePatentaCreationDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
        }
        return new ResponseEntity<>(zahteviZaPriznanjePatentaCreationDto, HttpStatus.OK);
    }

    @PostMapping(value="/create-patent-html", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatentHTML(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        patentService.createPatentHtml(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(zahtevZaPriznanjePatentaCreationDto, HttpStatus.OK);
    }

    @PostMapping(value="/create-patent-pdf", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatentPDF(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        patentService.createPatentPdf(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(zahtevZaPriznanjePatentaCreationDto, HttpStatus.OK);
    }
}
