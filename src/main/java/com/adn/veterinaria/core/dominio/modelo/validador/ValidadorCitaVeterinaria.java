package com.adn.veterinaria.core.dominio.modelo.validador;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionAccionNoPermitida;

public final class ValidadorCitaVeterinaria {

	private static final String FECHA_SELECCIONADA_NO_VALIDA = "La fecha ingresada para la cita no está dentro del horario de atención";

	public static final String HORARIO_SEMANA = "semana";
	public static final String HORARIO_SABADO = "sabado";

	private static final DayOfWeek SABADO = DayOfWeek.SATURDAY;
	private static final DayOfWeek LUNES = DayOfWeek.MONDAY;
	private static final DayOfWeek VIERNES = DayOfWeek.FRIDAY;

	// horas en formato de 24 horas
	private static final int HORA_INICIO_SEMANA = 8;
	private static final int HORA_CIERRE_SEMANA = 18;
	private static final int HORA_INICIO_FIN_DE_SEMANA = 9;
	private static final int HORA_CIERRE_FIN_DE_SEMANA = 16;

	private final DayOfWeek diaInicio;
	private final LocalTime horaInicio;
	private final DayOfWeek diaFin;
	private final LocalTime horaCierre;

	private ValidadorCitaVeterinaria(String horario) {

		if (horario.equals(HORARIO_SABADO)) {
			this.diaInicio = this.diaFin = SABADO;
			this.horaInicio = LocalTime.of(HORA_INICIO_FIN_DE_SEMANA, 0);
			this.horaCierre = LocalTime.of(HORA_CIERRE_FIN_DE_SEMANA, 0);
		} else {
			this.diaInicio = LUNES;
			this.horaInicio = LocalTime.of(HORA_INICIO_SEMANA, 0);
			this.diaFin = VIERNES;
			this.horaCierre = LocalTime.of(HORA_CIERRE_SEMANA, 0);
		}

	}

	public static ValidadorCitaVeterinaria construir(LocalDateTime fechaCita) {
		if (fechaCita.getDayOfWeek().equals(SABADO)) {
			return new ValidadorCitaVeterinaria(HORARIO_SABADO);
		} else {
			return new ValidadorCitaVeterinaria(HORARIO_SEMANA);
		}
	}

	public void validarReglaHorario(LocalDateTime fechaCita) {
		if(validarDia(fechaCita.getDayOfWeek()) && validarHora(fechaCita.toLocalTime()))
			throw new ExcepcionAccionNoPermitida(FECHA_SELECCIONADA_NO_VALIDA);
	}

	public boolean validarDia(DayOfWeek diaCita) {
		return diaCita.compareTo(diaInicio) >= 0 && diaCita.compareTo(diaFin) <= 0;
	}

	public boolean validarHora(LocalTime horaCita) {
		return horaCita.compareTo(horaInicio) >= 0 && horaCita.plusHours(1).compareTo(horaCierre) <= 0;
	}
}
