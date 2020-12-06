package com.adn.veterinaria.core.infraestructura.persistencia.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaResponsable;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadResponsableMascota;

@Repository
public interface RepositorioResponsableMascota extends JpaRepository<EntidadResponsableMascota, Long>,
		RepositorioRegistroResponsableMascota, RepositorioConsultaResponsable {

	public boolean existsByIdentificacion(String identificacion);

	@Override
	default ResponsableMascota crearOModificar(ResponsableMascota responsable) {
		EntidadResponsableMascota entidadResponsable = ConvertidorResponsableMascota.convertirAEntidad(responsable);
		return ConvertidorResponsableMascota.convertirADominio(save(entidadResponsable));
	}

	@Override
	default ResponsableMascota obtenerPorId(Long id) {
		return ConvertidorResponsableMascota.convertirADominio(findById(id).orElse(null));
	}

	@Override
	default boolean existeIdentificacion(String identificacion) {
		return existsByIdentificacion(identificacion);
	}

	@Override
	default List<ResponsableMascota> obtener() {
		return findAll().stream().map(ConvertidorResponsableMascota::convertirADominio).collect(Collectors.toList());
	}

}
