package jogo2.modelo;

public class Main {
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.lerCasas();
		jogo.lerJogadores();
		jogo.gerarTabuleiro();
		jogo.printarTabuleiro();
		jogo.iniciar();
	}
}
