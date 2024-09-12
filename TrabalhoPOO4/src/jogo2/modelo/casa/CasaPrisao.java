package jogo2.modelo.casa;

import jogo2.modelo.Jogo;
import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;

public class CasaPrisao extends Casa {

	String strColor;

	public CasaPrisao(int posiçao) {
		super(posiçao);
		strColor = "\u001B[35m"; // magenta
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		if (jogador.isArrested()) {
			System.out.println("Deseja pagar a fiança?\n1 - Sim.\n2 - Não.");
			int opc = 0;
			while (opc != 1 && opc != 2) {
				opc = Jogo.scanner.nextInt();
			}
			if (opc == 1) {
				if (jogador.pagarFianca()) {
					System.out.println(jogador.getColor() + " foi liberado.");
					Tabuleiro.instancia.jogar(jogador);
					Tabuleiro.instancia.aplicarRegraDaCasa(Tabuleiro.getCasas().get(jogador.getPosition()), jogador);
				} else {
					System.out.println("Número de moedas insuficientes.");
				}
			} else {
				System.out.println(jogador.getColor() + " permanece preso.");
			}
			jogador.setArrested(false);
		} else {
			System.out.println(jogador.getColor() + " foi preso.");
			jogador.setArrested(true);
		}
	}

	public String toString() {
		return super.toString(strColor);
	}

}
