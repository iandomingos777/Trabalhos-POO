package robo;

import robo.modelo.Robo;
import robo.modelo.RoboInteligente;

public class Main {
	
	public static void main(String[] args) {
		
		Robo r1 = new RoboInteligente("azul");
		
		r1.moverRobo(1);
		r1.moverRobo(2);
		r1.moverRobo(2);
		r1.moverRobo(2);
		
	}
	
}


