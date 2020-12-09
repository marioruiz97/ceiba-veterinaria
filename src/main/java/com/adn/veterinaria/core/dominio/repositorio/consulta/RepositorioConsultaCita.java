package com.adn.veterinaria.core.dominio.repositorio.consulta;

import java.util.List;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinariaDto;

public interface RepositorioConsultaCita {

	public List<CitaVeterinariaDto> obtener();
}
