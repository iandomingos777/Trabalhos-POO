package arquivo;

import java.io.IOException;
import java.util.Scanner;

public class Correcao {

	public void comecar() {
		int opc = 0;
		Scanner sc = new Scanner(System.in);
		while (opc != 3) {
			System.out.println("1 - Criar disciplina 2 - Gerar resultados 3 - Sair");
			opc = sc.nextInt();
			try {
			switch (opc) {
			case 1:
				System.out.println("Informe o nome da disciplina");
				String nome = sc.nextLine();
				Disciplina d = new Disciplina(nome);
				d.cadastrarGabaritoOficial();
				d.registrarClasse();
				break;
			case 2:
				System.out.println("Informe o nome da disciplina");
				String name =sc.nextLine();
				Disciplina dis = new Disciplina(name);
				System.out.println("Informe o endereço do gabarito");
              break;
			}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
