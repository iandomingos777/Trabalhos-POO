package jogo2.modelo;

import jogo2.modelo.decorator.JogadorDecorator;

public class JogadorComBoné extends JogadorDecorator {
	
	public JogadorComBoné(Jogador jogadorDecorado) {
		super(jogadorDecorado);
		multiplicador = 1;
	}

	public int getMultiplicador() {
		return super.getMultiplicador() + multiplicador;
	}
}
