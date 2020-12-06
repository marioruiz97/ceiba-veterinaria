package com.adn.veterinaria.core.dominio.servicio.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaResponsable;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;

@Service
public class ServicioConsultaResponsable {

	private final RepositorioConsultaResponsable repositorioConsultaResponsable;
	private final RepositorioRegistroResponsableMascota repositorioRegistroResponsable;

	@Autowired
	public ServicioConsultaResponsable(RepositorioConsultaResponsable repositorioConsultaResponsable,
			RepositorioRegistroResponsableMascota repositorioRegistroResponsable) {
		this.repositorioConsultaResponsable = repositorioConsultaResponsable;
		this.repositorioRegistroResponsable = repositorioRegistroResponsable;
	}

	public List<ResponsableMascota> obtener() {
		List<ResponsableMascota> responsables = this.repositorioConsultaResponsable.obtener();
		if (responsables.isEmpty())
			throw new ExcepcionRecursoNoEncontrado();
		return responsables;

	}

	public ResponsableMascota obtenerPorId(Long idResponsable) {
		ResponsableMascota responsable = this.repositorioRegistroResponsable.obtenerPorId(idResponsable);
		if (responsable == null)
			throw new ExcepcionRecursoNoEncontrado();
		return responsable;
	}
}
