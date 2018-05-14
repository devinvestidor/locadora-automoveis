package br.com.karanalpe.crud.exception;

public class NegocioException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NegocioException(String msg) {
		super(msg);
	}

}
