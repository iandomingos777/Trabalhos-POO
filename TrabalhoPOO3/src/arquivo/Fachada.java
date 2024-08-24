package arquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fachada {
	
	ArrayList<Disciplina> disciplinas = new ArrayList<>();
	static int numDisciplinas = 0;
	
	public void execução() throws IOException {
		Disciplina disciplina;
		
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("1 - Criar disciplina\n2 - Exibir resultados de uma disciplina\n3 - Sair"); 
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
			case 1: 
				System.out.println("Digite o nome da disciplina: ");
				String nomeDisciplina = input.nextLine();
				disciplina = new Disciplina(nomeDisciplina);
				disciplina.cadastrarGabaritoOficial();
				disciplina.registrarClasse();
				disciplina.gerarDados();
				disciplina.criarArquivoEmOrdemAlfabetica();
				disciplina.criarArquivoEmOrdemDeAcertos();
				disciplinas.add(disciplina);
				numDisciplinas++;
				break;
			case 2: 
				System.out.println("Digite o nome da disciplina: ");
				String disciplinaBuscada = input.nextLine();
				boolean disciplinaExiste = false;
				for(Disciplina dis : disciplinas) {
					if(disciplinaBuscada.equalsIgnoreCase(dis.getNome())) {
						dis.exibirResultado();
						disciplinaExiste = true;
					}
				}
				if(!disciplinaExiste) System.out.println("Disciplina não encontrada\n");
				break;
			case 3:
				if (numDisciplinas == 1) System.out.println("1 disciplina foi cadastrada!");
				else System.out.println(numDisciplinas + " disciplinas foram cadastradas!");
				break;
			default: 
				System.out.println("Opção inválida.");
			}
		}
		input.close();
		Disciplina.scan.close();
	}
	
}
