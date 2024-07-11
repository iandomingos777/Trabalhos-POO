package robo.modelo;

import java.util.ArrayList;

public class Campo {
	private int posX;
	private int posY;
	private boolean eAlimento;
	private ArrayList<Robo> robos = new ArrayList<Robo>();

	public Campo(int posY, int posX) {
		this.posX = posX;
		this.posY = posY;
		eAlimento = false;
	}

	public void addRobo(Robo robo)
	{
		robos.add(robo);
	}
 
	public void remRobo(Robo robo) {
		for(int i = 0; i < robos.size(); i++) {
			if(robos.get(i).getCor().equals(robo.getCor())) {
				robos.remove(i);
			}
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public ArrayList<Robo> getRobos() {
		return robos;
	}
	
public void colocarAlimento() {
	eAlimento = true;
}

	public String toString() {
        String redColor = "\u001B[31m";
        String apple = "\uD83C\uDF4E"; 
        String resetColor = "\u001B[0m";
        
		if(robos.size() == 2)
		{
			return "["+robos.get(0) + " " 
					+ robos.get(1) +"]";
		}else if(robos.size() == 1) {
			return "[ " + robos.get(0) + " ]";
		}else if(eAlimento) {
			return "[ " + redColor + apple + resetColor + " ]"  ;
		}
		return "[   ]";
	}
}
