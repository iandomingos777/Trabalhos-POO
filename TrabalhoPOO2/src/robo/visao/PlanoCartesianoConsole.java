package robo.visao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import robo.modelo.Obstaculo;
import robo.modelo.PlanoCartesiano;
import robo.modelo.Robo;
import robo.modelo.RoboInteligente;

public class PlanoCartesianoConsole {

	private PlanoCartesiano plano;

	Scanner entrada = new Scanner(System.in);

	public PlanoCartesianoConsole(int x, int y) {
		// TODO Auto-generated constructor stub
		plano = new PlanoCartesiano(x, y);

	}

	public void jogarMain1() {

		RoboInteligente robo = new RoboInteligente("Verde");

		plano.addRoboNoPlano(robo);

		while (!plano.verificarVitoria()) {

			System.out.println(plano);

			System.out.println("1 - Up. 2 - Down. 3 - Right. 4 - Left");
			System.out.print("Jogada: ");
			String move = entrada.nextLine();
			int moveInt = 0;
			if (move.equals("1") || move.equals("2") || move.equals("3") || move.equals("4")) {
				moveInt = Integer.parseInt(move);
			}
			System.out.println();
			if (moveInt == 1 || moveInt == 2 || moveInt == 3 || moveInt == 4)
				plano.moverNoCampo(robo, moveInt);
			else if (move.equalsIgnoreCase("up") || move.equalsIgnoreCase("down") || move.equalsIgnoreCase("left")
					|| move.equalsIgnoreCase("right"))
				plano.moverNoCampo(robo, move.toLowerCase());
			else
				System.out.println("Inválido");

			System.out.println();

		}
		System.out.println(plano);
		System.out.println();
		Robo vencedor = plano.getCampos().get(plano.getFoodY()).get(plano.getFoodX()).getRobos().get(0);
		System.out.println(vencedor.getCor().toUpperCase() + " VENCEU !");
		entrada.close();

	}

	public void jogarMain2() {
		Robo[] robos = new Robo[2];
		robos[0] = new Robo("Amarelo");
		robos[1] = new Robo("Verde");
		plano.addRoboNoPlano(robos[0]);
		plano.addRoboNoPlano(robos[1]);

		int vez = 0;

		System.out.println(plano);
		while (!plano.verificarVitoria()) {
			if (vez == 2) {
				vez = 0;
			}
			int random = ThreadLocalRandom.current().nextInt(1, 5);
			plano.moverNoCampo(robos[vez], random);
			System.out.println(plano);
			try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			vez++;
		}

		Robo vencedor = plano.getCampos().get(plano.getFoodY()).get(plano.getFoodX()).getRobos().get(0);
		System.out.println(vencedor.getCor().toUpperCase() + " VENCEU :)");
		System.out.println("Jogadas validas: " + vencedor.getMovimentosValidos());
		System.out.println("Jogadas invalidas: " + vencedor.getMovimentosInvalidos());
		System.out.println();

		Robo perdedor;
		if (robos[0] == vencedor) {
			perdedor = robos[1];
		} else {
			perdedor = robos[0];
		}
		System.out.println(perdedor.getCor().toUpperCase() + " PERDEU :(");
		System.out.println("Jogadas validas: " + perdedor.getMovimentosValidos());
		System.out.println("Jogadas invalidas: " + perdedor.getMovimentosInvalidos());
	}

	public void jogarMain3() {
		Robo[] robos = new Robo[2];
		robos[0] = new Robo("Amarelo");
		robos[1] = new RoboInteligente("Verde");
		plano.addRoboNoPlano(robos);
		System.out.println("Robo Amarelo é Comum");
		System.out.println("Robo Verde é inteligente");
		System.out.println();
		System.out.println(plano);
		ArrayList<Robo> robosFood = plano.getCampos().get(plano.getFoodY()).get(plano.getFoodX()).getRobos();
		while (robosFood.size() != 2) {
			for (int i = 0; i < 2; i++) {
				if (robosFood.isEmpty() || !(robosFood.get(0) == robos[i])) {
					int random = ThreadLocalRandom.current().nextInt(1, 5);
					plano.moverNoCampo(robos[i], random);
					System.out.println(plano);
					try {
						Thread.sleep(000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println();
		}

		System.out.println("Movimentos do Robo Comum: ");
		System.out.println("Movimentos Validos: " + robos[0].getMovimentosValidos());
		System.out.println("Movimentos Invalidos: " + robos[0].getMovimentosInvalidos());
		System.out.println();

		int movimentosvalidosinteligente = robos[1].getMovimentosValidos() - robos[1].getMovimentosInvalidos();
		System.out.println("Movimentos do Robo Inteligente:");
		System.out.println("Movimentos Validos: " + movimentosvalidosinteligente);
		System.out.println("Movimentos Invalidos: " + robos[1].getMovimentosInvalidos());
		System.out.println();

	}

	public void jogarMain4(Obstaculo[]... obstaculos) {

		for (Obstaculo[] array : obstaculos) {
			for (Obstaculo obstaculo : array) {
				plano.addObstaculoNoPlano(obstaculo);
			}
		}

		ArrayList<Robo> robos = new ArrayList<>();
		robos.add(new Robo("Amarelo"));
		robos.add(new RoboInteligente("Verde"));
		plano.addRoboNoPlano(robos.get(0), robos.get(1));
		System.out.println("\nRobo Amarelo é Comum");
		System.out.println("Robo Verde é inteligente");
		System.out.println();
		System.out.println(plano);
		ArrayList<Robo> robosFood = plano.getCampos().get(plano.getFoodY()).get(plano.getFoodX()).getRobos();
		while (robosFood.size() != 1 && !(robos.get(0).getPosX() == -1 && robos.get(0).getPosY() == -1
				&& robos.get(1).getPosX() == -1 && robos.get(1).getPosY() == -1)) {
			for (int i = 0; i < robos.size(); i++) {
				if (robos.get(i).getPosX() != -1 && robos.get(i).getPosY() != -1 || plano.verificarVitoria()) {
					int random = ThreadLocalRandom.current().nextInt(1, 5);
					plano.moverNoCampo(robos.get(i), random);
					System.out.println(plano);
					try {
						Thread.sleep(000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println();
		}

		System.out.println("Movimentos do Robo Comum: ");
		System.out.println("Movimentos Validos: " + robos.get(0).getMovimentosValidos());
		System.out.println("Movimentos Invalidos: " + robos.get(0).getMovimentosInvalidos());
		System.out.println();

		int movimentosvalidosinteligente = robos.get(1).getMovimentosValidos() - robos.get(1).getMovimentosInvalidos();
		System.out.println("Movimentos do Robo Inteligente:");
		System.out.println("Movimentos Validos: " + movimentosvalidosinteligente);
		System.out.println("Movimentos Invalidos: " + robos.get(1).getMovimentosInvalidos());
		System.out.println();
	}
}
