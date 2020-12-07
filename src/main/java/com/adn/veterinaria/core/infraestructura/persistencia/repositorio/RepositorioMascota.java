package com.adn.veterinaria.core.infraestructura.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadResponsableMascota;

@Repository
public interface RepositorioMascota extends JpaRepository<EntidadMascota, Long>, RepositorioRegistroMascota {

	List<EntidadMascota> findByResponsableMascota(EntidadResponsableMascota responsableMascota);

	@Override
	default Mascota crearOModificar(Mascota mascota, Long idResponsable) {
		EntidadMascota entidadMascota = ConvertidorMascota.convertirAEntidad(mascota);
		entidadMascota.getResponsableMascota().setId(idResponsable);
		return ConvertidorMascota.convertirADominio(save(entidadMascota));
	}

	@Override
	default Mascota obtenerPorId(Long idMascota) {
		return ConvertidorMascota.convertirADominio(findById(idMascota).orElse(null));
	}

}
