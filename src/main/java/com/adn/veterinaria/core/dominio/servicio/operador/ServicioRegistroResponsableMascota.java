package com.adn.veterinaria.core.dominio.servicio.operador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionDuplicidad;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;

@Service
public class ServicioRegistroResponsableMascota {

	private static final String IDENTIFICACION_YA_EXISTE = "La identificación ingresada ya se encuentra en el sistema";

	private final RepositorioRegistroResponsableMascota repositorioResponsableMascota;

	@Autowired
	public ServicioRegistroResponsableMascota(RepositorioRegistroResponsableMascota repositorioResponsableMascota) {
		this.repositorioResponsableMascota = repositorioResponsableMascota;
	}

	public ResponsableMascota crear(ResponsableMascota responsable) {
		validarIdentificacionExistente(responsable.getIdentificacion());
		return repositorioResponsableMascota.crearOModificar(responsable);
	}

	public ResponsableMascota modificar(ResponsableMascota responsable) {
		return repositorioResponsableMascota.crearOModificar(responsable);
	}

	public void validarIdentificacionExistente(String identificacion) {
		if (repositorioResponsableMascota.existeIdentificacion(identificacion)) {
			throw new ExcepcionDuplicidad(IDENTIFICACION_YA_EXISTE);
		}
	}

}
