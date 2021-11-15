package br.com.systemsgs.exception;

public class CpfCnpjClienteJaCadastradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CpfCnpjClienteJaCadastradoException(String message) {
		super(message);
	}

}
