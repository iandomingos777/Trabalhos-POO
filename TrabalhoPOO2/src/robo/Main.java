package robo;

import robo.modelo.PlanoCartesiano;
import robo.modelo.Robo;
import robo.modelo.RoboInteligente;

public class Main {
	
	public static void main(String[] args) {
		
		PlanoCartesiano plano = new PlanoCartesiano(10, 5);
		plano.imprimirCampos();
		Robo r1 = new RoboInteligente("azul");
		
		r1.moverRobo(1);
		r1.moverRobo(2);
		r1.moverRobo(2);
		r1.moverRobo(2);
		
	}
	
}


