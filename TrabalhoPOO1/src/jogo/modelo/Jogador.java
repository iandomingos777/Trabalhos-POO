package jogo.modelo;

public abstract class Jogador {

	protected String color;
	protected int id;
	protected int position;
	protected int numberMoves = 0;
	protected boolean blocked = false;
	protected boolean winner = false;

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

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
			color = "rosa";
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
		String strColor = " ";
		String resetColor = "\u001B[0m";
		switch (id) {
		case 1:
			strColor = "\u001B[34m";
			break;
		case 2:
			strColor = "\u001B[31m";
			break;
		case 3:
			strColor = "\u001B[38;5;205m";
			break;
		case 4:
			strColor = "\u001B[33m";
			break;
		case 5:
			strColor = "\u001B[32m";
			break;
		case 6:
			strColor = "\u001B[35m";
		}
		if(winner) return strColor + color.toUpperCase() + resetColor;
		else return strColor + color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase() + resetColor;
	}

	public int getId() {
		return id;
	}

	public void movePlayer(int sum) {
		int newPosition = this.position + sum;
		setPosition(newPosition);
	}

	public String toString() {
		String strColor = " ";
		String resetColor = "\u001B[0m";
		switch (id) {
		case 1:
			strColor = "\u001B[34m";
			break;
		case 2:
			strColor = "\u001B[31m";
			break;
		case 3:
			strColor = "\u001B[38;5;205m";
			break;
		case 4:
			strColor = "\u001B[33m";
			break;
		case 5:
			strColor = "\u001B[32m";
			break;
		case 6:
			strColor = "\u001B[35m";
		}
		return strColor + id + resetColor;
	}

	public abstract String classString();
}
