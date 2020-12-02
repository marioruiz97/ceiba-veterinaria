package com.adn.veterinaria.core.dominio.modelo;

import lombok.Getter;

public class ResponsableMascota extends Persona {

	@Getter
	private Long idResponsable;

	public ResponsableMascota(Long idResponsable, String identificacion, String nombre, String apellido1,
			String apellido2, String telefonoContacto) {
		
		super(identificacion, nombre, apellido1, apellido2, telefonoContacto);
		this.idResponsable = idResponsable;
	}
}
