package robo.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class PlanoCartesiano {
	@SuppressWarnings("unused")
	private int dimX;
	@SuppressWarnings("unused")
	private int dimY;
	private int foodX;
	private int foodY;
	private ArrayList<Robo> robos = new ArrayList<Robo>();

	public PlanoCartesiano(int foodX, int foodY) {
		this.foodX = foodX;
		this.foodY = foodY;
		this.dimX = foodX;
		this.dimY = foodY;
	}
	
	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public int getFoodX() {
		return foodX;
	}

	public int getFoodY() {
		return foodY;
	}
	
	public ArrayList<Robo> getRobos() {
		return robos;
	}

	public void adicionarRobos(Robo... robos) {
		this.robos.addAll(Arrays.asList(robos));
	}
	
	public void expandirX() {
		dimX++;
	}
	
	public void expandirY() {
	   dimY++;	
	}
	
	public boolean verificarVitoria(Robo robo) {
		if(robo.getPosX() == foodX && robo.getPosY() == foodY)
		{
			return true;
		}
		return false;
	}
}
