package com.adn.veterinaria.core.dominio.servicio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionResponsableNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroMascota;
import com.adn.veterinaria.core.testdatabuilder.MascotaTestDataBuilder;

@SpringBootTest
class ServicioRegistroMascotaTest {

	private static final String RESPONSABLE_NO_ENCONTRADO = "No se encontró un responsable, primero cree uno para ingresar a la mascota";

	@Test
	void crearOModificarSinResponsable() throws Exception {
		// Arrange
		RepositorioRegistroMascota repositorioRegistroMascotas = mock(RepositorioRegistroMascota.class);
		RepositorioRegistroResponsableMascota repositorioRegistroResponsable = mock(
				RepositorioRegistroResponsableMascota.class);

		ServicioRegistroMascota servicioMascota = new ServicioRegistroMascota(repositorioRegistroMascotas,
				repositorioRegistroResponsable);

		Long idResponsable = 0L;
		Mascota mascota = new MascotaTestDataBuilder().conResponsableMascota(idResponsable).build();

		when(repositorioRegistroResponsable.obtenerPorId(idResponsable)).thenReturn(null);

		// Act - Assert
		assertThrows(ExcepcionResponsableNoEncontrado.class,
				() -> servicioMascota.crearOModificar(mascota, idResponsable), RESPONSABLE_NO_ENCONTRADO);
		
	}
}
