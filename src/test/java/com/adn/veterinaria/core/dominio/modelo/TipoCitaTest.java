package com.adn.veterinaria.core.dominio.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorNegativo;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.adn.veterinaria.core.testdatabuilder.TipoCitaTestDataBuilder;

@SpringBootTest
class TipoCitaTest {

	@Test
	void validarNombreObligatorio() {
		// Arrange
		TipoCitaTestDataBuilder tipoCita = new TipoCitaTestDataBuilder().conNombre(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> tipoCita.build(), "El nombre es un dato obligatorio");
	}

	@Test
	void validarTarifaObligatoria() {
		// Arrange
		TipoCitaTestDataBuilder tipoCita = new TipoCitaTestDataBuilder().conTarifaBasica(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> tipoCita.build(),
				"La tarifa basica es un dato obligatorio");
	}

	@Test
	void validarValorTarifaNegativo() {
		// Arrange
		TipoCitaTestDataBuilder tipoCita = new TipoCitaTestDataBuilder().conTarifaBasica(-10D);

		// Act - Assert
		assertThrows(ExcepcionValorNegativo.class, () -> tipoCita.build(),
				"La tarifa basica no puede ser un valor negativo");
	}

	@Test
	void validarDescripcionObligatoria() {
		// Arrange
		TipoCitaTestDataBuilder tipoCita = new TipoCitaTestDataBuilder().conDescripcionBreve(null);

		// Act - Assert
		assertThrows(ExcepcionValorObligatorio.class, () -> tipoCita.build(), "La descripcion es un dato obligatorio");
	}
}
