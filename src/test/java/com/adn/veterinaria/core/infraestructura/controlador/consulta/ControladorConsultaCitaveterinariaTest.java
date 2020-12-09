package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControladorConsultaCitaveterinariaTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void obtener() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/consulta/citas")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
