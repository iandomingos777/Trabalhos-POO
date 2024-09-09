package jogo2.modelo.casa;

import java.util.Random;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;
import jogo2.modelo.jogador.JogadorAzarado;
import jogo2.modelo.jogador.JogadorNormal;
import jogo2.modelo.jogador.JogadorSortudo;

public class CasaSurpresa extends Casa {
	
	String strColor;

	public CasaSurpresa(int posiçao) {
		super(posiçao);
		strColor = "\u001B[36m"; // ciano
	}
	@Override
	public void aplicarRegra(Jogador jogador) {
		Tabuleiro.getCasas().get(posiçao).remJogador(jogador);
		int id = jogador.getId();
		Random random = new Random();
		int temp = random.nextInt(2) + 1;

		Jogador novoJogador = null;
		
		if (jogador instanceof JogadorSortudo) {
			switch (temp) {
				case 1:
					novoJogador = new JogadorAzarado(id);
					System.out.println(jogador.getColor() + " virou AZARADO!");
					break;
				case 2:
					novoJogador = new JogadorNormal(id);
					System.out.println(jogador.getColor() + " virou NORMAL!");
					break;
			}
		} else if (jogador instanceof JogadorNormal) {
			switch (temp) {
				case 1:
					novoJogador = new JogadorAzarado(id);
					System.out.println(jogador.getColor() + " virou AZARADO!");
					break;
				case 2:
					novoJogador = new JogadorSortudo(id);
					System.out.println(jogador.getColor() + " virou SORTUDO!");
					break;
			}
		} else {
			switch (temp) {
				case 1:
					novoJogador = new JogadorNormal(id);
					System.out.println(jogador.getColor() + " virou NORMAL!");
					break;
				case 2:
					novoJogador = new JogadorSortudo(id);
					System.out.println(jogador.getColor() + " virou SORTUDO!");
					break;
			}
		}
		if(novoJogador != null) {
			novoJogador.receberAtributos(jogador, novoJogador);
			jogador = novoJogador;
			Tabuleiro.getCasas().get(posiçao).addJogador(jogador);
			Tabuleiro.getJogadores().set(jogador.getId() - 1, jogador);
		}
        
	}
	
	public String toString() {
		return super.toString(strColor);
	}



}
