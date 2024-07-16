package robo.modelo;

import robo.excecao.MovimentoInvalidoException;

public class Robo {

	protected String cor;
	protected int posX;
	protected int posY;
	protected int movimentosValidos = 0;
	protected int movimentosInvalidos = 0;

	public Robo(String cor) {
		this.cor = cor;
		posX = 0;
		posY = 0;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public String getCor() {
		return cor;
	}

	public int getMovimentosValidos() {
		return movimentosValidos;
	}

	public void setMovimentosValidos(int movimentosValidos) {
		this.movimentosValidos = movimentosValidos;
	}

	public int getMovimentosInvalidos() {
		return movimentosInvalidos;
	}

	public void setMovimentosInvalidos(int movimentosInvalidos) {
		this.movimentosInvalidos = movimentosInvalidos;
	}

	public void moverRobo(String str) {
		switch (str) {
		case "up":
			if(posY == 4) throw new MovimentoInvalidoException("Up: Inválido");
			else posY++;		
			break;
		case "down":
			if(posY == 0) throw new MovimentoInvalidoException("Down: Inválido");
			else posY--; 
			break;
		case "right":
			if(posX == 4) throw new MovimentoInvalidoException("Right: Inválido");
			else posX++;
					 
			break;
		case "left": 
			if(posX == 0) throw new MovimentoInvalidoException("Left: Inválido");
			posX--; 
		}
	}
	
	public void moverRobo(int i) {
		switch (i) {
		case 1:
			if(posY == 4) throw new MovimentoInvalidoException("Up: Inválido");
			else posY++;			
			break;
		case 2:
			if(posY == 0) throw new MovimentoInvalidoException("Down: Inválido");
			else posY--; 
			break;
		case 3:
			if(posX == 4) throw new MovimentoInvalidoException("Right: Inválido");
			else posX++; 
			break;
		case 4: 
			if(posX == 0) throw new MovimentoInvalidoException("Left: Inválido");
			posX--; 
		}
	}
	
	public String toString() {
	        String yellowColor = "\u001B[33m";
	        String greenColor = "\u001B[32m";
	        String resetColor = "\u001B[0m";
	        String robot = "\uD83E\uDD16"; 
	      if(cor.equals("Amarelo")) {
	    	  return yellowColor + robot + resetColor;
	      }
	      else if(cor.equals("Verde")) {
	    	  return greenColor + robot + resetColor;
	      }
               return "";
	}
}
