package com.adn.veterinaria.core.infraestructura.persistencia.repositorio.consulta;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionResponsableNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.repositorio.RepositorioMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.repositorio.RepositorioResponsableMascota;

@Repository
public class RepositorioConsultaMascotaPersistente implements RepositorioConsultaMascota {

	private static final String NO_SE_ENCONTRO_RESPONSABLE = "No se encontró el responsable, verifique los datos";

	private final RepositorioMascota repositorioMascota;
	private final RepositorioResponsableMascota repositorioResponsableMascota;

	@Autowired
	public RepositorioConsultaMascotaPersistente(RepositorioMascota repositorioMascota,
			RepositorioResponsableMascota repositorioResponsableMascota) {
		this.repositorioMascota = repositorioMascota;
		this.repositorioResponsableMascota = repositorioResponsableMascota;
	}

	@Override
	public List<Mascota> obtener() {
		return this.repositorioMascota.findAll().stream().map(ConvertidorMascota::convertirADominio)
				.collect(Collectors.toList());
	}

	@Override
	public List<Mascota> obtenerPorResponsable(Long idResponsable) {
		EntidadResponsableMascota responsable = repositorioResponsableMascota.findById(idResponsable).orElse(null);
		if (responsable == null)
			throw new ExcepcionResponsableNoEncontrado(NO_SE_ENCONTRO_RESPONSABLE);
		return this.repositorioMascota.findByResponsableMascota(responsable).stream()
				.map(ConvertidorMascota::convertirADominio).collect(Collectors.toList());
	}

}
