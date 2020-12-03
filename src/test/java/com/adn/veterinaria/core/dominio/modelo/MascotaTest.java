package com.adn.veterinaria.core.dominio.modelo;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionFecha;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionValorNegativo;
import com.adn.veterinaria.core.testdatabuilder.MascotaTestDataBuilder;

@SpringBootTest
class MascotaTest {
	
	private static final String FECHA_DEBE_SER_PASADO = "La fecha debe estar en el pasado";

	@Test
	void crearMascotaValida() {
		// Arrange
		MascotaTestDataBuilder mascotaTestData = new MascotaTestDataBuilder();

		// Act
		mascotaTestData.build();

		// Assert
		assertThatNoException();

	}

	@Test
	void validarFechaNacimiento() {

		// Arrange
		Date fechaNacimiento = Date
				.from(LocalDate.of(2021, 11, 11).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		MascotaTestDataBuilder mascotaDataBuilder = new MascotaTestDataBuilder().conFechaNacimiento(fechaNacimiento);

		// Act - Assert
		assertThrows(ExcepcionFecha.class, () -> mascotaDataBuilder.build(), FECHA_DEBE_SER_PASADO);

	}

	@Test
	void validarPesoNegativo() {
		// Arrange
		MascotaTestDataBuilder mascotaDataBuilder = new MascotaTestDataBuilder().conPeso(-10D);

		// Act - Assert
		assertThrows(ExcepcionValorNegativo.class, () -> mascotaDataBuilder.build(),
				"El peso no puede ser un valor negativo");
	}
}
