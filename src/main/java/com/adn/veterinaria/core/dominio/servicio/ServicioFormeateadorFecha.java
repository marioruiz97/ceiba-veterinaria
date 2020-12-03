package com.adn.veterinaria.core.dominio.servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public final class ServicioFormeateadorFecha {

	private ServicioFormeateadorFecha() {
	}

	private static ZoneId getDefaultZone() {
		return ZoneId.systemDefault();
	}

	public static LocalDate fechaDateALocalDate(Date fecha) {
		return fecha.toInstant().atZone(getDefaultZone()).toLocalDate();
	}

	public static Date fechaLocalDateADate(LocalDate fecha) {
		return Date.from(fecha.atStartOfDay(getDefaultZone()).toInstant());
	}

	public static Date fechaLocalDateTimeADate(LocalDateTime fecha) {
		return Date.from(fecha.atZone(getDefaultZone()).toInstant());
	}

	public static LocalDateTime fechaDateALocalDateTime(Date fechaCita) {
		return fechaCita.toInstant().atZone(getDefaultZone()).toLocalDateTime();
	}
}
