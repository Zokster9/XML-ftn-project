package com.example.z1project.controller;


import com.example.z1project.Util.TokenUtils;
import com.example.z1project.Util.ZigExample;
import com.example.z1project.dto.ZahtevZaPriznanjeZigaDTO;
import com.example.z1project.model.zig.*;
import com.example.z1project.service.ZigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/zigovi")
public class ZigController {

    @Autowired
    private ZigService zigService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZahtevZaPriznanjeZigaDTO> createZig(@RequestBody ZahtevZaPriznanjeZigaDTO zahtevZaPriznanjeZigaDTO, HttpServletRequest request) throws Exception {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            if (zigService.proveriKorisnika(token, false)) {
                ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigService.kreirajZahtev(zahtevZaPriznanjeZigaDTO);
                return new ResponseEntity<>(new ZahtevZaPriznanjeZigaDTO(zahtevZaPriznanjeZiga), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{brojPrijaveZiga}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZahtevZaPriznanjeZigaDTO> getZahtevZaPriznanjeZiga(@PathVariable("brojPrijaveZiga") String brojPrijaveZiga) {
        try {
            ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigService.getZig(brojPrijaveZiga);
            return new ResponseEntity<>(new ZahtevZaPriznanjeZigaDTO(zahtevZaPriznanjeZiga), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/create-zig-html/{brojPrijave}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZahtevZaPriznanjeZigaDTO> getZigHTML(@PathVariable String brojPrijave, HttpServletRequest request) throws Exception {
        try {
            ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigService.createZigHtml(brojPrijave);
            return new ResponseEntity<>(new ZahtevZaPriznanjeZigaDTO(zahtevZaPriznanjeZiga), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/create-zig-pdf/{brojPrijave}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ZahtevZaPriznanjeZigaDTO> getZigPDF(@PathVariable String brojPrijave, HttpServletRequest request) throws Exception {
        String token = tokenUtils.getAuthHeaderFromHeader(request);
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigService.createZigPdf(token, brojPrijave);
        return new ResponseEntity<>(new ZahtevZaPriznanjeZigaDTO(zahtevZaPriznanjeZiga), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<ZahtevZaPriznanjeZigaDTO>> getAll(HttpServletRequest request) {
        try {
            String token = tokenUtils.getAuthHeaderFromHeader(request);
            List<ZahtevZaPriznanjeZiga> zahtevIZaPriznanjeZiga = zigService.dobaviSve(token);
            List<ZahtevZaPriznanjeZigaDTO> zahtevIZaPriznanjeZigaDTOS = zahtevIZaPriznanjeZiga.stream()
                    .map(ZahtevZaPriznanjeZigaDTO::new).collect(Collectors.toList());
            return new ResponseEntity<>(zahtevIZaPriznanjeZigaDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
