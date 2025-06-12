package model;

import java.util.HashMap;
import java.util.Map;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados;

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = new HashMap<>();
    }

    public void adicionarNota(Jurado jurado, int nota) {
        if (jurado != null && nota >= 0 && nota <= 10) {
            jurados.put(jurado, nota);
        }
    }

    public void adicionarJurado(Jurado jurado) {
        if (jurado != null) {
            jurados.putIfAbsent(jurado, null); 
        }
    }

    public Map<Jurado, Integer> getNotas() {
        return jurados;
    }

    public void calcularNotaFinal() {
        int soma = 0;
        int avaliadores = 0;

        for (Integer nota : jurados.values()) {
            if (nota != null) {
                soma += nota;
                avaliadores++;
            }
        }

        int media = (avaliadores > 0) ? soma / avaliadores : 0;
        projetoAvaliado.registrarNotaFinal(media);
    }

    @Override
    public void avaliar() {
        calcularNotaFinal();
    }
}
