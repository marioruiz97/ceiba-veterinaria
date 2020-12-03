package com.adn.veterinaria.core.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.aplicacion.comando.ComandoCitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioAsignacionCita;

@Component
public class ManejadorAsignacionCita {

	private final ServicioAsignacionCita servicioAsignacionCita;

	@Autowired
	public ManejadorAsignacionCita(ServicioAsignacionCita servicioAsignacionCita) {
		this.servicioAsignacionCita = servicioAsignacionCita;
	}

	@Transactional
	public CitaVeterinaria asignar(ComandoCitaVeterinaria comandoCita) {
		return servicioAsignacionCita.asignar(comandoCita.getFechaCita(), comandoCita.getIdVeterinario(),
				comandoCita.getIdMascota(), comandoCita.getIdTipoCita());
	}

}
