package model;

public class Sala {
    private String nomeSala;
    private String identificador;

    public Sala(String nomeSala, String identificador) {
        this.nomeSala = nomeSala;
        this.identificador = identificador;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getIdentificador() {
        return identificador;
    }
}
