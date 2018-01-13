package br.edu.unidavi.JogoAdivinhacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Jogo {

    private List<Jogador> rankingAmador = new ArrayList<Jogador>();
    private List<Jogador> rankingExpert = new ArrayList<Jogador>();


    public void menuJogo() {
        int opcao = 0;

        Logger.getGlobal().info("---------- Jogo da adivinhacao ------------");
        Logger.getGlobal().info("");
        Logger.getGlobal().info("+----------------- Opções ----------------+");
        Logger.getGlobal().info("|                                         |");
        Logger.getGlobal().info("|               1 - Jogar                 |");
        Logger.getGlobal().info("|               2 - Ranking               |");
        Logger.getGlobal().info("|               3 - Sair                  |");
        Logger.getGlobal().info("+-----------------------------------------+");
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
        Logger.getGlobal().info("Informe seu nome");
        Scanner nome = new Scanner(System.in);
        jogador.setNome(nome.nextLine());

        Logger.getGlobal().info("Informe sua idade");
        Scanner idade = new Scanner(System.in);
        jogador.setIdade(idade.nextInt());

        Logger.getGlobal().info("Informe seu NickName");
        Scanner nick = new Scanner(System.in);
        jogador.setNickName(nick.nextLine());

        int dificuldade = 0;
        Logger.getGlobal().info("+--------------------------------------+");
        Logger.getGlobal().info("|   Por favor informe a dificuldade    |");
        Logger.getGlobal().info("|                                      |");
        Logger.getGlobal().info("|            1 - Normal                |");
        Logger.getGlobal().info("|            2 - Expert                |");
        Logger.getGlobal().info("+--------------------------------------+");
        Scanner scan = new Scanner(System.in);
        dificuldade = scan.nextInt();
        Numero numero = new Numero(dificuldade);
        Logger.getGlobal().info("+------------------------------------+");

        Logger.getGlobal().info("|    Número sorteado entre 0 e " + (dificuldade == 1 ? 20 : 100) + "    |");
        Tentativa tentativa = new Tentativa(dificuldade);
        System.out.println("+------------------------------------+");
        Logger.getGlobal().info("+------------------------------------+");

        while (tentativa.getTentativas() > 0) {
            Logger.getGlobal().info("Por favor informe um número");
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
        Logger.getGlobal().info("----------- Ranking Amadores --------------");
        if (rankingAmador.size() > 0) {
            Collections.sort(rankingAmador);
            for (Jogador jogador : rankingAmador) {
                Logger.getGlobal().info("%-20s %d pontos");
                jogador.getNickName(),
                        jogador.getPontos()));
            }
        } else {
            Logger.getGlobal().info("+-----------------------------------------------+");
            Logger.getGlobal().info("|  Ranking de amadores vazio, por favor jogue!  |");
            Logger.getGlobal().info("+-----------------------------------------------+");
        }
        Logger.getGlobal().info("----------- Ranking Experts ---------------");
        if (rankingExpert.size() > 0) {
            Collections.sort(rankingExpert);
            for (Jogador jogador : rankingExpert) {
                Logger.getGlobal().info("%-20s %d pontos");
                jogador.getNickName(),
                        jogador.getPontos()));
            }
        } else {
            Logger.getGlobal().info("+-----------------------------------------------+");
            Logger.getGlobal().info("|   Ranking de Experts vazio, por favor jogue!  |");
            Logger.getGlobal().info("+-----------------------------------------------+");
        }
    }
}
