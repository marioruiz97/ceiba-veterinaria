package com.adn.veterinaria.core.dominio.servicio.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaVeterinario;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;

@Service
public class ServicioConsultaVeterinario {

	private final RepositorioConsultaVeterinario repositorioConsultaVeterinario;
	private final RepositorioRegistroVeterinario repositorioRegistroVeterinario;

	@Autowired
	public ServicioConsultaVeterinario(RepositorioConsultaVeterinario repositorioConsultaVeterinario,
			RepositorioRegistroVeterinario repositorioRegistroVeterinario) {
		this.repositorioConsultaVeterinario = repositorioConsultaVeterinario;
		this.repositorioRegistroVeterinario = repositorioRegistroVeterinario;
	}

	public List<Veterinario> obtener() {
		List<Veterinario> veterinarios = this.repositorioConsultaVeterinario.obtener();
		if (veterinarios.isEmpty())
			throw new ExcepcionRecursoNoEncontrado();
		return veterinarios;

	}

	public Veterinario obtenerPorId(Long idVeterinario) {
		Veterinario veterinario = this.repositorioRegistroVeterinario.obtenerPorId(idVeterinario);
		if (veterinario == null)
			throw new ExcepcionRecursoNoEncontrado();
		return veterinario;
	}

}
