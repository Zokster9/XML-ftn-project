package project.xmlproject.service;

import project.xmlproject.marshal.MarshalPatent;
import org.springframework.stereotype.Service;
import project.xmlproject.dto.patent.creationDto.ZahtevZaPriznanjePatentaCreationDto;
import project.xmlproject.model.patent.ZahtevZaPriznanjePatenta;
import project.xmlproject.repository.PatentRepository;

@Service
public class PatentService {

    PatentRepository patentRepository = new PatentRepository();

    MarshalPatent marshalPatent = new MarshalPatent();
    public ZahtevZaPriznanjePatenta addPatent(ZahtevZaPriznanjePatentaCreationDto zahtevZaPriznanjePatentaCreationDto) throws Exception {
        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = marshalPatent.marshalPatent(zahtevZaPriznanjePatentaCreationDto);
        return patentRepository.save(zahtevZaPriznanjePatenta);
    }

    public ZahtevZaPriznanjePatenta getPatent() throws Exception {
        return patentRepository.getPatent();
    }
}
