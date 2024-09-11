package jogo2.modelo.casa;

import jogo2.modelo.Jogo;
import jogo2.modelo.Tabuleiro;
import jogo2.modelo.decorator.JogadorComBoné;
import jogo2.modelo.decorator.JogadorComMoletom;
import jogo2.modelo.decorator.JogadorComOculos;
import jogo2.modelo.jogador.Jogador;

public class CasaTroca extends Casa {

	String strColor;

	public CasaTroca(int posiçao) {
		super(posiçao);
		strColor = "\u001B[30m"; // preto
	}

	@Override
	public void aplicarRegra(Jogador jogador) {

		if (jogador instanceof JogadorComOculos) {
			System.out.println("Jogador no auge.");
			return;
		}

		int opc;

		System.out.print("Deseja trocar suas moedas por ");
		if (jogador instanceof JogadorComMoletom) {
			System.out.println("óculos por 7 moedas?");
			opc = 3;
		} else if (jogador instanceof JogadorComBoné) {
			System.out.println("moletom por 4 moedas?");
			opc = 2;
		} else {
			System.out.println("boné por 1 moeda?");
			opc = 1;
		}
		int escolha = 0;
		do {
			System.out.println("1 - Sim.\n2 - Não");
			escolha = Jogo.scanner.nextInt();
		} while (!(escolha == 1 || escolha == 2));

		if (escolha == 2)
			return;

		Tabuleiro.getCasas().get(posiçao).remJogador(jogador);

		Jogador jogadorDecorado = jogador;

		switch (opc) {
		case 1:
			if (!(jogador instanceof JogadorComBoné) && jogador.decrementarNumMoedas(1)) {
				System.out.println(jogador.getColor() + " comprou um boné");
				jogadorDecorado = new JogadorComBoné(jogador);
			} else {
				System.out.println("Operação não pode ser realizada");
			}
			break;
		case 2:
			if (jogador instanceof JogadorComBoné && jogador.decrementarNumMoedas(4)) {
				System.out.println(jogador.getColor() + " comprou um moletom");
				jogadorDecorado = new JogadorComMoletom(jogador);
			} else {
				System.out.println("Operação não pode ser realizada");
			}
			break;
		case 3:
			if (jogador instanceof JogadorComMoletom && jogador.decrementarNumMoedas(7)) {
				System.out.println(jogador.getColor() + " comprou um óculos");
				jogadorDecorado = new JogadorComOculos(jogador);
			} else {
				System.out.println("Operação não pode ser realizada");
			}
			break;
		default:
			System.out.println("Nenhuma compra foi realizada");
		}

		jogadorDecorado.receberAtributos(jogador, jogadorDecorado);

		int index = Tabuleiro.getJogadores().indexOf(jogador);
		if (index != -1) {
			Tabuleiro.getJogadores().set(index, jogadorDecorado);
		}

		Tabuleiro.getCasas().get(posiçao).addJogador(jogadorDecorado);
	}

	public String toString() {
		return super.toString(strColor);
	}

}