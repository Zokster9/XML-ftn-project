package project.xmlproject.service;


import org.springframework.stereotype.Service;
import project.xmlproject.model.zig.ZahtevZaPriznanjeZiga;
import project.xmlproject.repository.ZigRepository;

@Service
public class ZigService {

    private final ZigRepository zigRepository = new ZigRepository();

    public ZahtevZaPriznanjeZiga addZig(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
        return zigRepository.save(zahtevZaPriznanjeZiga);
    }

    public ZahtevZaPriznanjeZiga getZig() throws Exception {
        return zigRepository.getZig();
    }
}
