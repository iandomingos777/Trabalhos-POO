package arquivo;

import java.util.ArrayList;

public class Disciplina {
	
	private String nome;
	private int numAlunos;
	private double media;
	private String caminhoGabaritoOficial;
	private String gabarito; 
	private ArrayList<Aluno> alunos; 
	
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
	
}
