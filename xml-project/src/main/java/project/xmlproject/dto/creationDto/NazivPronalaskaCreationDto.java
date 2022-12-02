package project.xmlproject.dto.creationDto;

public class NazivPronalaskaCreationDto {

    private String srpskiNaziv;
    private String engleskiNaziv;

    public NazivPronalaskaCreationDto(){

    }

    public NazivPronalaskaCreationDto(String srpskiNaziv, String engleskiNaziv) {
        this.srpskiNaziv = srpskiNaziv;
        this.engleskiNaziv = engleskiNaziv;
    }

    public String getSrpskiNaziv() {
        return srpskiNaziv;
    }

    public void setSrpskiNaziv(String srpskiNaziv) {
        this.srpskiNaziv = srpskiNaziv;
    }

    public String getEngleskiNaziv() {
        return engleskiNaziv;
    }

    public void setEngleskiNaziv(String engleskiNaziv) {
        this.engleskiNaziv = engleskiNaziv;
    }
}
