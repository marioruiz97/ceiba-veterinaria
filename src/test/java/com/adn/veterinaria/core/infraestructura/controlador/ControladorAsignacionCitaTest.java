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

import com.adn.veterinaria.core.aplicacion.comando.ComandoCitaVeterinaria;
import com.adn.veterinaria.core.aplicacion.comando.ComandoMascota;
import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.testdatabuilder.CitaVeterinariaTestDataBuilder;
import com.adn.veterinaria.core.testdatabuilder.MascotaTestDataBuilder;
import com.adn.veterinaria.core.testdatabuilder.PersonaTestDataBuilder;
import com.adn.veterinaria.core.testdatabuilder.TipoCitaTestDataBuilder;
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
	@BeforeEach
	void before() throws Exception {
		long randomId = Math.round((Math.random() * 100));
		ComandoPersona comandoResponsable = new PersonaTestDataBuilder()
				.conIdentificacion("1017231" + randomId)
				.buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/operador/responsables")
				.content(objectMapper.writeValueAsString(comandoResponsable))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		ComandoMascota comandoMascota = new MascotaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/operador/mascotas")
				.content(objectMapper.writeValueAsString(comandoMascota))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		ComandoPersona comandoVeterinario = new PersonaTestDataBuilder()
				.conIdentificacion("875455" + randomId)
				.buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/operador/veterinarios")
				.content(objectMapper.writeValueAsString(comandoVeterinario))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		ComandoTipoCita comandoTipoCita = new TipoCitaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/operador/tipo-citas")
				.content(objectMapper.writeValueAsString(comandoTipoCita))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	void asignarCita() throws Exception {

		ComandoCitaVeterinaria comandoCita = new CitaVeterinariaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/citas/asignar").content(objectMapper.writeValueAsString(comandoCita))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
}
