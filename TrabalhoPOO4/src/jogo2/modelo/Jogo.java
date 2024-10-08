package jogo2.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import jogo2.modelo.casa.Casa;
import jogo2.modelo.factory.CasaFactory;
import jogo2.modelo.factory.JogadorFactory;
import jogo2.modelo.jogador.Jogador;

public class Jogo {

	public static Scanner scanner = new Scanner(System.in);
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	Tabuleiro tabuleiro;

	public void lerJogadores() {
		int numPlayers = 0;

		do {
			System.out.println("Quantos jogadores?");
			numPlayers = scanner.nextInt();

		} while (numPlayers < 2 || numPlayers > 6);

		int[] contadorTipo = new int[3];
		boolean todosIguais;

		do {
			for (int i = 0; i < contadorTipo.length; i++) {
				contadorTipo[i] = 0;
			}

			for (int i = 1; i <= numPlayers; i++) {
				Jogador jogador;
				System.out.println("Defina o tipo do jogador " + i + "!");
				System.out.println("1 - Azarado.\n2 - Normal.\n3 - Sortudo.");
				int opcao = scanner.nextInt();
				while (opcao < 1 || opcao > 3) {
					System.out.println("Tipo inválido. Tente novamente.");
					opcao = scanner.nextInt();
				}
				jogador = JogadorFactory.criarJogador(opcao, i);
				jogadores.add(jogador);
				contadorTipo[opcao - 1]++;
			}

			todosIguais = false;
			for (int contador : contadorTipo) {
				if (contador == numPlayers) {
					todosIguais = true;
					System.out.println("Defina pelo menos 2 jogadores de tipos diferentes.");
					jogadores.clear();
					break;
				}
			}

		} while (todosIguais);
	}

	public void lerCasas() {
		System.out.println("Quantas casas tem o tabuleiro?");
		int numCasas = scanner.nextInt();
		Tabuleiro.setNumCasas(numCasas);

		int numCasasEspeciais = -1;
		while (numCasasEspeciais < 0 || numCasasEspeciais > numCasas) {
			System.out.println("Quantas casas especiais?\nOBS: Casas que não são simples.");
			numCasasEspeciais = scanner.nextInt();
		}

		Set<Integer> posicoesDasCasasEspeciais = new HashSet<>();
		for (int i = 1; i <= numCasasEspeciais; i++) {
			Casa casa;
			int opcaoCasa = 0;
			while (opcaoCasa < 1 || opcaoCasa > 7) {
				System.out.println("Diga o tipo da casa especial número " + i);
				System.out.println(
						"1 - CasaAzar\n2 - CasaJogaDeNovo\n3 - CasaPrisao\n4 - CasaSorte\n5 - CasaSurpresa\n6 - CasaTroca\n7 - CasaReversa");
				opcaoCasa = scanner.nextInt();
			}
			int posicaoCasa = -1;
			while (posicaoCasa < 1 || posicaoCasa >= numCasas) {
				System.out.println("Diga a posição da casa especial número " + i);
				posicaoCasa = scanner.nextInt();
			}

			while (posicoesDasCasasEspeciais.contains(posicaoCasa)) {
				System.out.println("Posição já utilizada. Diga uma nova posição para a casa especial número " + i);
				posicaoCasa = scanner.nextInt();
			}

			casa = CasaFactory.criarCasa(opcaoCasa + 1, posicaoCasa);
			casas.add(casa);
			posicoesDasCasasEspeciais.add(posicaoCasa);
		}

		for (int i = 0; i <= numCasas; i++) {
			if (posicoesDasCasasEspeciais.contains(i))
				continue;

			casas.add(CasaFactory.criarCasa(1, i));
		}
	}

	public void gerarTabuleiro() {
		casas.sort((c1, c2) -> Integer.compare(c1.getPosiçao(), c2.getPosiçao()));
		tabuleiro = Tabuleiro.getInstancia(casas, jogadores);
	}

	public void printarTabuleiro() {
		System.out.println(tabuleiro);
	}

	private void aplicarLogica(Jogador jogador) {
		tabuleiro.exibirInfo(jogador);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!jogador.isArrested()) {
			tabuleiro.jogar(jogador);
		} else {
			System.out.println(jogador.getColor() + " está preso.");
			System.out.println(tabuleiro);
		}
		int posicao = jogador.getPosition();
		tabuleiro.aplicarRegraDaCasa(Tabuleiro.getCasas().get(posicao), jogador);
		System.out.println();
	}

	public void iniciar() {
		while (!tabuleiro.verificarVitoria()) {
			for (Jogador jogador : Tabuleiro.getJogadores()) {
				aplicarLogica(jogador);
				if (jogador.isJogaDenovo()) {
					aplicarLogica(jogador);
					jogador.setJogaDenovo(false);
				}
				if (tabuleiro.verificarVitoria()) {
					System.exit(0);
				}
			}
		}
	}

}
