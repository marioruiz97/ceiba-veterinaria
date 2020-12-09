package com.adn.veterinaria.core.infraestructura.persistencia.repositorio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinariaDto;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioAsignacionCita;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorCitaVeterinaria;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadCitaVeterinaria;

@Repository
public interface RepositorioCitaVeterinaria
		extends JpaRepository<EntidadCitaVeterinaria, Long>, RepositorioAsignacionCita, RepositorioConsultaCita {

	@Transactional(readOnly = true)
	@Query("SELECT COUNT(cv.codigoCita) FROM EntidadCitaVeterinaria cv WHERE cv.mascota.id = ?1 AND (cv.fechaCita BETWEEN ?2 AND CURDATE())")
	Integer countCitasUltimaSemana(Long idMascota, Date fechaCita);

	@Override
	default CitaVeterinaria asignar(CitaVeterinaria citaVeterinaria) {
		EntidadCitaVeterinaria entidadCita = ConvertidorCitaVeterinaria.convertirAEntidad(citaVeterinaria);
		return ConvertidorCitaVeterinaria.convertirADominio(save(entidadCita));
	}

	@Override
	default boolean aplicarDescuento(Long idMascota) {
		LocalDate fechaLimite = LocalDate.now().minusWeeks(1);
		return countCitasUltimaSemana(idMascota,
				Date.from(fechaLimite.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) > 0;
	}

	@Override
	default List<CitaVeterinariaDto> obtener() {
		return findAll().stream().map(ConvertidorCitaVeterinaria::convertirADTO).collect(Collectors.toList());
	}

}
