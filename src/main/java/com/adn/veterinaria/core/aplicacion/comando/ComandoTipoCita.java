package com.adn.veterinaria.core.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ComandoTipoCita {

	@Setter
	private Long idTipoCita;
	private String nombre;
	private Double tarifaBasica;
	private String descripcionBreve;
}
