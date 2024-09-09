package jogo2.modelo.casa;

import jogo2.modelo.Tabuleiro;
import jogo2.modelo.jogador.Jogador;

public class CasaSorte extends Casa{
	
	String strColor;

	public CasaSorte(int posiçao) {
		super(posiçao);
		strColor = "\u001B[32m"; // verde
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador anda 3 casas");
		for(int i = 0; i < 3; i++) {
       Tabuleiro.instancia.mover(jogador);
		}
		
	}
	
	public String toString() {
		return super.toString(strColor);
	}

}
