package com.adn.veterinaria.core.dominio.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorInvalido;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.adn.veterinaria.core.testdatabuilder.PersonaTestDataBuilder;

@SpringBootTest
class PersonaTest {

	@Test
	void validarIdentificacionObligatoria() {
		// Arrange
		PersonaTestDataBuilder personaDataBuilder = new PersonaTestDataBuilder().conIdentificacion(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> personaDataBuilder.buildResponsable());
	}

	@Test
	void validarNombreObligatorio() {
		// Arrange
		PersonaTestDataBuilder personaDataBuilder = new PersonaTestDataBuilder().conNombre(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> personaDataBuilder.buildResponsable());
	}

	@Test
	void validarApellido1Obligatorio() {
		// Arrange
		PersonaTestDataBuilder personaDataBuilder = new PersonaTestDataBuilder().conApellido1(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> personaDataBuilder.buildResponsable());
	}

	@Test
	void validarTelefonoObligatorio() {
		// Arrange
		PersonaTestDataBuilder personaDataBuilder = new PersonaTestDataBuilder().conTelefonoContacto(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> personaDataBuilder.buildResponsable());
	}

	@Test
	void validarFormatoTelefono() {
		// Arrange
		PersonaTestDataBuilder personaDataBuilder = new PersonaTestDataBuilder().conTelefonoContacto("9845");

		// Act - Assert
		assertThrows(ExcepcionValorInvalido.class, () -> personaDataBuilder.buildVeterinario());
	}
}
