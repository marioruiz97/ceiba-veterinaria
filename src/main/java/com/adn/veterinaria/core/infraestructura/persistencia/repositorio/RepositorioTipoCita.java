package com.adn.veterinaria.core.infraestructura.persistencia.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaTipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorTipoCita;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadTipoCita;

@Repository
public interface RepositorioTipoCita
		extends JpaRepository<EntidadTipoCita, Long>, RepositorioRegistroTipoCita, RepositorioConsultaTipoCita {

	@Override
	default TipoCita crearOModificar(TipoCita tipoCita) {
		EntidadTipoCita entidad = ConvertidorTipoCita.convertirAEntidad(tipoCita);
		return ConvertidorTipoCita.convertirADominio(save(entidad));
	}

	@Override
	default void eliminarPorId(Long idTipo) {
		if (obtenerPorId(idTipo) != null)
			deleteById(idTipo);
	}

	@Override
	default TipoCita obtenerPorId(Long idTipo) {
		return ConvertidorTipoCita.convertirADominio(findById(idTipo).orElse(null));
	}

	@Override
	default List<TipoCita> obtener() {
		return findAll().stream().map(ConvertidorTipoCita::convertirADominio).collect(Collectors.toList());
	}

}
