package robo;

import robo.excecao.MovimentoInvalidoException;
import robo.modelo.PlanoCartesiano;
import robo.modelo.Robo;
import robo.modelo.RoboInteligente;

public class Main {
	
	public static void main(String[] args) {

		
		
		PlanoCartesiano plano = new PlanoCartesiano(4, 4);
		System.out.println(plano);
		
		Robo r1 = new Robo("azul");
		try {
			r1.moverRobo("up");
			r1.moverRobo(2);
			r1.moverRobo("right");
			r1.moverRobo("right");
			r1.moverRobo("down");
		} catch(MovimentoInvalidoException e) {
			e.printStackTrace();
			System.out.println("(" + r1.getPosX() + ", " + r1.getPosY() + ")");
			
		} finally {
			System.out.println("chegou aqui!");
		}
		
		System.out.println("-------");
		
		Robo r2 = new RoboInteligente("verde");
		r2.moverRobo("up");
		r2.moverRobo(2);
		r2.moverRobo("down");
		r2.moverRobo(2);
		r2.moverRobo("right");
		r2.moverRobo("right");
		

		
	}
}


