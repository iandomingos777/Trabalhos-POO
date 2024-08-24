package arquivo;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Fachada programa = new Fachada();
		try {
			programa.execução();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
