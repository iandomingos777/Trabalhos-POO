package jogo2.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		Jogador jogador;
		ArrayList<Jogador> jogadores = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 6; i++) {
			System.out.println("1 - Azarado");
			System.out.println("2 - Normal");
			System.out.println("3 - Sortudo");
			int opc = scan.nextInt();
			jogador = JogadorFactory.criarJogador(opc, i+1);
			jogadores.add(jogador);
		}
		
		for(Jogador j : jogadores) {
			System.out.println(j.id);
		}
		scan.close();
	}
}
