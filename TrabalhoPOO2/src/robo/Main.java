package robo;

import robo.modelo.PlanoCartesiano;
import robo.modelo.Robo;
import robo.modelo.RoboInteligente;

public class Main {
	
	public static void main(String[] args) {

		
		Robo r1 = new RoboInteligente("azul");
		PlanoCartesiano plano = new PlanoCartesiano(4, 4);
		System.out.println(plano);
		r1.moverRobo(1);
		r1.moverRobo(2);
		r1.moverRobo(2);
		r1.moverRobo(2);
		
	}
}


