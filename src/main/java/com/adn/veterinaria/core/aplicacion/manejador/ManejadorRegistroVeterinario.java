package com.adn.veterinaria.core.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.aplicacion.fabrica.FabricaVeterinario;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroVeterinario;

@Component
public class ManejadorRegistroVeterinario {

	private final ServicioRegistroVeterinario servicioRegistroVeterinario;
	private final FabricaVeterinario fabricaVeterinario;

	@Autowired
	public ManejadorRegistroVeterinario(ServicioRegistroVeterinario servicioRegistroVeterinario,
			FabricaVeterinario fabricaVeterinario) {
		this.servicioRegistroVeterinario = servicioRegistroVeterinario;
		this.fabricaVeterinario = fabricaVeterinario;
	}

	@Transactional
	public Veterinario crear(ComandoPersona comando) {
		return servicioRegistroVeterinario.crear(fabricaVeterinario.crear(comando));
	}

	@Transactional
	public Veterinario modificar(ComandoPersona comando) {
		return servicioRegistroVeterinario.modificar(fabricaVeterinario.crear(comando));
	}

}
