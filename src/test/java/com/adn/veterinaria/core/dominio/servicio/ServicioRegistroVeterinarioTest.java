package com.adn.veterinaria.core.dominio.servicio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionDuplicidad;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroVeterinario;
import com.adn.veterinaria.core.testdatabuilder.PersonaTestDataBuilder;

@SpringBootTest
class ServicioRegistroVeterinarioTest {

	private static final String IDENTIFICACION_YA_EXISTE = "La identificación ingresada ya se encuentra en el sistema";

	@Test
	void ingresarVeterinarioConIdentificacionExistente() throws Exception {

		// Arrange
		RepositorioRegistroVeterinario repositorioVeterinario = mock(RepositorioRegistroVeterinario.class);
		ServicioRegistroVeterinario servicioVeterinario = new ServicioRegistroVeterinario(repositorioVeterinario);

		Veterinario veterinario = new PersonaTestDataBuilder().buildVeterinario();
		when(repositorioVeterinario.existeIdentificacion(veterinario.getIdentificacion())).thenReturn(true);

		// Act - Assert
		assertThrows(ExcepcionDuplicidad.class, () -> servicioVeterinario.crear(veterinario),
				IDENTIFICACION_YA_EXISTE);

	}

}
