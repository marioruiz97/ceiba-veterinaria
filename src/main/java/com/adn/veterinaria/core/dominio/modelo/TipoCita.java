package com.adn.veterinaria.core.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TipoCita {

	@Setter
	private Long idTipoCita;
	private String nombre;
	private Double tarifaBasica;
	private String descripcionBreve;

	public TipoCita(Long idTipoCita, String nombre, Double tarifaBasica, String descripcionBreve) {
		ValidadorArgumento.validarObligatorio(nombre, "El nombre");
		ValidadorArgumento.validarObligatorio(tarifaBasica, "La tarifa basica");
		ValidadorArgumento.validarValorNegativo(tarifaBasica, "La tarifa basica");
		ValidadorArgumento.validarObligatorio(descripcionBreve, "La descripcion");

		this.idTipoCita = idTipoCita;
		this.nombre = nombre;
		this.tarifaBasica = tarifaBasica;
		this.descripcionBreve = descripcionBreve;
	}

}
