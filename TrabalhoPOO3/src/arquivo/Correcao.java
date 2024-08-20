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
		for(int i = 0; i < 3; i++) {
			try {
				d1.registrarGabaritoAluno();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
