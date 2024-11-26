import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Aluno {
    String nome;
    double nota1, nota2, nota3, media;

    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.media = (nota1 + nota2 + nota3) / 3;
    }
}

public class TabeladeNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.print("Digite o nome do aluno (ou 'fim' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Digite a primeira nota: ");
            double nota1 = scanner.nextDouble();
            System.out.print("Digite a segunda nota: ");
            double nota2 = scanner.nextDouble();
            System.out.print("Digite a terceira nota: ");
            double nota3 = scanner.nextDouble();
            scanner.nextLine(); // Consumir o \n restante

            alunos.add(new Aluno(nome, nota1, nota2, nota3));
        }

        // Ordenar os alunos pela média em ordem decrescente
        Collections.sort(alunos, (a1, a2) -> Double.compare(a2.media, a1.media));

        // Encontrar a maior e menor nota
        double maiorNota = alunos.get(0).nota1;
        double menorNota = alunos.get(0).nota1;
        String alunoMaiorNota = alunos.get(0).nome;
        String alunoMenorNota = alunos.get(0).nome;
        for (Aluno aluno : alunos) {
            if (aluno.nota1 > maiorNota) {
                maiorNota = aluno.nota1;
                alunoMaiorNota = aluno.nome;
            }
            if (aluno.nota1 < menorNota) {
                menorNota = aluno.nota1;
                alunoMenorNota = aluno.nome;
            }
            if (aluno.nota2 > maiorNota) {
                maiorNota = aluno.nota2;
                alunoMaiorNota = aluno.nome;
            }
            if (aluno.nota2 < menorNota) {
                menorNota = aluno.nota2;
                alunoMenorNota = aluno.nome;
            }
            if (aluno.nota3 > maiorNota) {
                maiorNota = aluno.nota3;
                alunoMaiorNota = aluno.nome;
            }
            if (aluno.nota3 < menorNota) {
                menorNota = aluno.nota3;
                alunoMenorNota = aluno.nome;
            }
        }

        // Imprimir a tabela
        System.out.println("\nTabela de Alunos (Ordenada pela Média):");
        System.out.println("Nome\tNota 1\tNota 2\tNota 3\tMédia");
        for (Aluno aluno : alunos) {
            System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f%n",
                    aluno.nome, aluno.nota1, aluno.nota2, aluno.nota3, aluno.media);
        }

        System.out.println("\nMaior nota: " + maiorNota + " (Aluno: " + alunoMaiorNota + ")");
        System.out.println("Menor nota: " + menorNota + " (Aluno: " + alunoMenorNota + ")");
    }
}
