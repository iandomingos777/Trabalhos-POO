package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {
	
	private String nome;
	private int numAlunos;
	private double media;
	private String caminhoGabaritoOficial;
	private ArrayList<Aluno> alunos;
	private File diretorio;
	
	public Disciplina(String nome) {
		this.nome = nome;
		this.alunos = new ArrayList<>();
		this.diretorio = new File("C:\\Users\\Vitor\\desktop\\" + nome);
		diretorio.mkdir();
	}
	
	public void cadastrarGabaritoOficial() throws IOException {
		File gabaritoOficial = new File(diretorio, "gabarito.txt");
		FileWriter registrarGabarito = new FileWriter(gabaritoOficial);
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira a sequência das respostas: ");
		String gabarito = scan.next();
		registrarGabarito.write(gabarito);
		registrarGabarito.close();
		scan.close();
	}
	
	public void registrarGabaritoAluno() {
		
	}
	
}
