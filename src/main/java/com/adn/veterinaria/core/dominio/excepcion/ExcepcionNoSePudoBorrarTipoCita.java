package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionNoSePudoBorrarTipoCita extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNoSePudoBorrarTipoCita(String message) {
		super(message);
	}
}
