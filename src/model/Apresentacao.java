package model;
import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Avaliavel banca;
    private LocalDateTime dataHora;
    private Sala local;

    public Apresentacao(Projeto projeto, Avaliavel banca, Sala local, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public void avaliar() {
        banca.avaliar();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Sala getLocal() {
        return local;
    }
}