package jogo2.modelo;

import java.util.ArrayList;

public class Tabuleiro {
	private static ArrayList<Casa> casas;
	private static ArrayList<Jogador> jogadores;
	public static Tabuleiro instancia;
	private static Jogador ultimo;
	private static int numCasas;

	private Tabuleiro(ArrayList<Casa> casas, ArrayList<Jogador> jogadores) {
		Tabuleiro.jogadores = jogadores;
		Tabuleiro.casas = casas;
		for (Jogador j : jogadores) {
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
		for (int i = 0; i < sum; i++) {
			mover(jogador);
		}
	}
	
	public String toString() {
		int num = numCasas/4;
		StringBuilder sb = new StringBuilder();
		sb.append(casas.get(0));
		for(int i = 1; i <= num; i++) {
			sb.append(casas.get(i));
		}
		sb.append("\n");
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 8; j++) {
				sb.append(" ");
			}
			sb.append(casas.get(4*num - i));
			for(int j = 0; j < (num - 2)*8; j++) {
				sb.append(" ");
			}
			sb.append(casas.get(num + i + 1));
			sb.append("\n");
		}
		for(int j = 0; j < 8; j++) {
			sb.append(" ");
		}
		for(int i = 0; i < num; i++) {
			sb.append(casas.get(3*num - i));
		}
		return sb.toString();
	}
	
    public void setUltimoNoTabuleiro() {
        Jogador ultimoNoTabuleiro = null;
        for (Jogador jogador : jogadores) {
            if (ultimoNoTabuleiro == null || jogador.getPosition() < ultimoNoTabuleiro.getPosition()) {
                ultimoNoTabuleiro = jogador;
            }
        }
        ultimo = ultimoNoTabuleiro;
    }

	public static ArrayList<Casa> getCasas() {
		return casas;
	}

	public static ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public static Jogador getUltimo() {
		return ultimo;
	}

	public static int getNumCasas() {
		return numCasas;
	}

	public static void setNumCasas(int numCasas) {
		Tabuleiro.numCasas = numCasas;
	}
	
}
