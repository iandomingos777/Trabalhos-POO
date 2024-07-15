package robo.modelo;

public class Bomba extends Obstaculo{



	public Bomba(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bater(Robo robo) {
	    robo.setPosX(-1);
	    robo.setPosY(-1);
	}
	
	 public String toString() {
	        String bomba = "\uD83D\uDCA3";
	        String blackColor = "\u001B[30m";
	        String resetColor = "\u001B[0m";
	        
	        return blackColor + bomba + resetColor;
	    }

}
