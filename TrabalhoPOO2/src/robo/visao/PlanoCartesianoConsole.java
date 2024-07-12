package robo.visao;

import java.util.Scanner;

import robo.excecao.MovimentoInvalidoException;
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
		
		int cont = 0;
		
		while(!plano.verificarVitoria() && cont < 10) {
			
			System.out.println(plano);
			
			System.out.println("1 - Up. 2 - Down. 3 - Right. 4 - Left");
	        System.out.print("Jogada: ");
	        int move = entrada.nextInt();
	        
	        try {
	        	plano.moverNoCampo(robo, move);
	        } catch(MovimentoInvalidoException e) {
				System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
				System.out.println("(" + robo.getPosX() + ", " + robo.getPosY() + ")");
	        }
			
		}
		
		entrada.close();
		
	}
	
}
