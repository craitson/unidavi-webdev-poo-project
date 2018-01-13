package JogoAdivinhacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private List<Jogador> rankingAmador = new ArrayList<Jogador>();
    private List<Jogador> rankingExpert = new ArrayList<Jogador>();


    public void menuJogo() {
        int opcao = 0;
        System.out.println("---------- Jogo da adivinhacao ------------");
        System.out.println("");
        System.out.println("+----------------- Opções ----------------+");
        System.out.println("|                                         |");
        System.out.println("|               1 - Jogar                 |");
        System.out.println("|               2 - Ranking               |");
        System.out.println("|               3 - Sair                  |");
        System.out.println("+-----------------------------------------+");
        Scanner ler = new Scanner(System.in);
        opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                iniciaJogo();
                menuJogo();
                break;

            case 2:
                imprimirRanking();
                menuJogo();
                break;
            default:
                break;
        }


    }

    private void iniciaJogo() {

        Jogador jogador = new Jogador();
        System.out.println("Informe seu nome");
        Scanner nome = new Scanner(System.in);
        jogador.setNome(nome.nextLine());

        System.out.println("Informe sua idade");
        Scanner idade = new Scanner(System.in);
        jogador.setIdade(idade.nextInt());

        System.out.println("Informe seu NickName");
        Scanner nick = new Scanner(System.in);
        jogador.setNickName(nick.nextLine());

        int dificuldade = 0;
        System.out.println("+--------------------------------------+");
        System.out.println("|   Por favor informe a dificuldade    |");
        System.out.println("|                                      |");
        System.out.println("|            1 - Normal                |");
        System.out.println("|            2 - Expert                |");
        System.out.println("+--------------------------------------+");
        Scanner scan = new Scanner(System.in);
        dificuldade = scan.nextInt();
        Numero numero = new Numero(dificuldade);
        System.out.println("+------------------------------------+");
        System.out.println("|    Número sorteado entre 0 e " + (dificuldade == 1 ? 20 : 100) + "    |");
        Tentativa tentativa = new Tentativa(dificuldade);
        System.out.println("+------------------------------------+");

        while (tentativa.getTentativas() > 0) {
            System.out.println("Por favor informe um número");
            Scanner leitura = new Scanner(System.in);
            boolean acertou = numero.verificaNumero(leitura.nextInt());
            if (acertou) {
                jogador.setPontos(tentativa.getTentativas());
                break;
            } else {
                tentativa.setTentativas();
            }

        }

        if (dificuldade == 1 ? rankingAmador.add(jogador) : rankingExpert.add(jogador)) ;

    }


    private void imprimirRanking() {
        System.out.println("----------- Ranking Amadores --------------");
        if (rankingAmador.size() > 0) {
            Collections.sort(rankingAmador);
            for (Jogador jogador : rankingAmador) {
                System.out.println(String.format("%-20s %d pontos",
                        jogador.getNickName(),
                        jogador.getPontos()));
            }
        } else {
            System.out.println("+-----------------------------------------------+");
            System.out.println("|  Ranking de amadores vazio, por favor jogue!  |");
            System.out.println("+-----------------------------------------------+");
        }
        System.out.println("----------- Ranking Experts ---------------");
        if (rankingExpert.size() > 0) {
            Collections.sort(rankingExpert);
            for (Jogador jogador : rankingExpert) {
                System.out.println(String.format("%-20s %d pontos",
                        jogador.getNickName(),
                        jogador.getPontos()));
            }
        } else {
            System.out.println("+-----------------------------------------------+");
            System.out.println("|   Ranking de Experts vazio, por favor jogue!  |");
            System.out.println("+-----------------------------------------------+");
        }
    }
}
