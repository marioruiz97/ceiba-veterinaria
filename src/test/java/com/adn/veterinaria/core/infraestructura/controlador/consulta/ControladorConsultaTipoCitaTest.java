package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.testdatabuilder.TipoCitaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorConsultaTipoCitaTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@BeforeEach
	void ConsultaRegistrosTest() throws Exception {

		ComandoTipoCita comandoTipoCita = new TipoCitaTestDataBuilder()
				.conNombre("CITA GENERAL")
				.buildComando();

		mvc.perform(MockMvcRequestBuilders
				.post("/operador/tipo-citas")
				.content(objectMapper.writeValueAsString(comandoTipoCita))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		mvc.perform(MockMvcRequestBuilders
				.get("/consulta/tipo-citas")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
				/*.andExpect(MockMvcResultMatchers.jsonPath("$.[0].nombre").value("CITA GENERAL"))*/
	}

	@Test
	void consultarTipoPorId() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.get("/consulta/tipo-citas/{id}", 1L)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
