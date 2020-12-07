package com.adn.veterinaria.core.dominio.repositorio.consulta;

import java.util.List;

import com.adn.veterinaria.core.dominio.modelo.Mascota;

public interface RepositorioConsultaMascota {

	public List<Mascota> obtener();

	public List<Mascota> obtenerPorResponsable(Long idResponsable);
}
