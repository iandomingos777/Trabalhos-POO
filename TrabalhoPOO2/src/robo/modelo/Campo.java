package robo.modelo;

import java.util.ArrayList;

public class Campo {
	private int posX;
	private int posY;
	private boolean eAlimento;
	private boolean estaOcupado;
	private ArrayList<Robo> robos = new ArrayList<Robo>();
	private Obstaculo obstaculo;

	public Campo(int posY, int posX) {
		this.posX = posX;
		this.posY = posY;
		estaOcupado = false;
		eAlimento = false;
		obstaculo = null;
	}

	public boolean isOcupado() {
		return estaOcupado;
	}

	public void addRobo(Robo robo) {
		robos.add(robo);
		estaOcupado = true;
	}
	
	public void setObstaculo(Obstaculo obstaculo) {
		this.obstaculo = obstaculo;
	}
	
	

	public Obstaculo getObstaculo() {
		return obstaculo;
	}

	public void remRobo(Robo robo) {
		for (int i = 0; i < robos.size(); i++) {
			if (robos.get(i).getCor().equals(robo.getCor())) {
				robos.remove(i);
			}
		}
		if (robos.isEmpty()) {
			estaOcupado = false;
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public void colocarAlimento() {
		eAlimento = true;
	}
	
	public void baterEmObstaculo() {
		if(obstaculo instanceof Bomba) {
			for(Robo r : robos) {
				obstaculo.bater(r);
				remRobo(r);
				obstaculo = null;
			}
		}
		else if(obstaculo instanceof Rocha) {
			for(Robo r : robos) {
				obstaculo.bater(r);
			}
		}
	}

	public String toString() {
		String redColor = "\u001B[31m";
		String grayColor = "\u001B[37m ";
		String goldColor = "\u001B[38;5;136m";

		String trofeu = "\uD83C\uDFC6";
		String dot = "⚫";
		String apple = "\uD83C\uDF4E";
        String bomba = "\uD83D\uDCA3";
        String pedra = "\uD83E\uDEA8"; 
		String resetColor = "\u001B[0m";

		if(obstaculo != null) {
		return "[ "+ obstaculo + " ]";
		}
		if (eAlimento) {
			if (estaOcupado) {
				if (robos.size() == 1) {
					return "[" + robos.get(0) + " " + goldColor + trofeu + resetColor + "]";
				} else {
					return "[" + robos.get(0) + goldColor + trofeu + resetColor + robos.get(1) + "]";
				}
			}
			return "[ " + redColor + apple + resetColor + " ]";
		}

		else if (robos.size() == 2) {
			return "[" + robos.get(0) + " " + robos.get(1) + "]";
		}

		else if (robos.size() == 1) {
			return "[ " + robos.get(0) + " ]";
		}

		return "[" + grayColor + dot + resetColor + " ]";
	}
}
