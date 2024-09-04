package jogo2.modelo;

public class CasaAzar extends Casa{

	public CasaAzar(int posiçao) {
		super(posiçao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
     if(jogador instanceof JogadorSortudo) {
    	 System.out.println("Jogador é sortudo: não perde as 3 moedas");
    	 return;
     }
     System.out.println("Jogador perde 3 moedas");
     jogador.setNumMoedas(jogador.getNumMoedas() - 3);
	}

}
