package jogo2.modelo;

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
		default:
			return null;
		}
	}
}
