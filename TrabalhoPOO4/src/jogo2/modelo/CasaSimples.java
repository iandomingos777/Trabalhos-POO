package src.jogo.modelo;

import jogo.modelo.Casa;

public class CasaSimples extends Casa {

	public CasaSimples(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		jogador.setNumMoedas(jogador.getNumMoedas() + 1);
	}

}
