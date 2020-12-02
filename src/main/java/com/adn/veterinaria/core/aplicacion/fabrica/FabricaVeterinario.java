package com.adn.veterinaria.core.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;

@Component
public class FabricaVeterinario {

	public Veterinario crear(ComandoPersona comando) {
		return new Veterinario(comando.getIdPersona(), comando.getIdentificacion(), comando.getNombre(),
				comando.getApellido1(), comando.getApellido2(), comando.getTelefonoContacto());
	}
}
