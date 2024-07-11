package robo.modelo;

import java.util.ArrayList;

public class PlanoCartesiano {
	
	private int dimX;
	private int dimY;
	private int foodX;
	private int foodY;
	
	private ArrayList<ArrayList<Campo>> campos = new ArrayList<ArrayList<Campo>>();

	public PlanoCartesiano(int foodY, int foodX) {
		if (foodX > 0 && foodY > 0) {
			this.foodY = foodY;
			this.foodX = foodX;
			this.dimX = foodX;
			this.dimY = foodY;
			for (int i = 0; i < dimY; i++) {
				campos.add(new ArrayList<Campo>());
				for (int j = 0; j < dimX; j++) {
					campos.get(i).add(new Campo(i + 1, j + 1));
				}
			}
		}
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

	public void expandirY() {
		dimY++;
		campos.add(new ArrayList<Campo>());
		for (int j = 0; j < dimX; j++) {
			campos.get(dimY - 1).add(new Campo(dimY, j + 1));
		}
	}

	public void expandirX() {
		dimX++;
		for (int i = 0; i < dimY; i++) {
			campos.get(i).add(new Campo(i + 1, dimX));
		}

	}

	public boolean verificarVitoria(Robo robo) {
		if (robo.getPosX() == foodX && robo.getPosY() == foodY) {
			return true;
		}
		return false;
	}

	public void imprimirCampos() {
		for (int i = 0; i < dimY; i++) {
			for (int j = 0; j < dimX; j++) {
				System.out.print(campos.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dimY; i++) {
			sb.append((dimY - i) + " ");
			for (int j = 0; j < dimX; j++) {
				sb.append(campos.get(i).get(j) + " ");
			}
			sb.append("\n");
		}
		sb.append("  ");
		for (int j = 1; j <= dimX; j++) {
			sb.append("  " + j + "  ");
			sb.append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}

}
