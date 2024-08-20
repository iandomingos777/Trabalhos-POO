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
		try {
			cadastrarGabaritoOficial();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrarGabaritoOficial() throws IOException {
		File gabaritoOficial = new File(diretorio, "gabarito.txt");
		FileWriter f = new FileWriter(gabaritoOficial);
		Scanner scan = new Scanner(System.in);
		String gabarito = scan.next();
		f.write(gabarito);
		f.close();
		scan.close();
	}
	
	public void registrarGabaritoAluno() {
		
	}
	
}
