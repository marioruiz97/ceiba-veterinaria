package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionValorObligatorio extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionValorObligatorio(String message) {
		super(message);
	}

}
