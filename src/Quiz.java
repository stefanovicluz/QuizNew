import java.util.Scanner;

public class Quiz {
    private Pergunta[] perguntas;
    private Usuario usuario;

    public Quiz(Pergunta[] perguntas, Usuario usuario) {
        this.perguntas = perguntas;
        this.usuario = usuario;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Iniciando o Quiz =====\n");

        int contador = 1;

        for (Pergunta pergunta : perguntas) {
            System.out.println("Pergunta " + contador + ": " + pergunta.getEnunciado());
            String[] opcoes = pergunta.getOpcoes();

            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + ") " + opcoes[i]);
            }

            System.out.print("Digite o número da opção correta: ");

            int resposta;
            while (true) {
                try {
                    resposta = Integer.parseInt(scanner.nextLine());
                    if (resposta < 1 || resposta > opcoes.length) {
                        System.out.println("Opção inválida. Tente novamente.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido.");
                }
            }

            if (pergunta.verificarResposta(resposta - 1)) {
                System.out.println("✅ Resposta correta!\n");
                usuario.adicionarPontos(1);
            } else {
                System.out.println("❌ Resposta incorreta.");
                System.out.println("Resposta correta: " + (pergunta.getRespostaCorreta() + 1) + " - " + opcoes[pergunta.getRespostaCorreta()] + "\n");
            }

            contador++;
        }

        System.out.println("===== Quiz finalizado! =====");
        System.out.println("Pontuação final de " + usuario.getNome() + ": " + usuario.getPontuacao() + " pontos\n");
    }
}
