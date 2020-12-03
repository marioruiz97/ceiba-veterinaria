package com.adn.veterinaria.core.dominio.modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.adn.veterinaria.core.dominio.modelo.validador.ValidadorArgumento;
import com.adn.veterinaria.core.dominio.modelo.validador.ValidadorCitaVeterinaria;
import com.adn.veterinaria.core.dominio.servicio.ServicioFormeateadorFecha;

import lombok.Getter;

@Getter
public class CitaVeterinaria {

	private Long codigoCita;
	private Date fechaCita;
	private Veterinario medicoVeterinario;
	private Mascota mascota;
	private TipoCita tipoCita;
	private Double valorFinal;

	public static CitaVeterinaria crear(Date fechaCita, Veterinario medicoVeterinario, Mascota mascota,
			TipoCita tipoCita) {
		return new CitaVeterinaria(null, fechaCita, medicoVeterinario, mascota, tipoCita);
	}

	public CitaVeterinaria(Long codigoCita, Date fechaCita, Veterinario medicoVeterinario, Mascota mascota,
			TipoCita tipoCita) {

		// validaciones para fecha
		ValidadorArgumento.validarObligatorio(fechaCita, "La fecha");
		ValidadorArgumento.validarFechaFutura(fechaCita);
		LocalDateTime fecha = ServicioFormeateadorFecha.fechaDateALocalDateTime(fechaCita);
		ValidadorCitaVeterinaria validadorCita = ValidadorCitaVeterinaria.construir(fecha);
		validadorCita.validarReglaHorario(fecha);

		// validaciones campos obligatorios
		ValidadorArgumento.validarObligatorio(medicoVeterinario, "El medico veterinario");
		ValidadorArgumento.validarObligatorio(mascota, "La mascota");

		this.fechaCita = new Date(fechaCita.getTime());
		this.tipoCita = tipoCita;
		// calculo precio final de la cita
		Double tarifaFinal = calcularValorFinal();
		ValidadorArgumento.validarValorNegativo(tarifaFinal, "El valor final a pagar");

		this.codigoCita = codigoCita;
		this.medicoVeterinario = medicoVeterinario;
		this.mascota = mascota;
		this.valorFinal = tarifaFinal;
	}

	private Double calcularValorFinal() {
		LocalDate fecha = ServicioFormeateadorFecha.fechaDateALocalDate(this.fechaCita);
		DayOfWeek diaCita = fecha.getDayOfWeek();
		Double tarifaFinal = this.tipoCita.getTarifaBasica();
		if (diaCita.equals(DayOfWeek.SATURDAY)) {
			// incrementar tarifa un 15%
			tarifaFinal = tarifaFinal * 1.15;
		}
		if (seDebeAplicarDescuento()) {
			// aplicar descuento de 20%
			tarifaFinal = tarifaFinal * 0.8;
		}
		return tarifaFinal;
	}

	private boolean seDebeAplicarDescuento() {
		// TODO implementar Regla de negocio
		return false;
	}

}
