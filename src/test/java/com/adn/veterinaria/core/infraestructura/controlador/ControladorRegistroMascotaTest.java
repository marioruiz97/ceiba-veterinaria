package com.adn.veterinaria.core.infraestructura.controlador;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
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
import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.testdatabuilder.MascotaTestDataBuilder;
import com.adn.veterinaria.core.testdatabuilder.PersonaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorRegistroMascotaTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;
	

	@BeforeEach
	void before() throws Exception {
		long randomId = Math.round((Math.random()*100));
		ComandoPersona comandoResponsable = new PersonaTestDataBuilder()
				.conIdentificacion("1017231" + randomId)
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/operador/responsables")
				.content(objectMapper.writeValueAsString(comandoResponsable))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
				
	}

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
				.put("/operador/mascotas/{id}", 1L)
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
				.put("/operador/mascotas/{id}", 1L)
				.content(objectMapper.writeValueAsString(comandoMascota))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}
