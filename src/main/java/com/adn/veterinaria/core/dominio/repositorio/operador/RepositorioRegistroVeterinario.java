package com.adn.veterinaria.core.dominio.repositorio.operador;

import com.adn.veterinaria.core.dominio.modelo.Veterinario;

public interface RepositorioRegistroVeterinario {

	public Veterinario crearOModificar(Veterinario veterinario);

	public Veterinario obtenerPorId(Long id);
	
	public boolean existeIdentificacion(String identificacion);
}
