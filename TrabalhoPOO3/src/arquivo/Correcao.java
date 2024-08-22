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
		try {
			d1.gerarDados();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.calcularMedia();
		try {
			d1.criarArquivoEmOrdemAlfabetica();
			d1.criarArquivoEmOrdemDeAcertos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
