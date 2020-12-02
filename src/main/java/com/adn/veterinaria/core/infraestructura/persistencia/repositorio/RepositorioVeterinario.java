package com.adn.veterinaria.core.infraestructura.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorVeterinario;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadVeterinario;

@Repository
public interface RepositorioVeterinario
		extends JpaRepository<EntidadVeterinario, Long>, RepositorioRegistroVeterinario {

	public boolean existsByIdentificacion(String identificacion);

	@Override
	default Veterinario crearOModificar(Veterinario veterinario) {
		EntidadVeterinario entidadVeterinario = ConvertidorVeterinario.convertirAEntidad(veterinario);
		return ConvertidorVeterinario.convertirADominio(save(entidadVeterinario));
	}

	@Override
	default Veterinario obtenerPorId(Long id) {
		return ConvertidorVeterinario.convertirADominio(findById(id).orElse(null));
	}

	@Override
	default boolean existeIdentificacion(String identificacion) {
		return existsByIdentificacion(identificacion);
	}

}
