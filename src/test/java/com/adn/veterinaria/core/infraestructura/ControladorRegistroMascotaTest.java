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

import com.adn.veterinaria.core.aplicacion.comando.ComandoMascota;
import com.adn.veterinaria.core.testdatabuilder.MascotaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorRegistroMascotaTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void crearMascota() throws Exception {

		ComandoMascota comandoMascota = new MascotaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/operador/mascotas")
				.content(objectMapper.writeValueAsString(comandoMascota))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	void modificarMascota() throws Exception {

		ComandoMascota comandoMascota = new MascotaTestDataBuilder()
				.conPeso(3.5D)
				.conRasgosCaracteristicos("Juguetona, un poco baja para su edad")
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.patch("/operador/mascotas/{id}", 1L)
				.content(objectMapper.writeValueAsString(comandoMascota))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void crearMascotaConResponsableNoEncontradoTest() throws Exception {
		ComandoMascota comandoMascota = new MascotaTestDataBuilder()
				.conResponsableMascota(0L)
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/operador/mascotas")
				.content(objectMapper.writeValueAsString(comandoMascota))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	void modificarMascotaConResponsableNoEncontradoTest() throws Exception {
		ComandoMascota comandoMascota = new MascotaTestDataBuilder()
				.conResponsableMascota(0L)
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.patch("/operador/mascotas/{id}", 1L)
				.content(objectMapper.writeValueAsString(comandoMascota))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}
