package robo.modelo;

import java.util.ArrayList;

import robo.excecao.MovimentoInvalidoException;

public class PlanoCartesiano {

	private int dimX = 4;
	private int dimY = 4;
	private int foodX;
	private int foodY;

	private ArrayList<ArrayList<Campo>> campos = new ArrayList<ArrayList<Campo>>();

	private void criarCampos() {
		for (int i = 0; i <= dimY; i++) {
			campos.add(new ArrayList<Campo>());
			for (int j = 0; j <= dimX; j++) {
				campos.get(i).add(new Campo(i, j));
			}
		}
	}

	public PlanoCartesiano(int foodX, int foodY) {
		if (!(foodX <= 0 && foodY <= 0)) {

			if (foodY > 4) {
				foodY = 4;
			}
			if (foodX > 4) {
				foodX = 4;
			}

			this.foodY = foodY;
			this.foodX = foodX;
			criarCampos();
			campos.get(foodY).get(foodX).colocarAlimento();
		}
	}

	public void addRoboNoPlano(Robo... robos) {
		for (Robo robo : robos) {
			campos.get(0).get(0).addRobo(robo);
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

	public ArrayList<ArrayList<Campo>> getCampos() {
		return campos;
	}

	public void moverNoCampo(Robo robo, int i) {
		int iniX = robo.getPosX();
		int iniY = robo.getPosY();
		try {
			campos.get(robo.getPosY()).get(robo.getPosX()).remRobo(robo);
			robo.moverRobo(i);
			robo.setMovimentosValidos(robo.getMovimentosValidos() + 1);
			Campo campo = campos.get(robo.getPosY()).get(robo.getPosX());
			campo.addRobo(robo);
			campo.baterEmObstaculo(robo);

		} catch (MovimentoInvalidoException e) {
			robo.setPosX(iniX);
			robo.setPosY(iniY);
			campos.get(iniY).get(iniX).addRobo(robo);
			if (e.getMessage().equals("Bateu na rocha")
					|| (robo instanceof RoboInteligente && ((RoboInteligente) robo).isCurrentException())) {
				if (robo instanceof RoboInteligente) {
					if (((RoboInteligente) robo).isCurrentException()) {
						int x = ((RoboInteligente) robo).getUltimoMovimento();
						robo.moverRobo(x);
					} else
						((RoboInteligente) robo).setCurrentException(true);
				}

				return;
			}
			System.out.println("\u001B[31m" + robo.getCor() + " - " + e.getMessage() + "\u001B[0m" + "\n");
			if (!(robo instanceof RoboInteligente)) {
				robo.setMovimentosInvalidos(robo.getMovimentosInvalidos() + 1);
			}
		} finally {
			System.out.println(robo.getCor().toUpperCase());
			if (robo.getPosX() == -1 && robo.getPosY() == -1) {
				System.out.println("EXPLODIU");
			} else {
				System.out.println("A posição X é: " + robo.getPosX());
				System.out.println("A posição Y é: " + robo.getPosY());
			}
		}

	}

	public void moverNoCampo(Robo robo, String str) {
		int iniX = robo.getPosX();
		int iniY = robo.getPosY();
		try {
			campos.get(robo.getPosY()).get(robo.getPosX()).remRobo(robo);
			robo.moverRobo(str);
		} catch (MovimentoInvalidoException e) {
			System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
			robo.setPosX(iniX);
			robo.setPosY(iniY);
		}
	}

	public boolean verificarVitoria() {
		if (campos.get(foodY).get(foodX).isOcupado()) {
			return true;
		}
		return false;
	}

	public void addObstaculoNoPlano(Obstaculo obstaculo) {
		campos.get(obstaculo.getPosY()).get(obstaculo.getPosX()).setObstaculo(obstaculo);
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (int i = dimY; i >= 0; i--) {
			sb.append(i + " ");
			for (int j = 0; j <= dimX; j++) {
				sb.append(campos.get(i).get(j) + " ");
			}
			sb.append("\n");
		}
		sb.append("  ");
		for (int j = 0; j <= dimX; j++) {
			sb.append("   " + j + "  ");
			sb.append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}

}
