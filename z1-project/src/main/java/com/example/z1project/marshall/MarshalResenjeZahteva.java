package com.example.z1project.marshall;

import com.example.z1project.dto.KorisnikDTO;
import com.example.z1project.dto.ResenjeZahtevaDTO;
import com.example.z1project.model.zig.ResenjeZahteva;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;

public class MarshalResenjeZahteva {

    public void generateQRCodeImage(String text, int width, int height, String filePath)
            throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        System.out.println(path);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFFFFC041 ) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    public ResenjeZahteva marshalResenjeZahteva(ResenjeZahtevaDTO resenjeZahtevaDTO, KorisnikDTO sluzbenik) throws DatatypeConfigurationException, IOException, WriterException {
        ResenjeZahteva resenjeZahteva = new ResenjeZahteva();
        resenjeZahteva.setBrojResenjaZahteva(marshalGenerisanjeSifre("RZ-"));
        if (resenjeZahtevaDTO.isZahtevJePrihvacen()) {
            resenjeZahteva.setSifra(marshalGenerisanjeSifre("S-"));
        }else {
            resenjeZahteva.setObrazlozenje(resenjeZahtevaDTO.getObrazlozenje());
        }
        resenjeZahteva.setReferenca(resenjeZahtevaDTO.getReferenca());
        resenjeZahteva.setZahtevJePrihvacen(resenjeZahtevaDTO.isZahtevJePrihvacen());
        resenjeZahteva.setImeSluzbenika(sluzbenik.getIme());
        resenjeZahteva.setPrezimeSluzbenika(sluzbenik.getPrezime());
        resenjeZahteva.setDatumResenja(marshalGenerisanjeDatumaResenja());
        resenjeZahteva.setQr(marshalGenerateQrCode(resenjeZahteva.getReferenca()));
        return resenjeZahteva;
    }

    private String marshalGenerateQrCode(String brojZahteva) throws IOException, WriterException {
        //String qrCodeFileName = "../qr/" + brojZahteva + "_resenje_html.png";
        generateQRCodeImage("http://localhost:9004/html/" + brojZahteva + "_resenje.html",
                300, 300, "./src/main/resources/static/qr/" + brojZahteva + "_resenje_html.png");
        return Base64.getEncoder().encodeToString(getQRCodeImage("http://localhost:9004/html/" + brojZahteva + "_resenje.html",
                300, 300));
    }

    private String marshalGenerisanjeSifre(String brojObrasca) {
        Date now = new Date();
        brojObrasca += String.valueOf(now.getTime());
        return brojObrasca;
    }

    private XMLGregorianCalendar marshalGenerisanjeDatumaResenja() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }
}
