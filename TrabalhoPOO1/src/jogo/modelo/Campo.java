package jogo.modelo;

import java.util.ArrayList;

public class Campo {
	int number;
private ArrayList<Jogador> players = new ArrayList<Jogador>();

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

public String toString() {
	StringBuilder sb = new StringBuilder();
	if((number >= 0 && number <=10)  || (number >= 31 && number <= 40)) {
		sb.append("[");
		for(int i = 0; i < players.size(); i++) {
			sb.append(players.get(i));
		}
		for(int i = 0; i < 6 - players.size(); i++) {
			sb.append(" ");
		}
		sb.append("]");
	}else {
		sb.append("_\n");
		for(int i = 0; i < players.size(); i++) {
			sb.append("|" + players.get(i) + "|\n");
		}
		for(int i = 0; i < 6 - players.size(); i++) {
			sb.append("| |\n");
		}
		sb.append("_\n");
	}
	return sb.toString();
}

}
