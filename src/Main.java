import colecoes.Apresentacoes;
import colecoes.Equipes;
import model.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Universidade puc = new Universidade("PUC Minas", "12345678000100");
        Empresa google = new Empresa("Google", "98765432000199");

        Equipe equipe1 = new Equipe("Cranianinhos");
        for (int i = 1; i <= 5; i++) {
            Estudante aluno = new Estudante("Aluno" + i, puc, "2024" + i);
            equipe1.adicionarMembro(aluno);
            //System.out.println("Adicionando " + aluno.getNome() + " a equipe " + equipe1.getNomeEquipe());
        }
        Equipes.getInstance().adicionar(equipe1);

        Equipe equipe2 = new Equipe("Nerds");
        for (int i = 6; i <= 10; i++) {
            Estudante aluno = new Estudante("Aluno" + i, puc, "2024" + i);
            equipe2.adicionarMembro(aluno);
            //System.out.println("Adicionando " + aluno.getNome() + " a equipe " + equipe2.getNomeEquipe());
        }
        Equipes.getInstance().adicionar(equipe2);

        Profissional orientador1 = new Profissional("Matheus", google, "Engenheira de Software");
        Profissional orientador2 = new Profissional("Fernanda", google, "Design UX");

        Projeto projeto1 = new Projeto(orientador1, equipe1);
        Projeto projeto2 = new Projeto(orientador2, equipe2);

        Jurado[] jurados = {
            new Jurado("Fernando", google, "Analista"),
            new Jurado("Jose", google, "Especialista"),
            new Jurado("Carlos", google, "Gerente"),
            new Jurado("Wellinton", google, "Desenvolvedor pleno"),
            new Jurado("Edurdo", google, "Consultor"),
            new Jurado("Cassio", google, "Arquiteto"),
            new Jurado("Luiz", google, "Líder Técnico"),
            new Jurado("Arthur", google, "Desenvolvedor sênior")
        };

        Banca banca1 = new Banca(projeto1);
        Banca banca2 = new Banca(projeto2);

        // Adiciona jurados e notas
        for (int i = 0; i < 4; i++) {
            banca1.adicionarNota(jurados[i], 8);
            //System.out.println("Adicionando jurado " + jurados[i].getNome() + " a banca de " + projeto1.getEquipe().getNomeEquipe());
            banca2.adicionarNota(jurados[i + 4], (i % 2 == 0) ? 6 : 5);
            //System.out.println("Adicionando jurado " + jurados[i + 4].getNome() + " a banca de " + projeto2.getEquipe().getNomeEquipe());
        }

        Sala sala1 = new Sala("Lab A", "101");
        Sala sala2 = new Sala("Lab B", "102");

        Apresentacao ap1 = new Apresentacao(projeto1, banca1, sala1, LocalDateTime.now());
        Apresentacao ap2 = new Apresentacao(projeto2, banca2, sala2, LocalDateTime.now());

        Apresentacoes.getInstance().adicionar(ap1);
        Apresentacoes.getInstance().adicionar(ap2);

        ap1.avaliar();
        ap2.avaliar();

        //Exibe projetos com notaFinal
        System.out.println("Projetos Aprovados com nota maior ou igual a 7:");
        Apresentacoes.getInstance().listarTodas().stream()
            .filter(ap -> ap.getProjeto().getNotaFinal() >= 7)
            .forEach(ap -> {
                Projeto p = ap.getProjeto();
                System.out.println("- " + p.getEquipe().getNomeEquipe() +
                                   " com Nota: " + p.getNotaFinal());
            });
    }
}