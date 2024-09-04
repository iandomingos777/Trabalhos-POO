package jogo.modelo;

public class CasaPrisao extends Casa{

	
	public CasaPrisao(int posiçao) {
		super(posiçao);
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
      if(jogador.isArrested()) {
    	  System.out.println("Deseja pagar duas moedas para ser liberado?");
    	  if(jogador.setNumMoedas(jogador.getNumMoedas - 1)) {
    		  System.out.println("Jogador foi liberado");
    		  jogador.setArrested(false);
    		  jogador.jogarDados();
    	  }else {
    		  System.out.println("Não foi possível pagar a taxa");
    		  return;
    	  }
      }else {
		  System.out.println("Jogador foi preso");
		  jogador.setArrested(true);
      }
	}

}
