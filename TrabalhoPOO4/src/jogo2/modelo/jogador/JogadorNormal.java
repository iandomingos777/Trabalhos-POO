package jogo2.modelo.jogador;

import java.util.Random;

public class JogadorNormal extends Jogador {

	public JogadorNormal(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void jogarDados() {
		int sum = 0;
		int dado1 = 0; 
		int dado2 = 0;
		Random random = new Random();
		dado1 = random.nextInt(6) + 1;
		dado2 = random.nextInt(6) + 1;
		sum = dado1 + dado2;
		System.out.println("Dado 1: " + dado1);
		System.out.println("Dado 2: " + dado2);
		System.out.println("Soma dos dados: " + sum);
		setSomaDados(sum);	
	}

	@Override
	public String tipoJogador() {
		return "NORMAL";
	}

}
