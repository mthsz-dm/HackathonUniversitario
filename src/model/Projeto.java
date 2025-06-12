package model;

public class Projeto {
    private Profissional orientador;
    private Equipe equipe;
    private int notaFinal;

    public Projeto(Profissional orientador, Equipe equipe) {
        this.orientador = orientador;
        this.equipe = equipe;
    }

    public Profissional getOrientador() {
        return orientador;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    void registrarNotaFinal(int nota) {
        this.notaFinal = nota;
    }
}
