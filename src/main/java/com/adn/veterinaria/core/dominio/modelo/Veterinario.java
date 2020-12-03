package com.adn.veterinaria.core.dominio.modelo;

import lombok.Getter;

public class Veterinario extends Persona {

	@Getter
	private Long idVeterinario;

	public Veterinario(Long idVeterinario, String identificacion, String nombre, String apellido1, String apellido2,
			String telefonoContacto) {

		super(identificacion, nombre, apellido1, apellido2, telefonoContacto);
		this.idVeterinario = idVeterinario;
	}

}
