package com.adn.veterinaria.core.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionNoSePudoBorrarTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroTipoCita;
import com.adn.veterinaria.core.testdatabuilder.TipoCitaTestDataBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ServicioRegistroTipoCitaTest {

	private static final String NO_SE_PUDO_BORRAR_TIPO = "No se pudo eliminar el tipo de cita";

	@Test
	void eliminarTipoCita() throws Exception {

		// arrange
		TipoCita tipoCita = new TipoCitaTestDataBuilder().build();
		Long idTipo = 1L;

		RepositorioRegistroTipoCita repositorio = mock(RepositorioRegistroTipoCita.class);

		when(repositorio.obtenerPorId(idTipo)).thenReturn(tipoCita);

		ServicioRegistroTipoCita servicio = new ServicioRegistroTipoCita(repositorio);

		// act - assert
		servicio.eliminarPorId(idTipo);
		verify(repositorio).eliminarPorId(idTipo);

	}

	@Test
	void verificarEliminarTipoCitaException() throws Exception {

		// arrange
		TipoCita tipoCita = new TipoCitaTestDataBuilder().build();
		Long idTipo = 1L;

		RepositorioRegistroTipoCita repositorio = mock(RepositorioRegistroTipoCita.class);

		when(repositorio.obtenerPorId(idTipo)).thenReturn(tipoCita);

		ServicioRegistroTipoCita servicio = new ServicioRegistroTipoCita(repositorio);

		// act - assert
		assertThrows(ExcepcionNoSePudoBorrarTipoCita.class, () -> servicio.verificarEliminacion(idTipo),
				NO_SE_PUDO_BORRAR_TIPO);

	}

}
