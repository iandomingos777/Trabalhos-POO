package jogo2.modelo.casa;

import jogo2.modelo.jogador.Jogador;

public class CasaJogaDeNovo extends Casa{
	
	String strColor;

	public CasaJogaDeNovo(int posiçao) {
		super(posiçao);
		strColor = "\u001B[33m"; // amarelo
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador deve jogar novamente.");
     	jogador.setJogaDenovo(true);
	}
	
	public String toString() {
		return super.toString(strColor);
	}

}
