package br.edu.unidavi.JogoAdivinhacao;

public class Tentativa {

    private int tentativas;

    public Tentativa(int dif) {
        switch (dif) {
            case 1:
                this.tentativas = 5;
                break;
            case 2:
                this.tentativas = 6;
                break;
            default:
                break;
        }
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas() {
        this.tentativas--;
        System.out.println("Tentativas restantes " + this.tentativas);
    }

}