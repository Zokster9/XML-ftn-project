package project.xmlproject.service;

import org.springframework.stereotype.Service;
import project.xmlproject.dto.creationDto.ResenjeZahtevaDto;
import project.xmlproject.marshal.MarshalResenjeZahteva;
import project.xmlproject.model.resenjeZahteva.ResenjeZahteva;
import project.xmlproject.repository.ResenjeZahtevaRepository;

@Service
public class ResenjeZahtevaService {

    ResenjeZahtevaRepository resenjeZahtevaRepository = new ResenjeZahtevaRepository();

    MarshalResenjeZahteva marshalResenjeZahteva = new MarshalResenjeZahteva();

    public ResenjeZahteva addResenjeZahteva(ResenjeZahtevaDto resenjeZahtevaDto) throws Exception {
        ResenjeZahteva resenjeZahteva = marshalResenjeZahteva.marshalResenjeZahteva(resenjeZahtevaDto, "create");
        return resenjeZahtevaRepository.save(resenjeZahteva);
    }
}
