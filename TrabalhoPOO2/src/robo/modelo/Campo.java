package robo.modelo;

import java.util.ArrayList;

public class Campo {
	private int posX;
	private int posY;
	private boolean eAlimento;
	private boolean estaOcupado;
	private ArrayList<Robo> robos = new ArrayList<Robo>();

	public Campo(int posY, int posX) {
		this.posX = posX;
		this.posY = posY;
		estaOcupado = false;
		eAlimento = false;
	}

	
	
	public boolean isOcupado() {
		return estaOcupado;
	}



	public void addRobo(Robo robo)
	{
		robos.add(robo);
		estaOcupado = true;
	}
 
	public void remRobo(Robo robo) {
		for(int i = 0; i < robos.size(); i++) {
			if(robos.get(i).getCor().equals(robo.getCor())) {
				robos.remove(i);
			}
		}
		if(robos.isEmpty()) {
			estaOcupado = false;
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
        String grayColor = "\u001B[30m\u001B[40m ";
        String dot = "⚫";
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
		return "[" + grayColor + dot + resetColor + " ]";
	}
}
