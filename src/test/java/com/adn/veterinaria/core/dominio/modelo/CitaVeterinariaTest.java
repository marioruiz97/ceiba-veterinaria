package com.adn.veterinaria.core.dominio.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionAccionNoPermitida;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionFecha;
import com.adn.veterinaria.core.testdatabuilder.CitaVeterinariaTestDataBuilder;
import com.adn.veterinaria.core.testdatabuilder.TipoCitaTestDataBuilder;

@SpringBootTest
class CitaVeterinariaTest {

	private static final String FECHA_DEBE_SER_FUTURO = "La fecha debe estar en el futuro";
	private static final String FECHA_SELECCIONADA_NO_VALIDA = "La fecha ingresada para la cita no está dentro del horario de atención";

	@Test
	void validarFechaCitaFail() throws Exception {
		// Arrange
		Date fechaPasada;
		try {
			fechaPasada = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("10-11-2020 09:00");
		} catch (ParseException e) {
			fechaPasada = Date
					.from(LocalDate.of(2020, 10, 15).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		}
		CitaVeterinariaTestDataBuilder testDataBuilder = new CitaVeterinariaTestDataBuilder().conFechaCita(fechaPasada);

		// Act - Assert
		assertThrows(ExcepcionFecha.class, () -> testDataBuilder.build(), FECHA_DEBE_SER_FUTURO);
	}

	@Test
	void validarHoraCitaFail() throws Exception {
		// Arrange
		Date fechaConHoraInvalida;
		try {
			fechaConHoraInvalida = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("10-12-2020 05:00");
		} catch (ParseException e) {
			fechaConHoraInvalida = Date
					.from(LocalDateTime.of(2020, 12, 15, 5, 0).atZone(ZoneId.systemDefault()).toInstant());
		}
		CitaVeterinariaTestDataBuilder testDataBuilder = new CitaVeterinariaTestDataBuilder()
				.conFechaCita(fechaConHoraInvalida);

		// Act - Assert
		assertThrows(ExcepcionAccionNoPermitida.class, () -> testDataBuilder.build(), FECHA_SELECCIONADA_NO_VALIDA);
	}

	@Test
	void validarHorarioSabado() throws Exception {
		// Arrange
		Date fechaCita;
		try {
			fechaCita = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("12-12-2020 05:00");
		} catch (ParseException e) {
			fechaCita = Date.from(LocalDateTime.of(2020, 12, 12, 5, 0).atZone(ZoneId.systemDefault()).toInstant());
		}
		CitaVeterinariaTestDataBuilder testDataBuilder = new CitaVeterinariaTestDataBuilder().conFechaCita(fechaCita);

		// Act - Assert
		assertThrows(ExcepcionAccionNoPermitida.class, () -> testDataBuilder.build(), FECHA_SELECCIONADA_NO_VALIDA);
	}
	
	@Test
	void validarIncrementoTarifa() throws Exception {
		// Arrange
		Double precioEsperado = new TipoCitaTestDataBuilder().build().getTarifaBasica() * 1.15;
		Date fechaCita;
		try {
			fechaCita = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("12-12-2020 09:00");
		} catch (ParseException e) {
			fechaCita = Date.from(LocalDateTime.of(2020, 12, 12, 5, 0).atZone(ZoneId.systemDefault()).toInstant());
		}
		
		// Act
		CitaVeterinaria cita = new CitaVeterinariaTestDataBuilder().conFechaCita(fechaCita).build();
		

		// Act - Assert
		assertEquals(precioEsperado, cita.getValorFinal());
	}
}
