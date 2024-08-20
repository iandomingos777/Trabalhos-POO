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
	private String gabarito;
	private ArrayList<Aluno> alunos;
	private static File diretorio;
	Scanner scan = new Scanner(System.in);
	
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
    		   // problema aqui return false;
    	   }
       }
       return true;
	}
	
	public void cadastrarGabaritoOficial() throws IOException {
		File gabaritoOficial = new File(diretorio, "gabarito.txt");
		FileWriter registrarGabarito = new FileWriter(gabaritoOficial);
		String gabarito = " ";
		//while(!validarSequencia(gabarito)) {
		System.out.println("Insira a sequência das respostas: ");
	    gabarito = scan.next(); 
		//}
		registrarGabarito.write(gabarito);
		registrarGabarito.close();	
	}
	
	public boolean registrarGabaritoAluno() throws IOException {
		File respostaAlunos = new File(diretorio, nome + ".txt");
		FileWriter registrarAluno = new FileWriter(respostaAlunos, true);	
		System.out.println("Insira a sequência de respostas e o nome do aluno: ");
		String sequenciaRespostas = scan.next();
		if(sequenciaRespostas.equals("sair") || sequenciaRespostas.equals("-1")) {
			registrarAluno.close();
			return false;
		}
		String nome = scan.next();
		registrarAluno.write(sequenciaRespostas.toUpperCase());
		registrarAluno.write("\t");
		registrarAluno.write(nome);
		registrarAluno.write("\n");	
		registrarAluno.close();
		return true;
	}
	
	public void registrarClasse() {
		System.out.println("Digite '-1' ou 'sair' para parar.");
		while(true) {
			try {
				if(!registrarGabaritoAluno()) {
					scan.close();
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Classe registrada com sucesso!");
	}
	
	public void calcularAcertos() {
		for(Aluno al: alunos) {
			int length = 10;
	        int acertos = 0;
	        int numV = 0;
	        int numF = 0;
			for(int i = 0;i < length; i++) {
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
	
}
