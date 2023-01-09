package project.xmlproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.dto.creationDto.ReportDatesDto;
import project.xmlproject.dto.creationDto.ResenjeZahtevaDto;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
import project.xmlproject.service.ResenjeZahtevaService;

import java.text.ParseException;

@RestController
@RequestMapping(value="resenja-zahteva")
public class ResenjeZahtevaController {

    @Autowired
    private ResenjeZahtevaService resenjeZahtevaService;

    @PostMapping(value="/add-resenje-zahteva", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ResenjeZahtevaDto> addResenjeZahteva(@RequestBody ResenjeZahtevaDto resenjeZahtevaDto) throws Exception {
        ResenjeZahteva resenjeZahteva = resenjeZahtevaService.addResenjeZahteva(resenjeZahtevaDto);
        return new ResponseEntity<>(new ResenjeZahtevaDto(resenjeZahteva), HttpStatus.OK);
    }

    @PostMapping(value="/create-report", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ReportDatesDto> createReport(@RequestBody ReportDatesDto reportDatesDto) throws ParseException {
        resenjeZahtevaService.createReport(reportDatesDto);
        return new ResponseEntity<>(reportDatesDto, HttpStatus.OK);
    }

    @GetMapping(value="/get-resenje-zahteva-that-references-to/{number}", produces = "application/xml")
    public ResponseEntity<ResenjeZahtevaDto> getResenjeZahtevaThatReferencesTo(@PathVariable String number) throws Exception {
        ResenjeZahteva resenjeZahteva = resenjeZahtevaService.getResenjeZahtevaByReferenca(number);
        return new ResponseEntity<>(new ResenjeZahtevaDto(resenjeZahteva), HttpStatus.OK);
    }

}
