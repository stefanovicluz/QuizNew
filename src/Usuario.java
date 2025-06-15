import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private int pontuacao;

    public Usuario(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
    }
}
