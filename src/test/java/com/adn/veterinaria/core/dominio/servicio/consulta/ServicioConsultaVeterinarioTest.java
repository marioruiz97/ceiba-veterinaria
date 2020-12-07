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
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaVeterinario;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ServicioConsultaVeterinarioTest {

	@Test
	void consultarVeterinariosFail() throws Exception {
		// Arrange
		RepositorioConsultaVeterinario repositorioConsultaVeterinario = mock(RepositorioConsultaVeterinario.class);
		RepositorioRegistroVeterinario repositorioRegistroVeterinario = mock(RepositorioRegistroVeterinario.class);
		ServicioConsultaVeterinario servicioVeterinario = new ServicioConsultaVeterinario(
				repositorioConsultaVeterinario, repositorioRegistroVeterinario);

		when(repositorioConsultaVeterinario.obtener()).thenReturn(new ArrayList<>());

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioVeterinario.obtener(),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

	@Test
	void consultarVeterinarioPorIdFail() throws Exception {
		// Arrange
		RepositorioConsultaVeterinario repositorioConsultaVeterinario = mock(RepositorioConsultaVeterinario.class);
		RepositorioRegistroVeterinario repositorioRegistroVeterinario = mock(RepositorioRegistroVeterinario.class);
		ServicioConsultaVeterinario servicioVeterinario = new ServicioConsultaVeterinario(
				repositorioConsultaVeterinario, repositorioRegistroVeterinario);

		when(repositorioRegistroVeterinario.obtenerPorId(1L)).thenReturn(null);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioVeterinario.obtenerPorId(1L),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}
}
