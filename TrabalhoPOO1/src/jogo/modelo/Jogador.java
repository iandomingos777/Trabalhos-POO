package jogo.modelo;

public abstract class Jogador {

	protected String color;
	protected int id;
	protected int position;
	protected int numberMoves;
	protected boolean blocked = false;
	
	public Jogador(int id) {
		this.id = id;
		switch (id) {
		case 1: 
			color = "azul";
			break;
		case 2: 
			color = "vermelho";
			break;
		case 3: 
			color = "branco";
			break;
		case 4: 
			color = "amarelo";
			break;
		case 5: 
			color = "verde";
			break;
		case 6: 
			color = "roxo";			
		}
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
	
	public void movePlayer(int sum) {
		int newPosition = this.position + sum;
		setPosition(newPosition);
	}
	
}
