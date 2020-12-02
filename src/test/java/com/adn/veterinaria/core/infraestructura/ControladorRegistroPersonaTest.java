package com.adn.veterinaria.core.infraestructura;

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

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.testdatabuilder.PersonaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorRegistroPersonaTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void crearVeterinario() throws Exception {

		ComandoPersona comandoVeterinario = new PersonaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/operador/veterinarios")
				.content(objectMapper.writeValueAsString(comandoVeterinario))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	void modificarVeterinario() throws Exception {

		ComandoPersona comandoVeterinario = new PersonaTestDataBuilder()
				.conTelefonoContacto("3007855772")
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.patch("/operador/veterinarios/{id}", 1L)
				.content(objectMapper.writeValueAsString(comandoVeterinario))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void crearResponsable() throws Exception {

		ComandoPersona comandoResponsable = new PersonaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/operador/responsables")
				.content(objectMapper.writeValueAsString(comandoResponsable))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	void modificarResponsable() throws Exception {

		ComandoPersona comandoVeterinario = new PersonaTestDataBuilder()
				.conIdentificacion("43032118")
				.conTelefonoContacto("3007855772")
				.conApellido2("Giraldo")
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.patch("/operador/responsables/{id}", 1L)
				.content(objectMapper.writeValueAsString(comandoVeterinario))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
