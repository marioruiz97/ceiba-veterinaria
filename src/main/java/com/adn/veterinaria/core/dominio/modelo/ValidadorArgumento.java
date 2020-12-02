package com.adn.veterinaria.core.dominio.modelo;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorNegativo;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorObligatorio;

public final class ValidadorArgumento {
	
	public static final String DATO_OBLIGATORIO = "%s es un dato obligatorio";
	public static final String DATO_NO_PUEDE_SER_NEGATIVO = "%s no puede ser un valor negativo";

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String nombreDato) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(String.format(DATO_OBLIGATORIO, nombreDato));
		}
	}

	public static void validarValorNegativo(Double valor, String nombreValor) {
		if (valor < 0) {
			throw new ExcepcionValorNegativo(String.format(DATO_NO_PUEDE_SER_NEGATIVO, nombreValor));
		}
	}

}
