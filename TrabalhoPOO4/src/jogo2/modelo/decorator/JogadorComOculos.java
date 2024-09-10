package jogo2.modelo.decorator;

import jogo2.modelo.jogador.Jogador;

public class JogadorComOculos extends JogadorDecorator {

	public JogadorComOculos(Jogador jogadorDecorado) {
		super(jogadorDecorado);
		multiplicador = 3;
	}

	@Override
	public String tipoJogador() {
		return super.tipoJogador() + ", ÓCULOS.";

	}

}