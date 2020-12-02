package com.adn.veterinaria.core.dominio.servicio;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServicioFormateadorFechaTest {

	@Test
	void fechaDateALocalDateTest() throws Exception {
		// Arrange
		LocalDate fechaEsperada = LocalDate.now();
		Date fechaAFormatear = Date.from(fechaEsperada.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		// Act
		LocalDate fechaFormateada = ServicioFormeateadorFecha.fechaDateALocalDate(fechaAFormatear);

		// Assert
		assertThat(fechaFormateada).isEqualTo(fechaEsperada);
	}

	@Test
	void fechaLocalDateADate() throws Exception {
		// Arrange
		Date fechaEsperada = new Date();
		LocalDate fechaAFormatear = LocalDate.ofInstant(fechaEsperada.toInstant(), ZoneId.systemDefault());

		// Act
		Date fechaFormateada = ServicioFormeateadorFecha.fechaLocalDateADate(fechaAFormatear);

		// Assert
		assertThat(fechaFormateada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
				.isEqualTo(fechaEsperada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	@Test
	void fechaLocalDateTimeADate() throws Exception {
		// Arrange
		Date fechaEsperada = new Date();
		LocalDateTime fechaAFormatear = LocalDateTime.ofInstant(fechaEsperada.toInstant(), ZoneId.systemDefault());

		// Act
		Date fechaFormateada = ServicioFormeateadorFecha.fechaLocalDateTimeADate(fechaAFormatear);

		// Assert
		assertThat(fechaFormateada).isEqualTo(fechaEsperada);
	}

}
