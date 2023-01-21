package project.xmlproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import project.xmlproject.Util.TokenUtils;
import project.xmlproject.dto.creationDto.KorisnikDTO;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
import project.xmlproject.service.PatentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "patenti")
public class PatentController {

    @Autowired
    private PatentService patentService;
    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value = "/add-patent", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> addPatent(HttpServletRequest request, @RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (patentService.proveriKorisnika(token, false)) {
                ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.addPatent(zahtevZaPriznanjePatentaCreationDto);
                return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Po necemu pretrazivati, poslati nesto sa fronta, nmp
    @GetMapping(value = "/get-patent", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatent() throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.getPatent();
        //ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto = new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read");
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-patenti", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getAll(HttpServletRequest request) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (patentService.proveriKorisnika(token, true)) {
                List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta = patentService.getAllPatenti();
                List<ZahtevZaPriznanjePatentaCreationDto> zahteviZaPriznanjePatentaCreationDto = new ArrayList<>();
                for (ZahtevZaPriznanjePatenta z : zahteviZaPriznanjePatenta) {
                    zahteviZaPriznanjePatentaCreationDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
                }
                return new ResponseEntity<>(zahteviZaPriznanjePatentaCreationDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-all-patenti-by-korisnik", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getAllByKorisnik(HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            KorisnikDTO korisnikDTO = patentService.pronadjiKorisnika(token);
            if (korisnikDTO != null) {
                List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta = patentService.getAllPatentiByKorisnik(korisnikDTO.getKorisnickoIme());
                List<ZahtevZaPriznanjePatentaCreationDto> zahteviZaPriznanjePatentaCreationDto = new ArrayList<>();
                for (ZahtevZaPriznanjePatenta z : zahteviZaPriznanjePatenta) {
                    if (z.getPodaciOPrijavama().getNovaPrijava().getPriznatiDatumPrijave().length() > 0){
                        zahteviZaPriznanjePatentaCreationDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
                    }
                }
                return new ResponseEntity<>(zahteviZaPriznanjePatentaCreationDto, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/create-patent-html/{brojPrijave}", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatentHTML(@PathVariable String brojPrijave) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.createPatentHtml(brojPrijave);
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    @GetMapping(value = "/create-patent-pdf/{brojPrijave}", produces = "application/xml")
    public ResponseEntity<ZahtevZaPriznanjePatentaCreationDto> getPatentPDF(@PathVariable String brojPrijave) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = patentService.createPatentPdf(brojPrijave);
        return new ResponseEntity<>(new ZahtevZaPriznanjePatentaCreationDto(zahtevZaPriznanjePatenta, "read"), HttpStatus.OK);
    }

    @PostMapping(value = "/create-patent-rdf", produces = "application/xml")
    public ResponseEntity<String> getPatentRDF(HttpServletRequest request, @RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (patentService.proveriKorisnika(token, true)) {
                String rdf = patentService.createPatentRdfJson(zahtevZaPriznanjePatentaCreationDto);
                return new ResponseEntity<>(rdf, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-patent-json", produces = "application/json")
    public ResponseEntity<String> getPatentJSON(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto,
                                                HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (patentService.proveriKorisnika(token, true)) {
                String json = patentService.createPatentRdfJson(zahtevZaPriznanjePatentaCreationDto);
                return new ResponseEntity<>(json, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-patents-by-text/{text}", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getPatentsByText(@PathVariable String text,
                                                                                      HttpServletRequest request) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            KorisnikDTO korisnikDTO = patentService.pronadjiKorisnika(token);
            List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta = patentService.getPatentsByText(text);
            List<ZahtevZaPriznanjePatentaCreationDto> zahteviZaPriznanjePatentaCreationDto = new ArrayList<>();
            for (ZahtevZaPriznanjePatenta z : zahteviZaPriznanjePatenta) {
                if (!korisnikDTO.isKorisnikJeSluzbenik()) {
                    if (z.getPodnosilac().getKontaktPodaci().getEPosta().equals(korisnikDTO.getKorisnickoIme())) {
                        zahteviZaPriznanjePatentaCreationDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
                    }
                }
                else {
                    zahteviZaPriznanjePatentaCreationDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
                }
            }
            return new ResponseEntity<>(zahteviZaPriznanjePatentaCreationDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/get-patents-by-metadata/{query}", produces = "application/xml")
    public ResponseEntity<List<ZahtevZaPriznanjePatentaCreationDto>> getPatentsByMetadata(@PathVariable String query,
                                                                                          HttpServletRequest request) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            KorisnikDTO korisnikDTO = patentService.pronadjiKorisnika(token);
            List<ZahtevZaPriznanjePatenta> zahtevi = patentService.getPatentsByMetadata(query);
            List<ZahtevZaPriznanjePatentaCreationDto> zahteviDto = new ArrayList<>();
            for (ZahtevZaPriznanjePatenta z : zahtevi) {
                if (!korisnikDTO.isKorisnikJeSluzbenik()) {
                    if (z.getPodnosilac().getKontaktPodaci().getEPosta().equals(korisnikDTO.getKorisnickoIme())) {
                        zahteviDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
                    }
                }
                else {
                    zahteviDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
                }
            }
            return new ResponseEntity<>(zahteviDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-referenced-patents/{number}", produces = "application/xml")
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
            if (!z.getPodaciOPrijavama().getNovaPrijava().getBrojPrijave().equals(number)) {
                zahteviDto.add(new ZahtevZaPriznanjePatentaCreationDto(z, "read"));
            }
        }
        return new ResponseEntity<>(zahteviDto, HttpStatus.OK);
    }

}
