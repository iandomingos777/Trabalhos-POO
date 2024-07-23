package jogo.modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private ArrayList<Campo> squares = new ArrayList<>(41);

	public Tabuleiro(ArrayList<Jogador> players) {
		for(int i = 0; i < 41; i++) {
			squares.add(new Campo(i));
		}		
		for(Jogador jogador : players) {
			jogadores.add(jogador);
			squares.get(0).addPlayer(jogador);
		}
	}
	
	private void moveAtomic(int sum, Jogador jogador) {
		for(int i = 0; i < sum; i++) {
			squares.get(jogador.getPosition()).remPlayer(jogador);
			jogador.movePlayer(1);
			squares.get(jogador.getPosition()).addPlayer(jogador);
			System.out.println(this);
			System.out.println(jogador.getColor() + " na casa " + jogador.getPosition());
			veriFicarVitoria();
			try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void moveInSquare(Jogador jogador) {
		
		System.out.println("\nÉ a vez do jogador " + jogador.getColor());

		if (jogador.isBlocked()) {
			System.out.println(jogador.getColor() + " está bloqueado");
			jogador.setBlocked(false);
			return;
		}
		
		Random random = new Random();
		int dado1 = random.nextInt(6) + 1;
		System.out.print("Dado 1: ");
		int dado2 = random.nextInt(6) + 1;
		System.out.println(dado1);
		System.out.print("Dado 2: ");
		System.out.println(dado2);
		int sum = dado1 + dado2;
		if (jogador instanceof JogadorAzarado && sum > 6) {
			System.out.println("Jogador é azarado, soma dos dados não pode ser maior que 6");
			sum = 6;
		} else if (jogador instanceof JogadorSortudo && sum < 7) {
			System.out.println("Jogador é sortudo, a soma dos dados não pode ser menor que 7");
			sum = 7;
		}
		System.out.println("Soma dos dados: " + sum);
		try {
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		moveAtomic(sum, jogador);
		checkPosition(jogador);
		System.out.println(jogador.getColor() + " finalizou a jogada na casa: " + jogador.getPosition() );
	}
	
	public void checkPosition(Jogador jogador) {
		switch (jogador.getPosition()) {
	    case 10:
	    case 25:
	    case 38:
	        
	    	System.out.println("Casa " + jogador.getPosition() + ": nao joga a proxima rodada");
	    	jogador.setBlocked(true);
	        break; 
	        
	    case 13:
	        // Implementação para a posição 13 (a ser definida conforme necessário)
	        break;
	        
	    case 5:
	    case 15:
	    case 30:
	        
        	System.out.println("Casa " + jogador.getPosition() + ": ande 3 casas");
	        if (!(jogador instanceof JogadorAzarado)) {
	            moveAtomic(3, jogador);
	        }else {
	        	System.out.println("Jogador é azarado. Não andará as 3 casas");
	        }
	        
	        break;
	        
	    case 17:
	    case 27:
	        if(jogadores.size() <= 1) return;
	        Scanner enter = new Scanner(System.in);
	        System.out.println("Casa " + jogador.getPosition() + ": Escolha um jogador para voltar para o início!");
	        System.out.println("Diga sua cor: ");
	        String harmed = enter.next(); 
	        
	        try {
	            boolean found = false;
	            for (Jogador j : jogadores) {
	                System.out.println("Comparing with player color: " + j.getColor());
	                if (j.getColor().equalsIgnoreCase(harmed)) {
	                    System.out.println("Match found: " + j.getColor());
	                    squares.get(j.getPosition()).remPlayer(j);
	                    j.setPosition(0);
	                    squares.get(0).addPlayer(j);
	                    found = true;
	                    break; // Exit loop after finding and processing the player
	                }
	            }
	            if (!found) {
	                System.out.println("Player color not found: " + harmed);
	            }
	        } catch (Exception e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            enter.close();
	        }
	        break;

	        
	    case 20:
	    case 35:
	        // Se o jogador está nas posições 20 ou 35, encontra o jogador com a posição mais baixa
	        System.out.print("Casa "+ jogador.getPosition() + ": Troca de posiçao com o jogador mais atras");
	    	int lower = 40; // Inicializa com um valor alto para encontrar a menor posição
	    	Jogador aux = null;
	        for (Jogador j : jogadores) {
	            if (j.getPosition() < lower) {
	                lower = j.getPosition();
	                aux = j;
	            }
	        }
	        squares.get(lower).remPlayer(aux);
	        aux.setPosition(jogador.getPosition());
	        squares.get(jogador.getPosition()).addPlayer(aux);
	        
	        squares.get(jogador.getPosition()).remPlayer(jogador);
	        jogador.setPosition(lower);
	        squares.get(jogador.getPosition()).addPlayer(jogador);
	        
	        
	        // Implementação adicional para o caso 20 e 35 deve ser continuada aqui
	        break; // Sai do switch após encontrar a menor posição
	}
		try {
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean veriFicarVitoria() {
		if (!squares.get(40).getPlayers().isEmpty()) {
			System.out.println(squares.get(40).getPlayers().get(0).getColor() + " venceu :)");
			System.exit(0);
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j < 3; j++) {
				sb.append(" ");
			}
			sb.append(i);
			for(int j = 0; j < 4; j++) {
				sb.append(" ");
			}
		}
		sb.append("\n");
		
		for (int i = 0; i <= 10; i++) {
			sb.append(squares.get(i));
		}
		sb.append("\n");
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < 6; j++) {
				sb.append(" ");
			}
			sb.append(41 - i);
			sb.append(squares.get(41 - i));
			for (int j = 0; j < 64; j++) {
				sb.append(" ");
			}
			sb.append(squares.get(10 + i));
			sb.append(10 + i);
			sb.append("\n");
		}
		
		for (int i = 0; i < 8; i++) {
			sb.append(" ");
		}
		for (int i = 30; i >= 21; i--) {
			sb.append(squares.get(i));
		}
		sb.append("\n");		

		for(int i = 0; i < 8; i++) {
			sb.append(" ");
		}
		for(int i = 30; i >= 21; i--) {
			for(int j = 0; j < 3; j++) {
				sb.append(" ");
			}
			sb.append(i);
			for(int j = 0; j < 3; j++) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
