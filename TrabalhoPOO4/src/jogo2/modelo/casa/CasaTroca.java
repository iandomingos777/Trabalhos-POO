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
        System.out.println("Deseja trocar suas moedas por:");
        System.out.println("1 - Boné 2 - Moletom 3 - Óculos 4 - Não trocar");
        int opc;
        opc = Jogo.scanner.nextInt();
        Tabuleiro.getCasas().get(posiçao).remJogador(jogador);

        Jogador jogadorDecorado = jogador;

        switch (opc) {
            case 1:
                if (!(jogador instanceof JogadorComBoné)) {
                    System.out.println(jogador + " comprou um boné");
                    jogadorDecorado = new JogadorComBoné(jogador);
                } else {
                    System.out.println("Operação não pode ser realizada");
                }
                break;
            case 2:
                if (jogador instanceof JogadorComBoné) {
                    System.out.println(jogador + " comprou um moletom");
                    jogadorDecorado = new JogadorComMoletom(jogador);
                } else {
                    System.out.println("Operação não pode ser realizada");
                }
                break;
            case 3:
                if (jogador instanceof JogadorComMoletom) {
                    System.out.println(jogador + " comprou um óculos");
                    jogadorDecorado = new JogadorComOculos(jogador);
                } else {
                    System.out.println("Operação não pode ser realizada");
                }
                break;
            case 4:
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