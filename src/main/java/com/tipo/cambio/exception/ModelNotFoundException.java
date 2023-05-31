package com.tipo.cambio.exception;

public class ModelNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6376331811366652582L;

	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}
}
