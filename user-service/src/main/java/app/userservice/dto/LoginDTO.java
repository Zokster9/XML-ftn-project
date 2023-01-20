package app.userservice.dto;

public class LoginDTO {

    private String korisnickoIme;

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
