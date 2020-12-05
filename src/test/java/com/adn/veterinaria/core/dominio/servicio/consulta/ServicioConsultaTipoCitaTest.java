package com.adn.veterinaria.core.dominio.servicio.consulta;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaTipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ServicioConsultaTipoCitaTest {

	@Test
	void obtenerListaFail() {
		// Arrange
		RepositorioRegistroTipoCita repositorioRegistroTipoCita = mock(RepositorioRegistroTipoCita.class);
		RepositorioConsultaTipoCita repositorioConsultaTipoCita = mock(RepositorioConsultaTipoCita.class);

		when(repositorioConsultaTipoCita.obtener()).thenReturn(new ArrayList<>());

		ServicioConsultaTipoCita servicioConsulta = new ServicioConsultaTipoCita(repositorioConsultaTipoCita,
				repositorioRegistroTipoCita);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioConsulta.obtener(),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

	@Test
	void obtenerPorIdFail() {
		// Arrange
		RepositorioRegistroTipoCita repositorioRegistroTipoCita = mock(RepositorioRegistroTipoCita.class);
		RepositorioConsultaTipoCita repositorioConsultaTipoCita = mock(RepositorioConsultaTipoCita.class);

		when(repositorioRegistroTipoCita.obtenerPorId(1L)).thenReturn(null);

		ServicioConsultaTipoCita servicioConsulta = new ServicioConsultaTipoCita(repositorioConsultaTipoCita,
				repositorioRegistroTipoCita);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioConsulta.obtenerPorId(1L),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

}
