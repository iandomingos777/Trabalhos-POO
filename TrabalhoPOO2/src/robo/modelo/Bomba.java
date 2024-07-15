package robo.modelo;

public class Bomba extends Obstaculo{

	public Bomba(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bater(Robo robo) {
		// TODO Auto-generated method stub
		robo.setPosX(-1);
		robo.setPosY(-1);
		
	}

}
