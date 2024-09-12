package jogo2.modelo.casa;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;
import jogo2.modelo.jogador.JogadorAzarado;

public class CasaSorte extends Casa {

	String strColor;

	public CasaSorte(int posiçao) {
		super(posiçao);
		strColor = "\u001B[32m"; // verde
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		
		if(jogador instanceof JogadorAzarado) {
			System.out.println("Jogador é azarado, não pode andar 3 casas.");
			return;
		}
		
		System.out.println("Jogador anda 3 casas.");
		for (int i = 0; i < 3; i++) {
			Tabuleiro.instancia.mover(jogador);
		}

		Tabuleiro.instancia.aplicarRegraDaCasa(Tabuleiro.getCasas().get(jogador.getPosition()), jogador);

	}

	public String toString() {
		return super.toString(strColor);
	}

}
