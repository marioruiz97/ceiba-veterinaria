package com.adn.veterinaria.core.dominio.repositorio.operador;

import com.adn.veterinaria.core.dominio.modelo.Mascota;

public interface RepositorioRegistroMascota {

	public Mascota crearOModificar(Mascota mascota, Long idResponsable);

	public Mascota obtenerPorId(Long idMascota);
}
