package robo.excecao;

public class MovimentoInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public MovimentoInvalidoException(String error) {
		super(error);
	}
	
}
