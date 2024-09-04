package jogo2.modelo;

import java.util.ArrayList;

public class Tabuleiro {
	private ArrayList<Casa> casas;
	private ArrayList<Jogador> jogadores;
	public static Tabuleiro instancia;

	private Tabuleiro(ArrayList<Casa> casas, ArrayList<Jogador> jogadores) {
    this.jogadores = jogadores;
    this.casas = casas;
    for(Jogador j: jogadores) {
    	casas.get(0).addJogador(j);
    }
	}
	
	public static Tabuleiro getInstancia(ArrayList<Casa> casas, ArrayList<Jogador> jogadores) {
		if (instancia == null) {
			instancia = new Tabuleiro(casas, jogadores);
		}
		return instancia;
	}
	
	public void mover(Jogador jogador) {
		casas.get(jogador.getPosition()).remJogador(jogador);
		jogador.setPosition(jogador.getPosition() + 1);
		casas.get(jogador.getPosition()).addJogador(jogador);
		System.out.println(this);
	}
	
	public void moveInSquare(Jogador jogador) {
		jogador.jogarDados();
		int sum = jogador.getSomaDados();
		for(int i = 0; i < sum; i++) {
			mover(jogador);
		}
	}
}
