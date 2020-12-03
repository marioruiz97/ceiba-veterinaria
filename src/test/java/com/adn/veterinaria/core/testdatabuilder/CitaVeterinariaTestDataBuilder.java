package com.adn.veterinaria.core.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adn.veterinaria.core.aplicacion.comando.ComandoCitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;

public class CitaVeterinariaTestDataBuilder {

	private static final String FORMATO_FECHA = "yyyy-MM-dd HH:mm";
	private static final String FECHA_CITA = "2020-12-22 08:00";
	private static final Long ID = 1L;

	private Date fechaCita;
	private Long idVeterinario;
	private Long idMascota;
	private Long idTipoCita;

	public CitaVeterinariaTestDataBuilder() {
		try {
			this.fechaCita = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_CITA);
		} catch (ParseException parseException) {
			System.out.println(parseException);
		}
		this.idMascota = ID;
		this.idVeterinario = ID;
		this.idTipoCita = ID;

	}

	public CitaVeterinariaTestDataBuilder conFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
		return this;
	}

	public CitaVeterinariaTestDataBuilder conIdVeterinario(Long idVeterinario) {
		this.idVeterinario = idVeterinario;
		return this;
	}

	public CitaVeterinariaTestDataBuilder conIdMascota(Long idMascota) {
		this.idMascota = idMascota;
		return this;
	}

	public CitaVeterinariaTestDataBuilder conIdTipoCita(Long idTipoCita) {
		this.idTipoCita = idTipoCita;
		return this;
	}

	public CitaVeterinaria build() {
		return CitaVeterinaria.crear(fechaCita, new PersonaTestDataBuilder().buildVeterinario(),
				new MascotaTestDataBuilder().build(), new TipoCitaTestDataBuilder().build());
	}

	public ComandoCitaVeterinaria buildComando() {
		return new ComandoCitaVeterinaria(ID, this.fechaCita, this.idVeterinario, this.idMascota, this.idTipoCita);
	}

}
