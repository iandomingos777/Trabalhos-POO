package jogo2.modelo.casa;

import jogo2.modelo.jogador.Jogador;

public class CasaPrisao extends Casa{

	
	public CasaPrisao(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador foi preso");
		jogador.setArrested(true);
      }

}
