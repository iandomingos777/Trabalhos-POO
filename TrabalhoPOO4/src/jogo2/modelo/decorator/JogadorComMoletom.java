package jogo2.modelo.decorator;

import jogo2.modelo.jogador.Jogador;

public class JogadorComMoletom extends JogadorDecorator {

	public JogadorComMoletom(Jogador jogadorDecorado) {
		super(jogadorDecorado);
		multiplicador = 2;
	}

	public int getMultiplicador() {
		return super.getMultiplicador() + multiplicador;
	}
}
