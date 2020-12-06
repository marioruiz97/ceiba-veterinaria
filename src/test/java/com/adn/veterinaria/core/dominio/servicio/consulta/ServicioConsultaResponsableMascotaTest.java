package com.adn.veterinaria.core.dominio.servicio.consulta;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaResponsable;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ServicioConsultaResponsableMascotaTest {

	@Test
	void obtenerListaFail() throws Exception {
		// Arrange
		RepositorioConsultaResponsable repositorioConsultaResponsable = mock(RepositorioConsultaResponsable.class);
		RepositorioRegistroResponsableMascota repositorioRegistroResponsableMascota = mock(
				RepositorioRegistroResponsableMascota.class);
		ServicioConsultaResponsable servicio = new ServicioConsultaResponsable(repositorioConsultaResponsable,
				repositorioRegistroResponsableMascota);

		when(repositorioConsultaResponsable.obtener()).thenReturn(new ArrayList<>());

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicio.obtener(),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

	@Test
	void obtenerPorIdFail() throws Exception {
		// Arrange
		RepositorioConsultaResponsable repositorioConsultaResponsable = mock(RepositorioConsultaResponsable.class);
		RepositorioRegistroResponsableMascota repositorioRegistroResponsableMascota = mock(
				RepositorioRegistroResponsableMascota.class);
		ServicioConsultaResponsable servicio = new ServicioConsultaResponsable(repositorioConsultaResponsable,
				repositorioRegistroResponsableMascota);

		when(repositorioRegistroResponsableMascota.obtenerPorId(1L)).thenReturn(null);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicio.obtenerPorId(1L),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

}
