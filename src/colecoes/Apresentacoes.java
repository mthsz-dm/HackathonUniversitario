package colecoes;

import model.Apresentacao;

import java.util.ArrayList;
import java.util.List;

public class Apresentacoes {
    private static Apresentacoes instancia;
    private List<Apresentacao> listaApresentacoes;

    private Apresentacoes() {
        listaApresentacoes = new ArrayList<>();
    }

    public static Apresentacoes getInstance() {
        if (instancia == null) {
            instancia = new Apresentacoes();
        }
        return instancia;
    }

    public void adicionar(Apresentacao apresentacao) {
        if (apresentacao != null) {
            listaApresentacoes.add(apresentacao);
        }
    }

    public List<Apresentacao> listarTodas() {
        return listaApresentacoes;
    }
}
