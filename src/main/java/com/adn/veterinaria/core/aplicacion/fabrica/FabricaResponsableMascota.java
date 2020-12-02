package com.adn.veterinaria.core.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;

@Component
public class FabricaResponsableMascota {

	public ResponsableMascota crear(ComandoPersona comando) {
		return new ResponsableMascota(comando.getIdPersona(), comando.getIdentificacion(), comando.getNombre(),
				comando.getApellido1(), comando.getApellido2(), comando.getTelefonoContacto());
	}
}
