package jogo2.modelo.casa;

import jogo2.modelo.jogador.Jogador;
import jogo2.modelo.jogador.JogadorSortudo;

public class CasaAzar extends Casa {

	String strColor;

	public CasaAzar(int posiçao) {
		super(posiçao);
		strColor = "\u001B[31m"; // vermelho
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		if (jogador instanceof JogadorSortudo) {
			System.out.println("Jogador é sortudo. Logo, não perde as 3 moedas.");
			return;
		}
		System.out.println("Jogador perde 3 moedas.");
		if (jogador.getNumJogadas() < 3) {
			jogador.setNumMoedas(0);
			return;
		}
		jogador.decrementarNumMoedas(3);
	}

	public String toString() {
		return super.toString(strColor);
	}
}
