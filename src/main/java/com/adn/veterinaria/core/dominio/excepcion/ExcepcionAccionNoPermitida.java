package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionAccionNoPermitida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionAccionNoPermitida(String mensaje) {
		super(mensaje);
	}
}
