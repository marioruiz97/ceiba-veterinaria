package com.adn.veterinaria.core.dominio.servicio.operador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionResponsableNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;

@Service
public class ServicioRegistroMascota {

	private static final String RESPONSABLE_NO_ENCONTRADO = "No se encontró un responsable, primero cree uno para ingresar a la mascota";

	private final RepositorioRegistroMascota repositorioRegistroMascotas;
	private final RepositorioRegistroResponsableMascota repositorioRegistroResponsable;

	@Autowired
	public ServicioRegistroMascota(RepositorioRegistroMascota repositorioRegistroMascota,
			RepositorioRegistroResponsableMascota repositorioRegistroResponsable) {
		this.repositorioRegistroMascotas = repositorioRegistroMascota;
		this.repositorioRegistroResponsable = repositorioRegistroResponsable;
	}

	public Mascota crearOModificar(Mascota mascota, Long idResponsable) {
		ResponsableMascota responsableMascota = repositorioRegistroResponsable.obtenerPorId(idResponsable);
		if (responsableMascota != null) {
			mascota.setResponsableMascota(responsableMascota);
			return repositorioRegistroMascotas.crearOModificar(mascota, idResponsable);
		} else {
			throw new ExcepcionResponsableNoEncontrado(RESPONSABLE_NO_ENCONTRADO);
		}
	}

}
