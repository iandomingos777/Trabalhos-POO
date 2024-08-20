package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Disciplina {
	
	private String nome;
	private int numAlunos;
	private double media;
	private String caminhoGabaritoOficial;
	private String gabarito;
	private ArrayList<Aluno> alunos;
	private static File diretorio;
	
	public Disciplina(String nome) {
		this.nome = nome;
		this.alunos = new ArrayList<>();
		diretorio = new File("C:\\Users\\Vitor\\desktop\\" + nome);
		diretorio.mkdir();
	}
	
	private boolean validarSequencia(String seq) {
		int numF = 0;
		int numV = 0;
		if(seq.length() != 10) {
			return false;
		}
       for(int i = 0; i < seq.length(); i++) {
    	   char c = seq.charAt(i);
    	   if(c == 'V') {
    		   numV++;
    	   }else if(c == 'F') {
    		   numF++;
    	   }else {
    		   return false;
    	   }
       }
       return true;
	}
	
	public void cadastrarGabaritoOficial() throws IOException {
		File gabaritoOficial = new File(diretorio, "gabarito.txt");
		FileWriter registrarGabarito = new FileWriter(gabaritoOficial);
		Scanner scan = new Scanner(System.in);
		String gabarito = " ";
		while(validarSequencia(gabarito)) {
		System.out.println("Insira a sequência das respostas: ");
	    gabarito = scan.next(); 
		}
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
		registrarAluno.write(sequenciaRespostas.toUpperCase());
		registrarAluno.write("\t");
		registrarAluno.write(nome);
		registrarAluno.write("\n");
		registrarAluno.close();
	}
	
	public void acessarDados(String endereco) throws IOException {
		File arq = new File(endereco);
	    BufferedReader br = new BufferedReader(new FileReader(arq));
	    String linha = br.readLine();
	    while(linha !=null) {
	    	String[] dados = linha.split("\t");
	    	alunos.add(new Aluno(dados[1], dados[0]));
	    	linha = br.readLine();
	    }
		br.close();
	}
	
	public void calcularAcertos() {
		for(Aluno al: alunos) {
			int length = gabarito.length();
	         int acertos = 0;
	         int numV = 0;
	         int numF = 0;
			for(int i = 0;i < gabarito.length(); i++) {
				char resposta = al.getRespostas().charAt(i);
				if(gabarito.charAt(i) == resposta) {
					acertos++;
					if(resposta == 'F') {
						numF++;
					}else {
						numV++;
					}
				}
			}
			if(numV == gabarito.length() || numF == gabarito.length()) {
				al.setNumAcertos(0);
				return;
			}
			al.setNumAcertos(acertos);
		}
	}
	
	public void calcularMedia() {
		int total = 0;
		double media = 0.0;
		for(Aluno al : alunos) {
			total += al.getNumAcertos();
		}
		media = total / alunos.size();
		this.media = media;
	}
	
	public void criarArquivoEmOrdemAlfabetica() throws IOException {
		File arq = new File(diretorio,"Notas_em_ordem_alfabetica.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(arq,true));
	}
}
