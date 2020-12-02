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

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.testdatabuilder.TipoCitaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorRegistroTipoCitaTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void crearTipoCita() throws Exception {

		ComandoTipoCita comandoTipoCita = new TipoCitaTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/operador/tipo-citas")
				.content(objectMapper.writeValueAsString(comandoTipoCita)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	void modificarTipoCita() throws Exception {

		ComandoTipoCita comandoTipoCita = new TipoCitaTestDataBuilder().conNombre("Nombre Cambiado")
				.conTarifaBasica(15500D).conDescripcionBreve("Descripcion cambiada").buildComando();

		mvc.perform(MockMvcRequestBuilders.patch("/operador/tipo-citas/{id}", 1L)
				.content(objectMapper.writeValueAsString(comandoTipoCita)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void eliminarTipoCita() throws Exception {

		Long idTipo = 1L;

		mvc.perform(MockMvcRequestBuilders.delete("/operador/tipo-citas/{id}", idTipo)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
