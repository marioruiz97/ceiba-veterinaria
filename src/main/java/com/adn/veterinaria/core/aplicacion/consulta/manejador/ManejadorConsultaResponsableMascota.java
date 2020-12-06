package com.adn.veterinaria.core.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.servicio.consulta.ServicioConsultaResponsable;

@Component
public class ManejadorConsultaResponsableMascota {

	private final ServicioConsultaResponsable servicioConsultaResponsable;

	@Autowired
	public ManejadorConsultaResponsableMascota(ServicioConsultaResponsable servicioConsultaResponsable) {
		this.servicioConsultaResponsable = servicioConsultaResponsable;
	}

	@Transactional(readOnly = true)
	public List<ResponsableMascota> obtener() {
		return this.servicioConsultaResponsable.obtener();
	}

	@Transactional(readOnly = true)
	public ResponsableMascota obtenerPorId(Long idResponsable) {
		return this.servicioConsultaResponsable.obtenerPorId(idResponsable);
	}

}
