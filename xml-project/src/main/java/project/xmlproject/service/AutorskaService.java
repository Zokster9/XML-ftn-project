package project.xmlproject.service;

import org.springframework.stereotype.Service;
import project.xmlproject.dto.autorska.ObrazacAutorskoDeloCreationDTO;
import project.xmlproject.marshal.MarshalAutorska;
import project.xmlproject.model.autorska.ObrazacAutorskoDelo;
import project.xmlproject.repository.AutorskaRepository;

@Service
public class AutorskaService {

    AutorskaRepository autorskaRepository = new AutorskaRepository();

    MarshalAutorska marshalAutorska = new MarshalAutorska();

    public ObrazacAutorskoDelo kreirajZahtev(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) throws Exception {
        ObrazacAutorskoDelo obrazacAutorskoDelo = marshalAutorska.marshalAutorska(obrazacAutorskoDeloCreationDTO);
        return autorskaRepository.kreiraj(obrazacAutorskoDelo);
    }

    public  ObrazacAutorskoDelo dobaviAutorskoDelo(String brojAutorskogDela) throws Exception {
        return autorskaRepository.dobaviAutorsko(brojAutorskogDela);
    }
}
