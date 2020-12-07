package com.adn.veterinaria.core.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.servicio.consulta.ServicioConsultaMascota;

@Component
public class ManejadorConsultaMascota {

	private final ServicioConsultaMascota servicioConsultaMascota;

	@Autowired
	public ManejadorConsultaMascota(ServicioConsultaMascota servicioConsultaMascota) {
		this.servicioConsultaMascota = servicioConsultaMascota;
	}

	@Transactional(readOnly = true)
	public List<Mascota> obtener() {
		return this.servicioConsultaMascota.obtener();
	}

	@Transactional(readOnly = true)
	public List<Mascota> obtenerPorResponsable(Long idResponsable) {
		return this.servicioConsultaMascota.obtenerPorResponsable(idResponsable);
	}

}
