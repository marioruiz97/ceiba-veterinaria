package com.adn.veterinaria.core.infraestructura.controlador;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.adn.veterinaria.core.aplicacion.comando.ComandoCitaVeterinaria;
import com.adn.veterinaria.core.testdatabuilder.CitaVeterinariaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorAsignacionCitaTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void asignarCita() throws Exception {

		ComandoCitaVeterinaria comandoCita = new CitaVeterinariaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/citas/asignar")
				.content(objectMapper.writeValueAsString(comandoCita))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
}
