package robo;

import java.util.Scanner;

import robo.modelo.Bomba;
import robo.modelo.Rocha;
import robo.visao.PlanoCartesianoConsole;

public class Main4 {

	public static void main(String[] args) {
		
        Scanner entrada = new Scanner(System.in);
        int x, y;
        boolean[][] check = new boolean[5][5];
        
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 5; j++) {
        		check[i][j] = false;
        	}
        }
        
        do {
            System.out.print("Posição X da comida: ");
            x = entrada.nextInt();
            System.out.print("Posição Y da comida: ");
            y = entrada.nextInt();
            System.out.println();
        } while((x < 0 || y < 0) || (x == 0 && y == 0)) ;
        
        check[y][x] = true;
        
        int numRochas, numBombas;
        do {
        System.out.print("Quantas bombas? ");
        numBombas = entrada.nextInt();
        System.out.print("Quantas rochas? ");
        numRochas = entrada.nextInt();
        } while(numRochas + numBombas > 23 || numRochas < 0 || numBombas < 0);
        
        Bomba[] bombas = new Bomba[numBombas];
        Rocha[] rochas = new Rocha[numRochas];
        
        int auxX,auxY;
        for(int i = 0; i < numBombas; i++) {
            do {
        	System.out.print("Posição da bomba " + (i + 1) + " (x, y): ");
            auxX = entrada.nextInt();
            auxY = entrada.nextInt();
            bombas[i] = new Bomba(auxX, auxY);
            } while((auxX < 0 || auxY < 0) || (auxX == 0 && auxY == 0) || check[auxY][auxX] == true);
            check[auxY][auxX] = true;
        }
        
        
        for(int i = 0; i < numRochas; i++) {
        	do {
            System.out.print("Posição da rocha " + (i + 1) + " (x, y): ");
            auxX = entrada.nextInt();
            auxY = entrada.nextInt();
            rochas[i] = new Rocha(auxX, auxY);
        	 } while((auxX < 0 || auxY < 0) || (auxX == 0 && auxY == 0) || check[auxY][auxX] == true);
            check[auxY][auxX] = true;
        }
               
		
        PlanoCartesianoConsole plano = new PlanoCartesianoConsole(x, y); 
        
        plano.jogarMain4(bombas, rochas);
        
        entrada.close();
	}
	
}
