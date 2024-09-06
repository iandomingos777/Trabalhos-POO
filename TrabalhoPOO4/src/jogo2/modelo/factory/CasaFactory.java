package jogo2.modelo.factory;

import jogo2.modelo.Casa;
import jogo2.modelo.CasaAzar;
import jogo2.modelo.CasaJogaDeNovo;
import jogo2.modelo.CasaPrisao;
import jogo2.modelo.CasaReversa;
import jogo2.modelo.CasaSimples;
import jogo2.modelo.CasaSorte;
import jogo2.modelo.CasaSurpresa;
import jogo2.modelo.CasaTroca;

public class CasaFactory {
	public static Casa criarCasa(int opc, int posiçao) {
		switch (opc) {
		case 1:
			return new CasaSimples(posiçao);
		case 2:
			return new CasaAzar(posiçao);
		case 3:
			return new CasaJogaDeNovo(posiçao);
		case 4:
			return new CasaPrisao(posiçao);
		case 5:
			return new CasaSorte(posiçao);
		case 6:
			return new CasaSurpresa(posiçao);
		case 7:
			return new CasaTroca(posiçao);
		case 8:
			return new CasaReversa(posiçao);
		default:
			return null;
		}
	}
}
