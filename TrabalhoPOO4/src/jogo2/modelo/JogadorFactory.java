package jogo2.modelo;

public class JogadorFactory {
	public static Jogador criarJogador(int opcao, int id) {
		switch (opcao) {
		case 1:
			return new JogadorAzarado(id);
		case 2: 
			return new JogadorNormal(id);
		case 3: 
			return new JogadorSortudo(id);
		default:
			System.out.println("Tipo inválido");
			return null;
		}
	}
}
