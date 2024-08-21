package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {

	private String nome;
	private int numAlunos;
	private double media;
	private String caminhoGabaritoOficial;
	private String gabarito;
	private ArrayList<Aluno> alunos;
	private static File diretorio;
	Scanner scan = new Scanner(System.in);

	public Disciplina(String nome) {
		this.nome = nome;
		this.alunos = new ArrayList<>();
		numAlunos = 0;
		diretorio = new File("C:\\Users\\ianbr\\teste\\" + nome);
		diretorio.mkdir();
	}

	public void cadastrarGabaritoOficial() throws IOException {
		File gabaritoOficial = new File(diretorio, "gabarito.txt");
		FileWriter registrarGabarito = new FileWriter(gabaritoOficial);
		String sequenciaGabarito = "";
		while (!validarSequencia(sequenciaGabarito)) {
			System.out.println("Insira a sequência das respostas: ");
			sequenciaGabarito = scan.nextLine();
		}
		sequenciaGabarito = sequenciaGabarito.toUpperCase();
		gabarito = sequenciaGabarito;
		registrarGabarito.write(sequenciaGabarito);
		registrarGabarito.close();
		caminhoGabaritoOficial = gabaritoOficial.getAbsolutePath();
	}

	public boolean registrarGabaritoAluno() throws IOException {
		File respostaAlunos = new File(diretorio, nome + ".txt");
		System.out.println("Insira a sequência de respostas e o nome do aluno: ");
		String sequenciaRespostas = scan.next();
		if (sequenciaRespostas.equalsIgnoreCase("sair") || sequenciaRespostas.equals("-1")) {
			return false;
		}
		String nome = scan.next();
		StringBuilder sb = new StringBuilder();
		sb.append(sequenciaRespostas.toUpperCase()).append("\t").append(nome.toUpperCase()).append("\n");
		FileWriter registrarAluno = new FileWriter(respostaAlunos, true);
		registrarAluno.write(sb.toString());
		registrarAluno.close();
		numAlunos++;
		return true;
	}

	public void registrarClasse() {
		System.out.println("Digite '-1' ou 'sair' para parar o registro.");
		while (true) {
			try {
				if (!registrarGabaritoAluno()) {
					scan.close();
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Turma registrada com sucesso!");
	}

	private boolean validarSequencia(String seq) {
		
		seq =seq.toUpperCase();
		int numF = 0;
		int numV = 0;
		if (seq.length() != 10) {
			return false;
		}
		for (int i = 0; i < 10; i++) {
			char c = seq.charAt(i);
			if (c == 'V') {
				numV++;
			} else if (c == 'F') {
				numF++;
			} else {
				return false;
			}
		}

		if (numF == 10 || numV == 10) {
			return false;
		}
		return true;
		
	}

	public void calcularMedia() {
		int total = 0;		
		for (Aluno al : alunos) {
			total += al.getNumAcertos();
		}
		media = total / numAlunos;
	}

	public void criarArquivoEmOrdemAlfabetica() throws IOException {
		File arq = new File(diretorio, "Notas_em_ordem_alfabetica.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(arq, true));
	}

	public void gerarDados(String endereco) throws IOException {
		File arq = new File(endereco);
		BufferedReader br = new BufferedReader(new FileReader(arq));
		String linha = br.readLine();
		while (linha != null) {
			String[] dados = linha.split("\t");
			alunos.add(new Aluno(dados[1], dados[0]));
			linha = br.readLine();
		}
		br.close();
		registrarAcertos();
	}
	
	private void registrarAcertos() {
		for (Aluno al : alunos) {
			int length = 10;
			int acertos = 0;
			int numV = 0;
			int numF = 0;
			for (int i = 0; i < length; i++) {
				char resposta = al.getRespostas().charAt(i);
				if (gabarito.charAt(i) == resposta) {
					acertos++;
					if (resposta == 'F') {
						numF++;
					} else {
						numV++;
					}
				}
			}
			if (numV == gabarito.length() || numF == gabarito.length()) {
				al.setNumAcertos(0);
				return;
			}
			al.setNumAcertos(acertos);
		}
	}
}
