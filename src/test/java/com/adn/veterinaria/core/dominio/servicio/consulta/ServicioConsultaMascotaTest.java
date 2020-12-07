package com.adn.veterinaria.core.dominio.servicio.consulta;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionResponsableNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.repositorio.RepositorioMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.repositorio.RepositorioResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.repositorio.consulta.RepositorioConsultaMascotaPersistente;
import com.adn.veterinaria.core.testdatabuilder.MascotaTestDataBuilder;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ServicioConsultaMascotaTest {

	private static final String NO_SE_ENCONTRO_RESPONSABLE = "No se encontró el responsable, verifique los datos";

	@Test
	void obtenerMascotasFail() throws Exception {
		// Arrange
		RepositorioConsultaMascota repositorioConsultaMascota = mock(RepositorioConsultaMascota.class);
		RepositorioRegistroMascota repositorioRegistroMascota = mock(RepositorioRegistroMascota.class);
		ServicioConsultaMascota servicioMascota = new ServicioConsultaMascota(repositorioConsultaMascota,
				repositorioRegistroMascota);

		when(repositorioConsultaMascota.obtener()).thenReturn(new ArrayList<>());

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioMascota.obtener(),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

	@Test
	void obtenerMascotasPorResponsableFail() throws Exception {
		// Arrange
		RepositorioConsultaMascota repositorioConsultaMascota = mock(RepositorioConsultaMascota.class);
		RepositorioRegistroMascota repositorioRegistroMascota = mock(RepositorioRegistroMascota.class);
		ServicioConsultaMascota servicioMascota = new ServicioConsultaMascota(repositorioConsultaMascota,
				repositorioRegistroMascota);

		when(repositorioConsultaMascota.obtenerPorResponsable(1L)).thenReturn(new ArrayList<>());

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioMascota.obtenerPorResponsable(1L),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

	@Test
	void obtenerMascotaPorIdFail() throws Exception {
		// Arrange
		RepositorioConsultaMascota repositorioConsultaMascota = mock(RepositorioConsultaMascota.class);
		RepositorioRegistroMascota repositorioRegistroMascota = mock(RepositorioRegistroMascota.class);
		ServicioConsultaMascota servicioMascota = new ServicioConsultaMascota(repositorioConsultaMascota,
				repositorioRegistroMascota);

		when(repositorioRegistroMascota.obtenerPorId(1L)).thenReturn(null);

		// Act - Assert
		assertThrows(ExcepcionRecursoNoEncontrado.class, () -> servicioMascota.obtenerPorId(1L),
				ExcepcionRecursoNoEncontrado.NO_SE_ENCONTRARON_DATOS);
	}

	@Test
	void obtenerMascotasSinResponsable() throws Exception {
		// Arrange
		RepositorioResponsableMascota repositorioResponsableMascota = mock(RepositorioResponsableMascota.class);
		RepositorioMascota repositorioMascota = mock(RepositorioMascota.class);

		RepositorioConsultaMascotaPersistente repositorioConsulta = new RepositorioConsultaMascotaPersistente(
				repositorioMascota, repositorioResponsableMascota);

		when(repositorioResponsableMascota.obtenerPorId(1L)).thenReturn(null);

		// Act - Assert
		assertThrows(ExcepcionResponsableNoEncontrado.class, () -> repositorioConsulta.obtenerPorResponsable(1L),
				NO_SE_ENCONTRO_RESPONSABLE);
	}

	/**
	 * test para método que no se está utilizando en este momento, cuando se haga
	 * uso desde el manejador cambiarlo por prueba de integracion; en caso contrario
	 * si no se llega a utilizar eliminar método y test
	 * 
	 * @throws Exception
	 */
	@Test
	void obtenerMascotaPorId() throws Exception {
		// Arrange
		RepositorioConsultaMascota repositorioConsultaMascota = mock(RepositorioConsultaMascota.class);
		RepositorioRegistroMascota repositorioRegistroMascota = mock(RepositorioRegistroMascota.class);
		ServicioConsultaMascota servicioMascota = new ServicioConsultaMascota(repositorioConsultaMascota,
				repositorioRegistroMascota);

		Mascota mascota = new MascotaTestDataBuilder().build();
		when(repositorioRegistroMascota.obtenerPorId(1L)).thenReturn(mascota);

		// Act - Assert
		assertThat(servicioMascota.obtenerPorId(1L)).isEqualTo(mascota);
	}
}
