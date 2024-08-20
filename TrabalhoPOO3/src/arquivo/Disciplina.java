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
	private static File diretorio;
	
	public Disciplina(String nome) {
		this.nome = nome;
		this.alunos = new ArrayList<>();
		diretorio = new File("C:\\Users\\Vitor\\desktop\\" + nome);
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
		
	}
	
	public void registrarGabaritoAluno() throws IOException {
		File respostaAlunos = new File(diretorio, nome + ".txt");
		FileWriter registrarAluno = new FileWriter(respostaAlunos, true);
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira a sequência de respostas e o nome do aluno: ");
		String sequenciaRespostas = scan.next();
		String nome = scan.next();
		registrarAluno.write(sequenciaRespostas);
		registrarAluno.write("\t");
		registrarAluno.write(nome);
		registrarAluno.write("\n");
		registrarAluno.close();
		
	}
	
}
