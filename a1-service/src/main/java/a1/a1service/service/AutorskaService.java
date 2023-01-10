package a1.a1service.service;

import a1.a1service.dto.ObrazacAutorskoDeloCreationDTO;
import a1.a1service.marshal.MarshalAutorska;
import a1.a1service.model.ObrazacAutorskoDelo;
import a1.a1service.repository.AutorskaRepository;
import a1.a1service.transform.AutorskaTransform;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AutorskaService {

    AutorskaRepository autorskaRepository = new AutorskaRepository();

    MarshalAutorska marshalAutorska = new MarshalAutorska();

    AutorskaTransform autorskaTransform = new AutorskaTransform();

    public ObrazacAutorskoDelo kreirajZahtev(ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO) throws Exception {
        ObrazacAutorskoDelo obrazacAutorskoDelo = marshalAutorska.marshalAutorska(obrazacAutorskoDeloCreationDTO);
        return autorskaRepository.kreiraj(obrazacAutorskoDelo);
    }

    public  ObrazacAutorskoDelo dobaviAutorskoDelo(String brojAutorskogDela) throws Exception {
        return autorskaRepository.dobaviAutorsko(brojAutorskogDela);
    }

    public void kreirajHTML(ObrazacAutorskoDelo obrazacAutorskoDelo) {
        String htmlFajl = "src/main/resources/static/html/" + obrazacAutorskoDelo.getBrojPrijave() + ".html";
        autorskaTransform.kreirajHTML(obrazacAutorskoDelo, htmlFajl);
    }

    public void kreirajPDF(ObrazacAutorskoDelo obrazacAutorskoDelo) throws IOException {
        String htmlFajl = "src/main/resources/static/html/" + obrazacAutorskoDelo.getBrojPrijave() + ".html";
        String pdfFajl = "src/main/resources/static/pdf/" + obrazacAutorskoDelo.getBrojPrijave() + ".pdf";
        autorskaTransform.kreirajPDF(htmlFajl, pdfFajl);
    }
}
