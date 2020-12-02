package com.adn.veterinaria.core.dominio.repositorio.operador;

import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;

public interface RepositorioRegistroResponsableMascota {

	public ResponsableMascota crearOModificar(ResponsableMascota responsable);

	public ResponsableMascota obtenerPorId(Long id);
	
	public boolean existeIdentificacion(String identificacion);

}
