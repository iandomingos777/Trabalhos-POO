package jogo2.modelo;

public class CasaSimples extends Casa {

	public CasaSimples(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador ganha uma moeda.");
		jogador.incrementarNumMoedas(1);
	}

}
