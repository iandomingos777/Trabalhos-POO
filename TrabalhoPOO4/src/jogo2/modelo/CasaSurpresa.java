package jogo.modelo;

import java.util.Random;

public class CasaSurpresa extends Casa {

	public CasaSurpresa(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		Random random = new Random();
		int temp = random.nextInt(2) + 1;
		if (Jogador instanceof JogadorSortado) {
			switch (temp) {
			case 1:
				jogador = new JogadorAzarado();
				break;
			case 2:
				jogador = new JogadorNormal();
				break;
			}
			;
		} else if (jogador instanceof JogadorNormal) {
			switch (temp) {
			case 1:
				jogador = new JogadorAzarado();
				break;
			case 2:
				jogador = new JogadorSortudo();
				break;
			}
			;
		} else {
			switch (temp) {
			case 1:
				jogador = new JogadorNormal();
				break;
			case 2:
				jogador = new JogadorSortudo();
				break;
			}
			;
		}
	}

}
