package jogo2.modelo.casa;

import jogo2.modelo.Jogo;
import jogo2.modelo.Tabuleiro;
import jogo2.modelo.decorator.JogadorComBoné;
import jogo2.modelo.decorator.JogadorComMoletom;
import jogo2.modelo.decorator.JogadorComOculos;
import jogo2.modelo.jogador.Jogador;

public class CasaTroca extends Casa {

	public CasaTroca(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Deseja trocar suas moedas por:");
		System.out.println("1 - Boné 2 - Moletom 3 - Óculos 4 - Não trocar");
		int opc;
		opc = Jogo.scanner.nextInt();
		Tabuleiro.getCasas().get(posiçao).remJogador(jogador);
		switch (opc) {
		case 1:
			if (!(jogador instanceof JogadorComBoné) && jogador.decrementarNumMoedas(1)) {
				System.out.println(jogador + "comprou um boné");
				jogador = new JogadorComBoné(jogador);
			} else {
				System.out.println("Operação não pode ser realizada");
			}
			break;
		case 2:
			if (jogador instanceof JogadorComBoné && !(jogador instanceof JogadorComMoletom)
					&& jogador.decrementarNumMoedas(4)) {
				System.out.println(jogador + "comprou um moletom");
				jogador = new JogadorComMoletom(jogador);
			} else {
				System.out.println("Operação não pode ser realizada");
			}
			break;
		case 3:
			if (jogador instanceof JogadorComMoletom && !(jogador instanceof JogadorComOculos)
					&& jogador.decrementarNumMoedas(7)) {
				System.out.println(jogador + "comprou um óculos");
				jogador = new JogadorComOculos(jogador);
			} else {
				System.out.println("Operação não pode ser realizada");
			}
			break;
		case 4:
			System.out.println("Nenhuma compra foi realizada");
		};
		Tabuleiro.getCasas().get(posiçao).addJogador(jogador);
	}
	

}