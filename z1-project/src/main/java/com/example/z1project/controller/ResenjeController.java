package com.example.z1project.controller;

import com.example.z1project.Util.TokenUtils;
import com.example.z1project.dto.ReportDatesDTO;
import com.example.z1project.dto.ResenjeZahtevaDTO;
import com.example.z1project.model.zig.ResenjeZahteva;
import com.example.z1project.service.ResenjeZahtevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/resenja-zahteva")
public class ResenjeController {

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

    @PostMapping(value = "/kreiraj-izvestaj", produces = "application/xml", consumes = "application/xml")
    public ResponseEntity<ReportDatesDTO> kreirajIzvestaj(@RequestBody ReportDatesDTO reportDatesDTO, HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (resenjeZahtevaService.proveriKorisnika(token, true)) {
                resenjeZahtevaService.kreirajIzvestaj(reportDatesDTO);
                return new ResponseEntity<>(reportDatesDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
