package com.adn.veterinaria.core.dominio.modelo.validador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionFecha;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorInvalido;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorNegativo;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.adn.veterinaria.core.dominio.servicio.ServicioFormeateadorFecha;

public final class ValidadorArgumento {

	private static final String DATO_OBLIGATORIO = "%s es un dato obligatorio";
	private static final String DATO_NO_PUEDE_SER_NEGATIVO = "%s no puede ser un valor negativo";
	private static final String FECHA_DEBE_SER_PASADO = "La fecha debe estar en el pasado";
	private static final String FECHA_DEBE_SER_FUTURO = "La fecha debe estar en el futuro";
	private static final String FORMATO_TELEFONO_INVALIDO = "Ingrese un teléfono móvil colombiano (Ej: 3015465076)";

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

	public static void validarFechaPasada(Date fecha) {
		LocalDate fechaLimite = LocalDate.now().minusDays(1);
		if (fecha.after(ServicioFormeateadorFecha.fechaLocalDateADate(fechaLimite))) {
			throw new ExcepcionFecha(FECHA_DEBE_SER_PASADO);
		}
	}

	public static void validarFechaFutura(Date fecha) {
		LocalDateTime fechaLimite = LocalDateTime.now().plusHours(1);
		if (fecha.before(ServicioFormeateadorFecha.fechaLocalDateTimeADate(fechaLimite))) {
			throw new ExcepcionFecha(FECHA_DEBE_SER_FUTURO);
		}
	}

	public static void validarFormatoTelefono(String telefono) {
		if (!telefono.matches("(3[0-9]{9})|(\\d{7})")) {
			throw new ExcepcionValorInvalido(FORMATO_TELEFONO_INVALIDO);
		}
	}

}
