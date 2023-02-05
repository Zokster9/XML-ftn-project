package a1.a1service.service;

import a1.a1service.model.ResenjeZahteva;
import com.itextpdf.kernel.pdf.PdfDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    private final String emailTo = "spring.mail.username";
    private final String emailFrom = "xmlprojekat@gmail.com";

    @Async
    public void posaljiMejlZaZahtev(ResenjeZahteva resenjeZahteva) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        File pdf = new ClassPathResource("static/pdf/" + resenjeZahteva.getReferenca() + "_resenje.pdf").getFile();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(Objects.requireNonNull(env.getProperty(emailTo)));
        helper.setFrom(emailFrom);
        helper.setSubject("Resenje zahteva");
        helper.setText("Vas zahtev za priznanje autorskog dela je: " + (resenjeZahteva.isZahtevJePrihvacen() ? "prihvacen." : "odbijen."), true);
        helper.addAttachment("resenje_zahteva.pdf", pdf);
        javaMailSender.send(mimeMessage);
    }
}
