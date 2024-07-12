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
		
		while(!plano.verificarVitoria()) {
			
			System.out.println(plano);
			
		}
		
		entrada.close();
		
	}
	
}
