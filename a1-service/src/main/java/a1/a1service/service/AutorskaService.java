package a1.a1service.service;

import a1.a1service.dto.ObrazacAutorskoDeloCreationDTO;
import a1.a1service.marshal.MarshalAutorska;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.repository.AutorskaRepository;
import org.springframework.stereotype.Service;

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
