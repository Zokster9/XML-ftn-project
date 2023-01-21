package project.xmlproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.Util.TokenUtils;
import project.xmlproject.dto.creationDto.KorisnikDTO;
import project.xmlproject.dto.creationDto.ReportDatesDto;
import project.xmlproject.dto.creationDto.ResenjeZahtevaDto;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
import project.xmlproject.service.PatentService;
import project.xmlproject.service.ResenjeZahtevaService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
@RequestMapping(value="resenja-zahteva")
public class ResenjeZahtevaController {

    @Autowired
    private ResenjeZahtevaService resenjeZahtevaService;

    @Autowired
    private PatentService patentService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value="/add-resenje-zahteva", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ResenjeZahtevaDto> addResenjeZahteva(@RequestBody ResenjeZahtevaDto resenjeZahtevaDto,
                                                               HttpServletRequest request) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            KorisnikDTO korisnikDTO = patentService.pronadjiKorisnika(token);
            if (!korisnikDTO.isKorisnikJeSluzbenik()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else {
                ResenjeZahteva resenjeZahteva = resenjeZahtevaService.addResenjeZahteva(resenjeZahtevaDto, korisnikDTO);
                return new ResponseEntity<>(new ResenjeZahtevaDto(resenjeZahteva), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/create-report", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ReportDatesDto> createReport(@RequestBody ReportDatesDto reportDatesDto,
                                                       HttpServletRequest request) throws ParseException {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (patentService.proveriKorisnika(token, true)) {
                resenjeZahtevaService.createReport(reportDatesDto);
                return new ResponseEntity<>(reportDatesDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/get-resenje-zahteva-that-references-to/{number}", produces = "application/xml")
    public ResponseEntity<ResenjeZahtevaDto> getResenjeZahtevaThatReferencesTo(@PathVariable String number) throws Exception {
        ResenjeZahteva resenjeZahteva = resenjeZahtevaService.getResenjeZahtevaByReferenca(number);
        return new ResponseEntity<>(new ResenjeZahtevaDto(resenjeZahteva), HttpStatus.OK);
    }

}
