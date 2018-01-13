package JogoAdivinhacao;

import jdk.nashorn.internal.scripts.JO;

public class Jogador extends Pessoa implements Comparable<Jogador> {

    private String nickName;
    private int pontos;

    public Jogador(String nome, int idade, String nickName) {
        super(nome, idade);
        this.nickName = nickName;
    }

    public Jogador() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }


    public int compareTo(Jogador jogadoress) {
        if (this.pontos > jogadoress.getPontos()) {
            return -1;
        }
        if (this.pontos < jogadoress.getPontos()) {
            return 1;
        }
        return 0;
    }
}
