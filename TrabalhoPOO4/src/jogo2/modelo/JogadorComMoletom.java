package jogo2.modelo;

import jogo2.modelo.decorator.JogadorDecorator;

public class JogadorComMoletom extends JogadorDecorator {

	public JogadorComMoletom(Jogador jogadorDecorado) {
		super(jogadorDecorado);
		multiplicador = 1;
	}

	public int getMultiplicador() {
		return super.getMultiplicador() + multiplicador;
	}
}
