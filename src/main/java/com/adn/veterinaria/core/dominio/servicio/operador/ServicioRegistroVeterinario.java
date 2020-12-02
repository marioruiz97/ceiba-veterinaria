package com.adn.veterinaria.core.dominio.servicio.operador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionDuplicidad;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;

@Service
public class ServicioRegistroVeterinario {

	private static final String IDENTIFICACION_YA_EXISTE = "La identificación ingresada ya se encuentra en el sistema";
	
	private final RepositorioRegistroVeterinario repositorioRegistroVeterinario;

	@Autowired
	public ServicioRegistroVeterinario(RepositorioRegistroVeterinario repositorioVeterinario) {
		this.repositorioRegistroVeterinario = repositorioVeterinario;
	}

	public Veterinario crear(Veterinario veterinario) {
		validarIdentificacionExistente(veterinario.getIdentificacion());
		return repositorioRegistroVeterinario.crearOModificar(veterinario);
	}
	
	public Veterinario modificar(Veterinario veterinario) {
		return repositorioRegistroVeterinario.crearOModificar(veterinario);
	}
	
	public void validarIdentificacionExistente(String identificacion) {
		if (repositorioRegistroVeterinario.existeIdentificacion(identificacion)) {
			throw new ExcepcionDuplicidad(IDENTIFICACION_YA_EXISTE);
		}
	}

}
