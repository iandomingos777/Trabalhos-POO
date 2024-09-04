package jogo2.modelo;

import java.util.Random;

public class CasaSurpresa extends Casa {

	public CasaSurpresa(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		int id = jogador.getId();
		Random random = new Random();
		int temp = random.nextInt(2) + 1;

		Jogador novoJogador = null;
		
		if (jogador instanceof JogadorSortudo) {
			switch (temp) {
				case 1:
					novoJogador = new JogadorAzarado(id);
					break;
				case 2:
					novoJogador = new JogadorNormal(id);
					break;
			}
		} else if (jogador instanceof JogadorNormal) {
			switch (temp) {
				case 1:
					novoJogador = new JogadorAzarado(id);
					break;
				case 2:
					novoJogador = new JogadorSortudo(id);
					break;
			}
		} else {
			switch (temp) {
				case 1:
					novoJogador = new JogadorNormal(id);
					break;
				case 2:
					novoJogador = new JogadorSortudo(id);
					break;
			}
		}
		if(novoJogador != null) {
			novoJogador.receberAtributos(jogador, novoJogador);
			jogador = novoJogador;	
		}
        
	}



}
