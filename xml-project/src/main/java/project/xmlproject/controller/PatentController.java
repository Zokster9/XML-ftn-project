package project.xmlproject.controller;


import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.service.PatentService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value="patenti")
public class PatentController {

    @Autowired
    private PatentService patentService;

    @PostMapping(value="/add-patent")
    public ResponseEntity<Integer> addPatent(@RequestBody ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        patentService.addPatent(zahtevZaPriznanjePatentaCreationDto);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }
}
