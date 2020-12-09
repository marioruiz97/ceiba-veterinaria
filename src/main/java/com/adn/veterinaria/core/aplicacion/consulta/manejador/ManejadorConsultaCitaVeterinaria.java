package com.adn.veterinaria.core.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinariaDto;
import com.adn.veterinaria.core.dominio.servicio.consulta.ServicioConsultaCitaVeterinaria;

@Component
public class ManejadorConsultaCitaVeterinaria {

	private final ServicioConsultaCitaVeterinaria servicioConsulta;

	@Autowired
	public ManejadorConsultaCitaVeterinaria(ServicioConsultaCitaVeterinaria servicioConsulta) {
		this.servicioConsulta = servicioConsulta;
	}

	@Transactional(readOnly = true)
	public List<CitaVeterinariaDto> obtener() {
		return this.servicioConsulta.obtener();
	}

}
