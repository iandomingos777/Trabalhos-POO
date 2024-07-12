package robo;

import java.util.Scanner;

import robo.visao.PlanoCartesianoConsole;

public class Main1 {

	public static void main(String[] args) {
		
        Scanner entrada = new Scanner(System.in);
        int x, y;
        System.out.println("Posição X da comida: ");
        x = entrada.nextInt();
        System.out.println("Posição Y da comida: ");
        y = entrada.nextInt();
		
        PlanoCartesianoConsole plano = new PlanoCartesianoConsole(x, y); 
        
        plano.jogarMain1();
        
        entrada.close();
		
	}
	
}
