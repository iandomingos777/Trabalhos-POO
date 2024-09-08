package jogo2.modelo.casa;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;

public class CasaSimples extends Casa {

	public CasaSimples(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		if(jogador.getPosition() == Tabuleiro.getNumCasas() || jogador.getPosition() == 0) return;
		System.out.println("Jogador ganha " + jogador.getMultiplicador() + " moeda(s)");
		jogador.incrementarNumMoedas(1);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Jogador j : jogadores) {
			sb.append(j);
		}
		for(int i = jogadores.size(); i < 6; i++) {
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
}
