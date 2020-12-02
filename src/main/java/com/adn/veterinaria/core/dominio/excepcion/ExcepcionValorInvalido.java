package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionValorInvalido extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionValorInvalido(String mensaje) {
		super(mensaje);
	}
}
