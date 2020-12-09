package com.adn.veterinaria.core.dominio.servicio.consulta;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaCita;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ServicioConsultaCitaTest {

	@Test
	void obtenerListaFail() {
		// Arrange
		RepositorioConsultaCita repositorioConsultaCita = mock(RepositorioConsultaCita.class);

		when(repositorioConsultaCita.obtener()).thenReturn(new ArrayList<>());

		ServicioConsultaCitaVeterinaria servicioConsulta = new ServicioConsultaCitaVeterinaria(repositorioConsultaCita);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioConsulta.obtener(),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}
}
