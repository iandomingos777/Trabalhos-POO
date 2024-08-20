package arquivo;

import java.io.IOException;

public class Correcao {

	public void comecar() {
		Disciplina d1 = new Disciplina("POO");
		try {
			d1.cadastrarGabaritoOficial();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.registrarClasse();
	}
	
}
