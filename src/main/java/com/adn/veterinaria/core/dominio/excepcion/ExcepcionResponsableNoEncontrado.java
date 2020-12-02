package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionResponsableNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionResponsableNoEncontrado(String message) {
		super(message);
	}
}
