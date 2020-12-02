package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionValorNegativo extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionValorNegativo(String message) {
		super(message);
	}

}
