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
			        Random random = new Random();			        
			        int newmoviment; 
			        do {
			            newmoviment = random.nextInt(4) + 1; 
			        } while (newmoviment == i);
			        while(currentException) {
			        	moverRobo(newmoviment);
			        }      
					return;
				}
			}
			super.moverRobo(i);
			currentException = false;
		} catch (MovimentoInvalidoException e) {
			if(currentException) {
				moverRobo(ultimoMovimento);
				return;
			}
			else {
				System.out.println("\u001B[31m" + this.getCor() + " - " + e.getMessage() + "\u001B[0m" + "\n");
				currentException = true;
				setMovimentosInvalidos(getMovimentosInvalidos()+1);
			}
		} finally {
			ultimoMovimento = i;
		}
	}
	
	@Override
	public void moverRobo(String str) {
		// TODO Auto-generated method stub
		int i = 0;
		switch (str) {
		case "up": 
			i = 1;
			break;
		case "down":
			i = 2;
			break;
		case "right":
			i = 3;
			break;
		case "left":
			i = 4;
		}
		try {
			if(currentException) {
				if(i == ultimoMovimento) {
			        Random random = new Random();			        
			        int newmoviment; 
			        do {
			            newmoviment = random.nextInt(4) + 1; 
			        } while (newmoviment == i);
			        while(currentException) {
			        	moverRobo(newmoviment);
			        }      
					return;
				}
			}
			super.moverRobo(i);
			currentException = false;
		} catch (MovimentoInvalidoException e) {
			if(currentException) {
				moverRobo(ultimoMovimento);
				return;
			}
			else {
				System.out.println("Movimento inválido\n");
				currentException = true;
			}
		} finally {
			ultimoMovimento = i;
		}
	}

}
