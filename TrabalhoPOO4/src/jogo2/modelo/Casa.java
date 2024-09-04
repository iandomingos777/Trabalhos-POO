package jogo.modelo;

public abstract class Casa {
protected int posiçao;

public Casa(int posiçao) {
	this.posiçao = posiçao;
}

public abstract void aplicarRegra(Jogador jogador);
}
