package jogo2.modelo.casa;

import jogo2.modelo.jogador.Jogador;
import jogo2.modelo.jogador.JogadorSortudo;

public class CasaAzar extends Casa{

	public CasaAzar(int posiçao) {
		super(posiçao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
     if(jogador instanceof JogadorSortudo) {
    	 System.out.println("Jogador é sortudo. Logo, não perde as 3 moedas.");
    	 return;
     }
     System.out.println("Jogador perde 3 moedas");
     jogador.decrementarNumMoedas(3);
	}
}
