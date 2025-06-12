package colecoes;

import model.Equipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Equipes {
    private static Equipes instancia;
    private List<Equipe> listaEquipes;

    private Equipes() {
        listaEquipes = new ArrayList<>();
    }

    public static Equipes getInstance() {
        if (instancia == null) {
            instancia = new Equipes();
        }
        return instancia;
    }

    public void adicionar(Equipe equipe) {
        if (equipe != null) {
            listaEquipes.add(equipe);
        }
    }

    public Optional<Equipe> buscarPorNome(String nome) {
        return listaEquipes.stream()
                .filter(e -> e.getNomeEquipe().equalsIgnoreCase(nome))
                .findFirst();
    }

    public List<Equipe> listarTodas() {
        return listaEquipes;
    }
}
