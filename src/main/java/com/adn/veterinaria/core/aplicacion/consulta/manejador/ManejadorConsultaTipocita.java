package com.adn.veterinaria.core.aplicacion.consulta.manejador;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.servicio.consulta.ServicioConsultaTipoCita;

@Component
public class ManejadorConsultaTipocita {

	private final ServicioConsultaTipoCita servicioConsultaTipoCita;

	public ManejadorConsultaTipocita(ServicioConsultaTipoCita servicioConsultaTipoCita) {
		this.servicioConsultaTipoCita = servicioConsultaTipoCita;
	}

	@Transactional(readOnly = true)
	public List<TipoCita> obtener() {
		return this.servicioConsultaTipoCita.obtener();
	}

	@Transactional(readOnly = true)
	public TipoCita obtenerPorId(Long idTipo) {
		return this.servicioConsultaTipoCita.obtenerPorId(idTipo);

	}

}
