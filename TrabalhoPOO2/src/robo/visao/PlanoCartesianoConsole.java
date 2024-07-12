package robo.visao;

import java.util.Scanner;

import robo.modelo.PlanoCartesiano;
import robo.modelo.Robo;

public class PlanoCartesianoConsole {

	private PlanoCartesiano plano;
	
	Scanner entrada = new Scanner(System.in);
	
	public PlanoCartesianoConsole(int x, int y) {
		// TODO Auto-generated constructor stub
		plano = new PlanoCartesiano(x, y);
		
	}
	
	public void jogarMain1() {
		
		Robo robo = new Robo("Verde");
		
		plano.addRoboNoPlano(robo);
		
		while(!plano.verificarVitoria()) {
			
			System.out.println(plano);
			
			System.out.println("1 - Up. 2 - Down. 3 - Right. 4 - Left");
	        System.out.print("Jogada: ");
	        String move = entrada.nextLine();
	        int moveInt = 0;
	        if(move.equals("1") || move.equals("2") || move.equals("3") || move.equals("4")) {
	        	moveInt = Integer.parseInt(move);
	        }	        
	        System.out.println();
	        if(moveInt == 1 || moveInt == 2 || moveInt == 3 || moveInt == 4) plano.moverNoCampo(robo, moveInt);
	        else if(move.equalsIgnoreCase("up") || move.equalsIgnoreCase("down") || 
	        		move.equalsIgnoreCase("left") || move.equalsIgnoreCase("right")) plano.moverNoCampo(robo, move.toLowerCase());
	        else System.out.println("Inválido");
	        
	        
	        System.out.println();
			
		}
		
		entrada.close();
		
	}
	
}
