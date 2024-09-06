<<<<<<< Updated upstream:TrabalhoPOO4/src/jogo2/modelo/CasaSorte.java
package jogo2.modelo;
=======
package jogo2.modelo.casa;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;
>>>>>>> Stashed changes:TrabalhoPOO4/src/jogo2/modelo/casa/CasaSorte.java

public class CasaSorte extends Casa{

	public CasaSorte(int posiçao) {
		super(posiçao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador anda 3 casas");
		Tabuleiro.getCasas().get(posiçao).remJogador(jogador);;
		jogador.setPosition(jogador.getPosition() + 3);
		Tabuleiro.getCasas().get(jogador.getPosition()).addJogador(jogador);
	}

}
