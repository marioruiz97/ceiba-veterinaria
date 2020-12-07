package com.adn.veterinaria.core.dominio.servicio.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;

@Service
public class ServicioConsultaMascota {

	private final RepositorioConsultaMascota repositorioConsultaMascota;
	private final RepositorioRegistroMascota repositorioRegistroMascota;

	@Autowired
	public ServicioConsultaMascota(RepositorioConsultaMascota repositorioConsultaMascota,
			RepositorioRegistroMascota repositorioRegistroMascota) {
		this.repositorioConsultaMascota = repositorioConsultaMascota;
		this.repositorioRegistroMascota = repositorioRegistroMascota;
	}

	public List<Mascota> obtener() {
		List<Mascota> mascotas = this.repositorioConsultaMascota.obtener();
		if (mascotas.isEmpty())
			throw new ExcepcionRecursoNoEncontrado();
		return mascotas;

	}

	public List<Mascota> obtenerPorResponsable(Long idResponsable) {
		List<Mascota> mascotas = this.repositorioConsultaMascota.obtenerPorResponsable(idResponsable);
		if (mascotas.isEmpty())
			throw new ExcepcionRecursoNoEncontrado();
		return mascotas;
	}

	public Mascota obtenerPorId(Long idMascota) {
		Mascota mascota = this.repositorioRegistroMascota.obtenerPorId(idMascota);
		if (mascota == null)
			throw new ExcepcionRecursoNoEncontrado();
		return mascota;
	}

}
