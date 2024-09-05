package jogo2.modelo;

public class CasaTroca extends Casa{

	public CasaTroca(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
      System.out.println("Deseja trocar suas moedas por:");
      System.out.println("1 - Boné 2 - Moletom 3 - Óculos 4 - Não trocar");
      int opc;
      switch(opc) {
      case 1:
    	  if(jogador.getAcessorios.size() == 0  && jogador.decrementarNumMoedas(1)) {
    		  System.out.println(jogador + "comprou um boné");
    		  jogador = new JogadorComBoné(jogador);
    	  }else {
    		  System.
    	  }
      }
	}

}