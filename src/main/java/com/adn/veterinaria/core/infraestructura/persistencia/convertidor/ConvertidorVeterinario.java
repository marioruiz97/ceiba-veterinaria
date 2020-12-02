package com.adn.veterinaria.core.infraestructura.persistencia.convertidor;

import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadVeterinario;

public final class ConvertidorVeterinario {

	private ConvertidorVeterinario() {
	}

	public static Veterinario convertirADominio(EntidadVeterinario entidad) {
		Veterinario veterinario = null;

		if (entidad != null) {
			veterinario = new Veterinario(entidad.getId(), entidad.getIdentificacion(), entidad.getNombre(),
					entidad.getApellido1(), entidad.getApellido2(), entidad.getTelefonoContacto());
		}

		return veterinario;
	}

	public static EntidadVeterinario convertirAEntidad(Veterinario dominio) {
		EntidadVeterinario entidadVeterinario = new EntidadVeterinario();
		entidadVeterinario.setId(dominio.getIdVeterinario());
		entidadVeterinario.setIdentificacion(dominio.getIdentificacion());
		entidadVeterinario.setNombre(dominio.getNombre());
		entidadVeterinario.setApellido1(dominio.getApellido1());
		entidadVeterinario.setApellido2(dominio.getApellido2());
		entidadVeterinario.setTelefonoContacto(dominio.getTelefonoContacto());

		return entidadVeterinario;
	}
}
