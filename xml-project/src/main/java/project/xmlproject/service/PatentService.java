package project.xmlproject.service;

import marshal.MarshalPatent;
import org.springframework.stereotype.Service;
import project.xmlproject.dto.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.repository.PatentRepository;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class PatentService {

    PatentRepository patentRepository = new PatentRepository();

    MarshalPatent marshalPatent = new MarshalPatent();
    public void addPatent(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = marshalPatent.marshalPatent(zahtevZaPriznanjePatentaCreationDto);
        patentRepository.save(zahtevZaPriznanjePatenta);
    }
}