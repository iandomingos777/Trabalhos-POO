package robo;

import java.util.Scanner;

import robo.visao.PlanoCartesianoConsole;

public class Main1 {

	public static void main(String[] args) {
		
        Scanner entrada = new Scanner(System.in);
        int x, y; 
        
        do {
            System.out.print("Posição X da comida: ");
            x = entrada.nextInt();
            System.out.print("Posição Y da comida: ");
            y = entrada.nextInt();
            System.out.println();
        } while((x < 0 || y < 0) || (x == 0 && y == 0)) ;
        
		
        PlanoCartesianoConsole plano = new PlanoCartesianoConsole(x, y); 
        
        plano.jogarMain1();
        
        entrada.close();
		
	}
	
}
