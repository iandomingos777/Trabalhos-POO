package jogo2.modelo.factory;

import jogo2.modelo.casa.Casa;
import jogo2.modelo.casa.CasaAzar;
import jogo2.modelo.casa.CasaJogaDeNovo;
import jogo2.modelo.casa.CasaPrisao;
import jogo2.modelo.casa.CasaReversa;
import jogo2.modelo.casa.CasaSimples;
import jogo2.modelo.casa.CasaSorte;
import jogo2.modelo.casa.CasaSurpresa;
import jogo2.modelo.casa.CasaTroca;

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
