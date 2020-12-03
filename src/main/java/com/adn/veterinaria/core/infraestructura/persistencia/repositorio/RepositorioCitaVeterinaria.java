package com.adn.veterinaria.core.infraestructura.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioAsignacionCita;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorCitaVeterinaria;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadCitaVeterinaria;

@Repository
public interface RepositorioCitaVeterinaria
		extends JpaRepository<EntidadCitaVeterinaria, Long>, RepositorioAsignacionCita {

	@Override
	default CitaVeterinaria asignar(CitaVeterinaria citaVeterinaria) {
		EntidadCitaVeterinaria entidadCita = ConvertidorCitaVeterinaria.convertirAEntidad(citaVeterinaria);
		return ConvertidorCitaVeterinaria.convertirADominio(save(entidadCita));
	}

}
