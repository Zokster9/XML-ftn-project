package com.example.z1project.service;


import com.example.z1project.database.ZigDatabase;
import com.example.z1project.model.zig.ZahtevZaPriznanjeZiga;
import com.example.z1project.repository.ZigRepository;
import com.example.z1project.transformXML.ZigTransformation;
import org.springframework.stereotype.Service;

@Service
public class ZigService {

    private final ZigRepository zigRepository = new ZigRepository();

    private final ZigDatabase zigDatabase = new ZigDatabase();

    private final ZigTransformation zigTransformation = new ZigTransformation();

    public ZahtevZaPriznanjeZiga addZig(ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga) throws Exception {
        return zigRepository.save(zahtevZaPriznanjeZiga);
    }

    public ZahtevZaPriznanjeZiga getZig() throws Exception {
        return zigRepository.getZig();
    }

    public ZahtevZaPriznanjeZiga createZigHtml(String brojPrijave) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigDatabase.getByBrojPrijave(brojPrijave);
        String htmlFile = "src/main/resources/static/html/" + brojPrijave + ".html";
        zigTransformation.generateHTML(htmlFile, zahtevZaPriznanjeZiga);
        return zahtevZaPriznanjeZiga;
    }

    public ZahtevZaPriznanjeZiga createZigPdf(String brojPrijave) throws Exception {
        ZahtevZaPriznanjeZiga zahtevZaPriznanjeZiga = zigDatabase.getByBrojPrijave(brojPrijave);
        String htmlFile = "src/main/resources/static/html/" + brojPrijave + ".html";
        String pdfFile = "src/main/resources/static/pdf/" + brojPrijave + ".pdf";
        zigTransformation.generateHTML(htmlFile, zahtevZaPriznanjeZiga);
        zigTransformation.generatePDF(htmlFile, pdfFile);
        return zahtevZaPriznanjeZiga;
    }
}
