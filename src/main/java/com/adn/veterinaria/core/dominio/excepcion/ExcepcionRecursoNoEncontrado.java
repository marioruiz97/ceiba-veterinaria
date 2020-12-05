package com.adn.veterinaria.core.dominio.excepcion;

public class ExcepcionRecursoNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public static final String NO_SE_ENCONTRARON_DATOS = "No se encontró en base de datos el/los registros esperados";

	public ExcepcionRecursoNoEncontrado() {
		super(NO_SE_ENCONTRARON_DATOS);
	}

	public ExcepcionRecursoNoEncontrado(String mensaje) {
		super(mensaje);
	}

}
