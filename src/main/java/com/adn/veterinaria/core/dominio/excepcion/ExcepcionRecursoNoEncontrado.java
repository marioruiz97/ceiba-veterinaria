package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionRecursoNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionRecursoNoEncontrado(String mensaje) {
		super(mensaje);
	}

}
