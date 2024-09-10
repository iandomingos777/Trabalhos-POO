package jogo2.modelo.casa;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;

public class CasaReversa extends Casa {

	String strColor;

	public CasaReversa(int posiçao) {
		super(posiçao);
		strColor = "\u001B[34m"; // azul
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		Tabuleiro.setUltimoNoTabuleiro();
		if (Tabuleiro.getUltimo().getId() == jogador.getId()) {
			System.out.println("Jogador é o mais atrás no tabuleiro.");
			return;
		}

		int posicaoDoUltimo = Tabuleiro.getUltimo().getPosition();

		for (Jogador jog : Tabuleiro.getJogadores()) {
			if (jog.getId() == Tabuleiro.getUltimo().getId()) {
				Tabuleiro.getCasas().get(posicaoDoUltimo).remJogador(jog);
				jog.setPosition(jogador.getPosition());
				Tabuleiro.getCasas().get(jogador.getPosition()).addJogador(jog);
				break;
			}
		}

		Tabuleiro.getCasas().get(jogador.getPosition()).remJogador(jogador);
		jogador.setPosition(posicaoDoUltimo);
		Tabuleiro.getCasas().get(posicaoDoUltimo).addJogador(jogador);
		System.out.println("Trocou de casa com o jogador mais atrás.\n");
	}

	public String toString() {
		return super.toString(strColor);
	}
}
