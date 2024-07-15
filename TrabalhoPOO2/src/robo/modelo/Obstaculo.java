package robo.modelo;

public abstract class Obstaculo {

	private int id;
	private int posX;
	private int posY;
	
	public Obstaculo(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract void bater(Robo robo);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
