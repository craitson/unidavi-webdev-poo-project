package br.edu.unidavi.JogoAdivinhacao;


import java.util.Random;

public class Numero {

    private int numero;
    private int dificuldade;

    public Numero() {
        Random random = new Random();
        this.numero = random.nextInt(20);
    }

    public Numero(int dificuldade) {
        Random random = new Random();
        switch (dificuldade) {
            case 1:
                this.numero = random.nextInt(20);
                break;
            case 2:
                this.numero = random.nextInt(100);
                break;
            default:
                break;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int diificuldade) {
        this.dificuldade = diificuldade;
    }

    public boolean verificaNumero(int numero) {

        if (numero > this.numero) {
            System.out.println("Numero mais baixo");
            return false;
        } else if (numero < this.numero) {
            System.out.println("Numero mais alto");
            return false;
        } else {
            System.out.println("+----------------------------+");
            System.out.println("|   Parabéns você acertou!   |");
            System.out.println("+----------------------------+");
            return true;
        }
    }
}
