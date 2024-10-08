package jogo2.modelo.decorator;

import jogo2.modelo.jogador.Jogador;

public class JogadorComMoletom extends JogadorDecorator {

	public JogadorComMoletom(Jogador jogadorDecorado) {
		super(jogadorDecorado);
		multiplicador = 2;
	}

	@Override
	public String tipoJogador() {
		return super.tipoJogador() + ", MOLETOM";

	}

}
