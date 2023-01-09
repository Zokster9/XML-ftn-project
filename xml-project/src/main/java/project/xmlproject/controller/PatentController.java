package project.xmlproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
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

    @GetMapping(value="/create-patent-html/{brojPrijave}", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatentHTML(@PathVariable String brojPrijave) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.createPatentHtml(brojPrijave);
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    @GetMapping(value="/create-patent-pdf/{brojPrijave}", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatentPDF(@PathVariable String brojPrijave) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.createPatentPdf(brojPrijave);
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    @PostMapping(value="/create-patent-rdf", produces="application/xml")
    public ResponseEntity<String> getPatentRDF(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        String rdf = patentService.createPatentRdfJson(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(rdf, HttpStatus.OK);
    }

    @PostMapping(value="/create-patent-json", produces = "application/json")
    public ResponseEntity<String> getPatentJSON(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        String json = patentService.createPatentRdfJson(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping(value="/get-patents-by-text/{text}", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getPatentsByText(@PathVariable String text) throws Exception {
        List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta = patentService.getPatentsByText(text);
        List<ZahtevZaPriznanjePatentaCreationDto> zahteviZaPriznanjePatentaCreationDto = new ArrayList<>();
        for (ZahtevZaPriznanjePatenta z : zahteviZaPriznanjePatenta) {
            zahteviZaPriznanjePatentaCreationDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
        }
        return new ResponseEntity<>(zahteviZaPriznanjePatentaCreationDto, HttpStatus.OK);
    }

    @GetMapping(value="/get-patents-by-metadata/{query}", produces="application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getPatentsByMetadata(@PathVariable String query) throws Exception {
        List<ZahtevZaPriznanjePatenta> zahtevi = patentService.getPatentsByMetadata(query);
        List<ZahtevZaPriznanjePatentaCreationDto> zahteviDto = new ArrayList<>();
        for (ZahtevZaPriznanjePatenta z : zahtevi) {
            zahteviDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
        }
        return new ResponseEntity<>(zahteviDto, HttpStatus.OK);
    }

    @GetMapping(value="/get-referenced-patents/{number}", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getReferencedPatents(@PathVariable String number) throws Exception {
        List<ZahtevZaPriznanjePatenta> zahtevi = patentService.getReferencedPatents(number);
        List<ZahtevZaPriznanjePatentaCreationDto> zahteviDto = new ArrayList<>();
        for (ZahtevZaPriznanjePatenta z : zahtevi) {
            zahteviDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
        }
        return new ResponseEntity<>(zahteviDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get-patents-that-reference-to/{number}", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getPatentsThatReferenceTo(@PathVariable String number) throws Exception {
        List<ZahtevZaPriznanjePatenta> zahtevi = patentService.getPatentsByText(number);
        List<ZahtevZaPriznanjePatentaCreationDto> zahteviDto = new ArrayList<>();
        for (ZahtevZaPriznanjePatenta z : zahtevi) {
            if (!z.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave().equals(number)){
                zahteviDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
            }
        }
        return new ResponseEntity<>(zahteviDto, HttpStatus.OK);
    }

}
