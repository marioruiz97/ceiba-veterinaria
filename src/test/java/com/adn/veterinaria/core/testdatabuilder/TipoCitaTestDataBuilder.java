package com.adn.veterinaria.core.testdatabuilder;

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;

public class TipoCitaTestDataBuilder {
	private static final String NOMBRE = "Cita General";
	private static final Double TARIFA_BASICA = 18000D;
	private static final String DESCRIPCION_BREVE = "Cita veterinaria general de revision de mascotas";

	private Long idTipoCita;
	private String nombre;
	private Double tarifaBasica;
	private String descripcionBreve;

	public TipoCitaTestDataBuilder() {
		super();
		this.idTipoCita = null;
		this.nombre = NOMBRE;
		this.tarifaBasica = TARIFA_BASICA;
		this.descripcionBreve = DESCRIPCION_BREVE;
	}

	public TipoCitaTestDataBuilder conIdTipoCita(Long idTipoCita) {
		this.idTipoCita = idTipoCita;
		return this;
	}

	public TipoCitaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public TipoCitaTestDataBuilder conTarifaBasica(Double tarifaBasica) {
		this.tarifaBasica = tarifaBasica;
		return this;
	}

	public TipoCitaTestDataBuilder conDescripcionBreve(String descripcionBreve) {
		this.descripcionBreve = descripcionBreve;
		return this;
	}

	public ComandoTipoCita buildComando() {
		return new ComandoTipoCita(this.idTipoCita, this.nombre, this.tarifaBasica, this.descripcionBreve);
	}

	public TipoCita build() {
		return new TipoCita(this.idTipoCita, this.nombre, this.tarifaBasica, this.descripcionBreve);
	}
}
