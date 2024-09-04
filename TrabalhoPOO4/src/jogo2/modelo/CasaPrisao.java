package jogo2.modelo;

public class CasaPrisao extends Casa{

	
	public CasaPrisao(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
		System.out.println("Jogador foi preso");
		jogador.setArrested(true);
      }

}
