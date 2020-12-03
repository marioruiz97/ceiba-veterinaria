package com.adn.veterinaria.core.dominio.servicio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioAsignacionCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioAsignacionCita;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ServicioAsignacionCitaTest {

	@Test
	void validarasignarCitaConObjetoInexistente() {
		// Arrange
		Date fechaCita = new Date();
		Long id = 1L;
		RepositorioAsignacionCita repositorioAsignacionCita = mock(RepositorioAsignacionCita.class);
		RepositorioRegistroMascota repositorioRegistroMascotas = mock(RepositorioRegistroMascota.class);
		RepositorioRegistroTipoCita repositorioTipoCita = mock(RepositorioRegistroTipoCita.class);
		RepositorioRegistroVeterinario repositorioVeterinario = mock(RepositorioRegistroVeterinario.class);

		ServicioAsignacionCita servicio = new ServicioAsignacionCita(repositorioAsignacionCita, repositorioTipoCita,
				repositorioVeterinario, repositorioRegistroMascotas);

		when(repositorioRegistroMascotas.obtenerPorId(id)).thenReturn(null);
		when(repositorioVeterinario.obtenerPorId(id)).thenReturn(null);
		when(repositorioTipoCita.obtenerPorId(id)).thenReturn(null);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicio.asignar(fechaCita, id, id, id));

	}
}
