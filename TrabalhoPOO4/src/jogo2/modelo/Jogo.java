package jogo2.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import jogo2.modelo.factory.CasaFactory;
import jogo2.modelo.factory.JogadorFactory;

public class Jogo {

	static Scanner scanner = new Scanner(System.in);
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	Tabuleiro tabuleiro;

	public void gerarJogadores() {
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
				System.out.println("1 - Azarado\n2 - Normal\n3 - Sortudo");
				int opcao = scanner.nextInt();
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

	public void gerarCasas() {
		System.out.println("Quantas casas tem o tabuleiro?");
		int numCasas = scanner.nextInt();
		Tabuleiro.setNumCasas(numCasas);
		
		System.out.println("Quantas casas especiais?\nOBS: Casas que não são simples");
		int numCasasEspeciais = scanner.nextInt();
		
		Set<Integer> posicoesDasCasasEspeciais = new HashSet<>();
		for(int i = 1; i <= numCasasEspeciais; i++) {
			Casa casa;
			System.out.println("Diga o tipo da casa especial número " + i);
			System.out.println("1 - CasaAzar\n2 - CasaJogaDeNovo\n3 - CasaPrisao\n4 - CasaSorte\n5 - CasaSurpresa");
			int opcaoCasa = scanner.nextInt();
			System.out.println("Diga a posição da casa especial número " + i);
			int posicaoCasa = scanner.nextInt();
			
			while (posicoesDasCasasEspeciais.contains(posicaoCasa)) {
				System.out.println("Posição já utilizada. Diga uma nova posição para a casa especial número " + i);
				posicaoCasa = scanner.nextInt();
			}
			
			casa = CasaFactory.criarCasa(opcaoCasa+1, posicaoCasa);
			casas.add(casa);
			posicoesDasCasasEspeciais.add(posicaoCasa);
		}
		
		for(int i = 0; i <= numCasas; i++) {
			if(posicoesDasCasasEspeciais.contains(i)) continue;
			
			casas.add(CasaFactory.criarCasa(1, i));
		}
	}
	
	public Jogo() {
		gerarJogadores();
		gerarCasas();
		tabuleiro = Tabuleiro.getInstancia(casas, jogadores);
	}
}
