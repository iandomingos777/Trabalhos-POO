package robo;

import java.util.Scanner;

import robo.modelo.Bomba;
import robo.modelo.Rocha;
import robo.visao.PlanoCartesianoConsole;

public class Main4 {

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
        
        System.out.print("Quantas bombas? ");
        int numBombas = entrada.nextInt();
        System.out.print("Quantas rochas? ");
        int numRochas = entrada.nextInt();
        
        Bomba[] bombas = new Bomba[numBombas];
        Rocha[] rochas = new Rocha[numRochas];

        for(int i = 0; i < numBombas; i++) {
            System.out.print("Posição da bomba " + (i + 1) + " (x, y): ");
            int auxX = entrada.nextInt();
            int auxY = entrada.nextInt();
            bombas[i] = new Bomba(auxX, auxY);
        }
        
        for(int i = 0; i < numRochas; i++) {
            System.out.print("Posição da bomba " + (i + 1) + " (x, y): ");
            int auxX = entrada.nextInt();
            int auxY = entrada.nextInt();
            rochas[i] = new Rocha(auxX, auxY);
        }       
		
        PlanoCartesianoConsole plano = new PlanoCartesianoConsole(x, y); 
        
        plano.jogarMain4(bombas, rochas);
        
        entrada.close();
	}
	
}
