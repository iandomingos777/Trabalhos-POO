package jogo2.modelo.casa;

import jogo2.modelo.jogador.Jogador;

public class CasaJogaDeNovo extends Casa{

	public CasaJogaDeNovo(int posiçao) {
		super(posiçao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador deve jogar novamente.");
     	jogador.setJogaDenovo(true);
	}

}
