package robo.modelo;

import java.util.ArrayList;

public class PlanoCartesiano {
	private int dimX;
	private int dimY;
	private int foodX;
	private int foodY;
	private ArrayList<Robo> robos;

	public PlanoCartesiano(int foodX, int foodY) {
		this.foodX = foodX;
		this.foodY = foodY;
		this.dimX = foodX;
		this.dimY = foodY;
		robos = new ArrayList<Robo>();
	}

	public PlanoCartesiano(int foodX, int foodY, Robo robo1, Robo robo2) {
		this.foodX = foodX;
		this.foodY = foodY;
		robos = new ArrayList<Robo>();
		robos.add(robo1);
		robos.add(robo2);
		dimX = Math.max(foodX, Math.max(robo1.getPosX(), robo2.getPosX()));
		dimY = Math.max(foodY, Math.max(robo1.getPosY(), robo2.getPosY()));
	}
	
	public void expandirX() {
		dimX++;
	}
	
	public void expandirY() {
	   dimY++;	
	}
	
	public boolean verificarVitoria(Robo robo) {
		if(robo.getPosX == foodX && robo.getPosY == foodY)
		{
			return true;
		}
		return false;
	}
}
