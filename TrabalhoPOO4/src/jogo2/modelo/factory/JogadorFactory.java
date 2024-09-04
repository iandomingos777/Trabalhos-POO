package jogo2.modelo.factory;

import jogo2.modelo.Jogador;
import jogo2.modelo.JogadorAzarado;
import jogo2.modelo.JogadorNormal;
import jogo2.modelo.JogadorSortudo;

public class JogadorFactory {
	public static Jogador criarJogador(int opcao, int id) {
		switch (opcao) {
		case 1:
			return new JogadorAzarado(id);
		case 2: 
			return new JogadorNormal(id);
		case 3: 
			return new JogadorSortudo(id);
		default:
			System.out.println("Tipo inválido");
			return null;
		}
	}
}
