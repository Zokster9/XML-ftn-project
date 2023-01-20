package app.userservice.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginDTO {

    @XmlElement
    private String korisnickoIme;
    @XmlElement
    private String lozinka;

    public LoginDTO() {
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }
}
