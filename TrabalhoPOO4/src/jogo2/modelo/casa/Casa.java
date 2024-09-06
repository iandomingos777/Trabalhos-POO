package jogo2.modelo.casa;

import java.util.ArrayList;

import jogo2.modelo.jogador.Jogador;

public abstract class Casa {
	protected int posiçao;
	protected ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	public Casa(int posiçao) {
		this.posiçao = posiçao;
	}

	public int getPosiçao() {
		return posiçao;
	}

	public void setPosiçao(int posiçao) {
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Jogador j : jogadores) {
			sb.append(j);
		}
		for(int i = jogadores.size(); i < 6; i++) {
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
}
