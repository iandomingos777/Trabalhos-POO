package robo.modelo;

import java.util.Random;

import robo.excecao.MovimentoInvalidoException;

public class RoboInteligente extends Robo{
	
	private int ultimoMovimento = 0;
	private boolean currentException = false;

	public RoboInteligente(String cor) {
		super(cor);
	}
	
	@Override
	public void moverRobo(int i) {
		// TODO Auto-generated method stub
		try {
			if(currentException) {
				if(i == ultimoMovimento) {
					System.out.println("Movimento não permitido. Um movimento válido será feito");
			        Random random = new Random();			        
			        int newmoviment; 
			        do {
			            newmoviment = random.nextInt(4) + 1; 
			        } while (newmoviment == i);
			        System.out.println("Novo movimento: " + newmoviment);
			        while(currentException) {
			        	moverRobo(newmoviment);
			        }      
					return;
				}
			}
			super.moverRobo(i);
			currentException = false;
		} catch (MovimentoInvalidoException e) {
			System.out.println("Movimento inválido");
			currentException = true;
		} finally {
			ultimoMovimento = i;
		}
	}
	
	@Override
	public void moverRobo(String str) {
		// TODO Auto-generated method stub
		try {
			super.moverRobo(str);
			currentException = false;
		} catch (MovimentoInvalidoException e) {
			System.out.println("Movimento inválido");
			currentException = true;
		} finally {
			switch(str) {
			case "up": 
				ultimoMovimento = 1;
				break;
			case "down": 
				ultimoMovimento = 2;
				break;
			case "right":
				ultimoMovimento = 3;
				break;
			case "left":
				ultimoMovimento = 4;
			}
		}
	}

}
