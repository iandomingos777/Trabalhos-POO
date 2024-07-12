package robo;

import java.util.Scanner;

import robo.excecao.MovimentoInvalidoException;
import robo.modelo.PlanoCartesiano;
import robo.modelo.Robo;
import robo.modelo.RoboInteligente;
import robo.visao.PlanoCartesianoConsole;

public class Main {
	
	public static void main(String[] args) {

		
		
		PlanoCartesiano plano = new PlanoCartesiano(4, 1);
		Robo novoRobo = new Robo("Verde");
		Robo novoRobo2 = new Robo("Amarelo");
		plano.moverNoCampo(novoRobo, 1);
		plano.moverNoCampo(novoRobo, 1);
		plano.moverNoCampo(novoRobo2, 3);
		plano.moverNoCampo(novoRobo2, 3);
		plano.moverNoCampo(novoRobo2, 3);
		System.out.println(plano);
		
		Robo r1 = new Robo("azul");
		
		try {
			r1.moverRobo("up");
			r1.moverRobo(2);
			r1.moverRobo("right");
			r1.moverRobo("right");
			r1.moverRobo(3);
			r1.moverRobo("down");
		} catch(MovimentoInvalidoException e) {
			System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
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
		r2.moverRobo("left");
		r2.moverRobo("down");
		r2.moverRobo("down");
		
        String redColor = "\u001B[31m";
        String yellowColor = "\u001B[33m";
        String greenColor = "\u001B[32m";
        String resetColor = "\u001B[0m";
       
        String robot = "\uD83E\uDD16"; 
        String apple = "\uD83C\uDF4E"; 
      
        System.out.println("Símbolo de robô: " + yellowColor + robot + resetColor);
        System.out.println("Símbolo de robô: " + greenColor + robot + resetColor);
        System.out.println("Símbolo de alimento: " + redColor + apple + resetColor);
        
        Scanner entrada = new Scanner(System.in);
        int x, y;
        System.out.println("Posição X da comida: ");
        x = entrada.nextInt();
        System.out.println("Posição Y da comida: ");
        y = entrada.nextInt();
		
        new PlanoCartesianoConsole(x, y); 
        
        entrada.close();
		
	}
}


