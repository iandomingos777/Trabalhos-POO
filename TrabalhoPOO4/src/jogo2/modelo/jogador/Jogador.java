package jogo2.modelo.jogador;

public abstract class Jogador {

	protected String color;
	protected int id;
	protected int position = 0;
	protected boolean arrested = false;
	protected boolean winner = false;
	protected int somaDados;
	protected int numMoedas = 0;
	protected int rodadasConsecutivasPreso = 0;
	protected boolean jogaDenovo = false;
	protected int multiplicador = 1;
	protected int numJogadas = 0;

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
		return strColor + color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase() + resetColor;
	}

	public void setSomaDados(int somaDados) {
		this.somaDados = somaDados;
	}

	public int getSomaDados() {
		return somaDados;
	}

	public boolean isArrested() {
		return arrested;
	}

	public void setArrested(boolean arrested) {
		this.arrested = arrested;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getNumMoedas() {
		return numMoedas;
	}

	public void incrementarNumMoedas(int incremento) {
		numMoedas += incremento * getMultiplicador();
	}

	public boolean decrementarNumMoedas(int decremento) {
		if (numMoedas >= decremento) {
			numMoedas -= decremento;
			return true;
		}
		return false;
	}

	public boolean pagarFianca() {
		if (numMoedas >= 2) {
			numMoedas -= 2;
			return true;
		}
		return false;
	}

	public void receberAtributos(Jogador source, Jogador destination) {
		destination.setPosition(source.getPosition());
		destination.setArrested(source.isArrested());
		destination.setSomaDados(source.getSomaDados());
		destination.setNumMoedas(source.getNumMoedas());
		destination.setRodadasConsecutivasPreso(source.getRodadasConsecutivasPreso());
		destination.setJogaDenovo(source.isJogaDenovo());
		destination.setNumJogadas(source.getNumJogadas());
	}

	public int getRodadasConsecutivasPreso() {
		return rodadasConsecutivasPreso;
	}

	public void setRodadasConsecutivasPreso(int rodadasConsecutivasPreso) {
		this.rodadasConsecutivasPreso = rodadasConsecutivasPreso;
	}

	public boolean isJogaDenovo() {
		return jogaDenovo;
	}

	public void setJogaDenovo(boolean jogaDenovo) {
		this.jogaDenovo = jogaDenovo;
	}

	public int getId() {
		return id;
	}

	public void incrementarNumJogadas() {
		numJogadas++;
	}

	public int getNumJogadas() {
		return numJogadas;
	}

	public int getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}

	public void exibirInfo() {
		System.out
				.println(getColor() + " na casa " + getPosition() + ". Jogador possui " + getNumMoedas() + " moedas.");
	}

	public void setNumJogadas(int numJogadas) {
		this.numJogadas = numJogadas;
	}

	public void setNumMoedas(int numMoedas) {
		this.numMoedas = numMoedas;
	}

}
