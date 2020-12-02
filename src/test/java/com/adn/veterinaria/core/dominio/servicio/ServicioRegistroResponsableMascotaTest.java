package com.adn.veterinaria.core.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionDuplicidad;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroResponsableMascota;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroResponsableMascota;
import com.adn.veterinaria.core.testdatabuilder.PersonaTestDataBuilder;

@SpringBootTest
class ServicioRegistroResponsableMascotaTest {

	private static final String IDENTIFICACION_YA_EXISTE = "La identificación ingresada ya se encuentra en el sistema";

	@Test
	void ingresarresponsableConIdentificacionExistente() throws Exception {

		// Arrange
		RepositorioRegistroResponsableMascota repositorioResponsable = mock(
				RepositorioRegistroResponsableMascota.class);
		ServicioRegistroResponsableMascota servicioResponsable = new ServicioRegistroResponsableMascota(
				repositorioResponsable);

		ResponsableMascota responsable = new PersonaTestDataBuilder().buildResponsable();
		when(repositorioResponsable.existeIdentificacion(responsable.getIdentificacion())).thenReturn(true);

		// Act - Assert
		assertThrows(ExcepcionDuplicidad.class, () -> servicioResponsable.crear(responsable),
				IDENTIFICACION_YA_EXISTE);

	}
}
