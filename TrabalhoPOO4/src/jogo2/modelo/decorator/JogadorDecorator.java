package jogo2.modelo.decorator;

import jogo2.modelo.jogador.Jogador;

public class JogadorDecorator extends Jogador {
	protected Jogador jogadorDecorado;

	public JogadorDecorator(Jogador jogadorDecorado) {
		super(jogadorDecorado.getId());
		this.jogadorDecorado = jogadorDecorado;
	}

	@Override
	public void jogarDados() {
		jogadorDecorado.jogarDados();
	}

	@Override
	public String tipoJogador() {
		return jogadorDecorado.tipoJogador();
	}
	
	public int getMultiplicador() {
		return super.getMultiplicador() + multiplicador;
	}
}
