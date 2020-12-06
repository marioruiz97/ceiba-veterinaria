package com.adn.veterinaria.core.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.servicio.consulta.ServicioConsultaVeterinario;

@Component
public class ManejadorConsultaVeterinario {

	private final ServicioConsultaVeterinario servicioConsultaVeterinario;

	@Autowired
	public ManejadorConsultaVeterinario(ServicioConsultaVeterinario servicioConsultaVeterinario) {
		this.servicioConsultaVeterinario = servicioConsultaVeterinario;
	}

	@Transactional(readOnly = true)
	public List<Veterinario> obtener() {
		return this.servicioConsultaVeterinario.obtener();
	}

	@Transactional(readOnly = true)
	public Veterinario obtenerPorId(Long idVeterinario) {
		return this.servicioConsultaVeterinario.obtenerPorId(idVeterinario);
	}

}
