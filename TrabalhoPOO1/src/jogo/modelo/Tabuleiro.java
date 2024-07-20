package jogo.modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private ArrayList<Campo> squares = new ArrayList<>(41);

	public Tabuleiro() {
		for(int i = 0; i < 41; i++) {
			squares.add(new Campo(i));
		}
	}
	
	public void moveInSquare(Jogador jogador) {

		if (jogador.isBlocked()) {
			jogador.setBlocked(false);
			return;
		}
  
		squares.get(jogador.getPosition()).remPlayer(jogador);
		
		Random random = new Random();
		int dado1 = random.nextInt(6) + 1;
		System.out.print("Dado 1: ");
		int dado2 = random.nextInt(6) + 1;
		System.out.println(dado1);
		System.out.print("Dado 2: ");
		System.out.println(dado2);
		int sum = dado1 + dado2;
		if(jogador instanceof JogadorAzarado && sum > 6) {
			System.out.println("Jogador é azarado, soma dos dados não pode ser maior que 6");
			sum = 5;
		}
		else if(jogador instanceof JogadorSortudo && sum < 7) {
			System.out.println("Jogador é sortudo, a soma dos dados não pode ser menor que 7");
			sum = 7;
		}
		System.out.println("Soma dos dados: " + sum);
		jogador.movePlayer(sum);

		switch (jogador.getPosition()) {
		case 10:
		case 25:
		case 38:
			jogador.setBlocked(true);
			break;
		case 13:
			// implementação
			break;
		case 5:
		case 15:
		case 30:
			if (!(jogador instanceof JogadorAzarado)) {
				jogador.movePlayer(3);
			}
		case 17:
		case 27:
			System.out.print("Escolha um jogador para voltar para o início, diga sua cor");
			Scanner enter = new Scanner(System.in);
			String harmed = enter.nextLine();
			for (Jogador j : jogadores) {
				if (j.getColor().equalsIgnoreCase(harmed)) {
					j.setPosition(0);
				}
			}
		case 20:
		case 35:
			int lower = 40;
			for (Jogador j : jogadores) {
				if (j.getPosition() < lower) {
					lower = j.getPosition();
				}
			}
			// continuar
		}
		if(jogador.getPosition() > 40) {
			jogador.setPosition(40);
		}
		squares.get(jogador.getPosition()).addPlayer(jogador);
	}

	public boolean veriFicarVitoria() {
		if(!squares.get(40).getPlayers().isEmpty()) {
			System.out.println(squares.get(40).getPlayers().get(0).getColor() + " venceu :)");
			return true;
		}
		return false;
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder();

for(int i = 0; i <= 10; i++) {
	int length = squares.get(i).getPlayers().size();
	sb.append("[");
	for(int j = 0; j < length; j++) {
		sb.append(squares.get(i).getPlayers().get(j));
	}
	for(int j = 0; j < 6 -length; j++) {
		sb.append(" ");
	}
	sb.append("]");
}
sb.append("\n");
sb.append("\n");
for(int i = 1; i <= 10; i++) {
	int lenght1 = squares.get(41 - i).getPlayers().size();
	int lenght2 = squares.get(10 + i).getPlayers().size();
	for(int j = 0; j < 6; j++) {
		for(int k = 0; k < 8; k++) {
			sb.append(" ");
		}
		if(j < lenght1) {
			sb.append("|").append(squares.get(41 - i).getPlayers().get(j)).append("|");
		} else {
			sb.append("|").append(" ").append("|");
		}
			for(int k = 0; k < 75; k++) {
				sb.append(" ");
			}
			if(j < lenght2) {
				sb.append("|").append(squares.get(10 + i).getPlayers().get(j)).append("|");
			} else {
				sb.append("|").append(" ").append("|");
			}
			sb.append("\n");
	}
	sb.append("\n");
}
for(int k = 0; k < 8; k++) {
	sb.append(" ");
}
	for(int i = 1; i <= 10; i++) {
		int length = squares.get(31 - i).getPlayers().size();
		sb.append("[");
		for(int j = 0; j < length; j++) {
			sb.append(squares.get(31 - i).getPlayers().get(j));
		}
		for(int j = 0; j < 6 -length; j++) {
			sb.append(" ");
		}
		sb.append("]");
	}
	    return sb.toString();
	}
}
