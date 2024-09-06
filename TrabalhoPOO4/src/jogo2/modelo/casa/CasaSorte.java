package jogo2.modelo.casa;

import jogo2.modelo.jogador.Jogador;

public class CasaSorte extends Casa{

	public CasaSorte(int posiçao) {
		super(posiçao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador anda 3 casas");
		jogador.setPosition(jogador.getPosition() + 3);
	}

}
