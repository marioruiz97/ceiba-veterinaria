package com.adn.veterinaria.core.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TipoCita {

	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre de tipo es un dato obligatorio";
	private static final String LA_TARIFA_BASICA_ES_UN_DATO_OBLIGATORIO = "La tarifa básica es un dato obligatorio";
	private static final String LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO = "La descripción breve es un dato obligatorio";
	private static final String LA_TARIFA_NO_PUEDE_SER_NEGATIVA = "La tarifa no puede ser un valor negativo";

	@Setter
	private Long idTipoCita;
	private String nombre;
	private Double tarifaBasica;
	private String descripcionBreve;

	public TipoCita(Long idTipoCita, String nombre, Double tarifaBasica, String descripcionBreve) {
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(tarifaBasica, LA_TARIFA_BASICA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarValorNegativo(tarifaBasica, LA_TARIFA_NO_PUEDE_SER_NEGATIVA);
		ValidadorArgumento.validarObligatorio(descripcionBreve, LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO);

		this.idTipoCita = idTipoCita;
		this.nombre = nombre;
		this.tarifaBasica = tarifaBasica;
		this.descripcionBreve = descripcionBreve;
	}

}
