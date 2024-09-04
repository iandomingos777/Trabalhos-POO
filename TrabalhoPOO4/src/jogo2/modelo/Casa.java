package jogo2.modelo;

import java.util.ArrayList;

public abstract class Casa {
	protected int posiçao;
	protected ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	public Casa(int posiçao) {
		this.posiçao = posiçao;
	}

	public abstract void aplicarRegra(Jogador jogador);

	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	public void remJogador(Jogador jogador) {
		for (int i = 0, length = jogadores.size(); i < length; i++) {
			if (jogadores.get(i).getId() == jogador.getId()) {
				jogadores.remove(i);
				return;
			}
		}
	}
}
