package jogo.modelo;

import java.util.ArrayList;

public class Campo {
	int number;
private ArrayList<Jogador> players = new ArrayList<Jogador>();



public ArrayList<Jogador> getPlayers() {
	return players;
}


public Campo(int number) {
	this.number = number;
}

public void addPlayer(Jogador player) {
	players.add(player);
}

public void remPlayer(Jogador player) {
	for(int i = 0; i < players.size(); i++) {
		if(players.get(i).getId() == player.getId()) {
			players.remove(i);
		}
	}
}


}
