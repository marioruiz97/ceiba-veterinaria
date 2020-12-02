package com.adn.veterinaria.core.dominio.modelo;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorNegativo;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

	public static void validarValorNegativo(Double valor, String mensaje) {
		if (valor < 0) {
			throw new ExcepcionValorNegativo(mensaje);
		}
	}

}
