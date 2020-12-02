package com.adn.veterinaria.core.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ComandoPersona {

	@Setter
	private Long idPersona;
	private String identificacion;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefonoContacto;
}