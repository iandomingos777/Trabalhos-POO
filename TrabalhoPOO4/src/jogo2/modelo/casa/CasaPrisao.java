package jogo2.modelo.casa;

import jogo2.modelo.Jogo;
import jogo2.modelo.jogador.Jogador;

public class CasaPrisao extends Casa{
	
	String strColor;

	
	public CasaPrisao(int posiçao) {
		super(posiçao);
		strColor = "\u001B[35m"; // magenta
	}

	@Override
	public void aplicarRegra(Jogador jogador) {
	   switch(jogador.getRodadasConsecutivasPreso()){
	   case 0:
		System.out.println("Jogador foi preso");
		jogador.setArrested(true);
	    jogador.setRodadasConsecutivasPreso(1);
	    break;
	   case 1:
	   System.out.println("1 - Pagar fiança 2 - continuar preso");
	   int opc = 0;
	   while(opc != 1 && opc!= 2) {
		   opc = Jogo.scanner.nextInt();
	   }
	   if(opc == 1 && jogador.pagarFianca()) {
		   System.out.println("Fiança paga com sucesso");
		   jogador.setArrested(false);
		   jogador.setRodadasConsecutivasPreso(0);
	   }else {
		   System.out.println("Jogador permanece preso");
		   jogador.setRodadasConsecutivasPreso(2);
	   }
	   break;
	   case 2:
		   System.out.println("Jogador foi liberado");
		   jogador.setArrested(false);
		   jogador.setRodadasConsecutivasPreso(0);
	   };
      }
	
	public String toString() {
		return super.toString(strColor);
	}

}
