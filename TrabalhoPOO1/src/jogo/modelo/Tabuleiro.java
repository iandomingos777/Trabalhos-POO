package jogo.modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
	
	private ArrayList<Jogador> jogadores = new ArrayList<>();

	public void moveInSquare(Jogador jogador) {
		
		if(jogador.isBlocked()) {
			jogador.setBlocked(false);
			return;
		}
		
		Random random = new Random();
		 int dado1 = random.nextInt(6) + 1;
		 System.out.print("Dado 1: ");
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(dado1);
		 
		 int dado2 = random.nextInt(6) + 1; 
		 System.out.print("Dado 1: ");
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(dado2);
		 
		 int sum = dado1 + dado2;	 
		 
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
			 if(!(jogador instanceof JogadorAzarado)) {
				 jogador.movePlayer(3);
			 }
			 break;
		 case 17:
		 case 27:
			 System.out.print("Escolha um jogador para voltar para o início, diga sua cor");
			 Scanner enter = new Scanner(System.in);
			 String harmed = enter.nextLine();
			 for(Jogador j : jogadores) {
				 if(j.getColor().equalsIgnoreCase(harmed)) {
					 j.setPosition(0);
				 }
			 }
		 case 20:
		 case 35:
			 int lower = 40;
			 for(Jogador j : jogadores) {
				 if (j.getPosition() < lower) {
					 lower = j.getPosition();
				 }
			 }
			 // continuar
		 }
	}
	
}
