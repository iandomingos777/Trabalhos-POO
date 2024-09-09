package jogo2.modelo.casa;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;

public class CasaSimples extends Casa {
	
	String strColor;

	public CasaSimples(int posiçao) {
		super(posiçao);
		strColor =  "\u001B[0m"; // branco
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		if(jogador.getPosition() == Tabuleiro.getNumCasas() || jogador.getPosition() == 0) return;
		System.out.println("Jogador ganha " + jogador.getMultiplicador() + " moeda(s)");
		jogador.incrementarNumMoedas(1);
	}
	
	public String toString() {
		return super.toString(strColor);
	}
}
