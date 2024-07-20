package jogo.modelo;

public abstract class Jogador {

	protected String color;
	protected int id;
	protected int position;
	protected int numberMoves;
	protected boolean blocked;
	
	public Jogador(String color, int id) {
		this.color = color;
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getNumberMoves() {
		return numberMoves;
	}

	public void setNumberMoves(int numberMoves) {
		this.numberMoves = numberMoves;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.blocked = isBlocked;
	}

	public String getColor() {
		return color;
	}

	public int getId() {
		return id;
	}
	
	public void movePlayer() {
		// ao definir o metodo nas classes filhas, tornar ele abstract aqui!!!
	}
	
}
