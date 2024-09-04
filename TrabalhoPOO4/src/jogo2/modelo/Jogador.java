package jogo2.modelo;

public abstract class Jogador {
	
	protected String color;
	protected int id;
	protected int position;
	protected boolean arrested = false;
	protected boolean winner = false;
	protected int somaDados;
	protected int numMoedas; 
	
	public abstract void jogarDados();
	public abstract String tipoJogador();
	
	public Jogador(int id) {
		this.id = id;
		switch (id) {
		case 1:
			color = "Azul";
			break;
		case 2:
			color = "Vermelho";
			break;
		case 3:
			color = "Rosa";
			break;
		case 4:
			color = "Amarelo";
			break;
		case 5:
			color = "Verde";
			break;
		case 6:
			color = "Roxo";
		}
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

	public void setSomaDados(int somaDados) {
		this.somaDados = somaDados;
	}

	public boolean isArrested() {
		return arrested;
	}

	public void setArrested(boolean arrested) {
		this.arrested = arrested;
	}
	
}
