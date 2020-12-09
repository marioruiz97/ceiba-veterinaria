package com.adn.veterinaria.core.dominio.servicio.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinariaDto;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaCita;

@Service
public class ServicioConsultaCitaVeterinaria {

	private final RepositorioConsultaCita repositorioConsultaCita;

	@Autowired
	public ServicioConsultaCitaVeterinaria(RepositorioConsultaCita repositorioConsultaCita) {
		this.repositorioConsultaCita = repositorioConsultaCita;
	}

	public List<CitaVeterinariaDto> obtener() {
		List<CitaVeterinariaDto> citas = this.repositorioConsultaCita.obtener();
		if (citas.isEmpty())
			throw new ExcepcionRecursoNoEncontrado();
		return citas;
	}

}
