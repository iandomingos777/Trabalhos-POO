package robo.modelo;

import robo.excecao.RochaException;

public class Rocha extends Obstaculo{

	public Rocha(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bater(Robo robo) {
		if(robo.getPosX() == posX && robo.getPosY() == posY ) {
			
			throw new RochaException("Bateu na rocha");
			
		}
	}
	
	public String toString(){
        String rock = "\uD83E\uDEA8";
        String grayColor = "\u001B[38;5;8m";
		String resetColor = "\u001B[0m";
		
        return grayColor + rock + resetColor;
	}

}
