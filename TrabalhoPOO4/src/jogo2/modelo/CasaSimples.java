package jogo2.modelo;

public class CasaSimples extends Casa {

	public CasaSimples(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		if(jogador.getPosition() == Tabuleiro.getNumCasas() || jogador.getPosition() == 0) return;
		System.out.println("Jogador ganha uma moeda.");
		jogador.incrementarNumMoedas(1);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Jogador j : jogadores) {
			sb.append(j);
		}
		for(int i = jogadores.size(); i < 6; i++) {
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
}
