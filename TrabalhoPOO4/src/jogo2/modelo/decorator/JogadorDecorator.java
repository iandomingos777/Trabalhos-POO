package jogo2.modelo.decorator;

import jogo2.modelo.Jogador;

public class JogadorDecorator extends Jogador {
	protected Jogador jogadorDecorado;

	public JogadorDecorator(Jogador jogadorDecorado) {
		super(jogadorDecorado.getId());
		this.jogadorDecorado = jogadorDecorado;
	}

	@Override
	public void jogarDados() {
		// TODO Auto-generated method stub

	}

	@Override
	public String tipoJogador() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMultiplicador() {
		return jogadorDecorado.getMultiplicador();
	}
}
