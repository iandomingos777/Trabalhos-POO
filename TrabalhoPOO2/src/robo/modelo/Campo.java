package robo.modelo;

import java.util.ArrayList;

public class Campo {
	private int posX;
	private int posY;
	private boolean estaOcupado = false;
	private ArrayList<Robo> robos = new ArrayList<Robo>();

	public Campo(int posY, int posX) {
		this.posX = posX;
		this.posY = posY;
	}

	public void addRobo(Robo robo)
	{
		robos.add(robo);
		estaOcupado = true;
	}

	public void remRobo(Robo robo) {
		for(int i = 0; i < robos.size(); i++) {
			if(robos.get(i).getCor().equals(robo.getCor())) {
				robos.remove(i);
			}
		}
		if(robos.isEmpty()) {
			estaOcupado = false;
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public boolean isEstaOcupado() {
		return estaOcupado;
	}

	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public String toString() {
		if(robos.size() == 2)
		{
			return "["+robos.get(0).toString() + " " 
					+ robos.get(1).toString() +"]";
		}else if(robos.size() == 1) {
			return "[ " + robos.get(0) + " ]";
		}
		return "[   ]";
	}
}
