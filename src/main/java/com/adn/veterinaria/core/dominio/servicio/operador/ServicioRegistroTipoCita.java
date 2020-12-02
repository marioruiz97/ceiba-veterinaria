package com.adn.veterinaria.core.dominio.servicio.operador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionNoSePudoBorrarTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;

@Service
public class ServicioRegistroTipoCita {

	private static final String NO_SE_PUDO_BORRAR_TIPO = "No se pudo eliminar el tipo de cita";

	private final RepositorioRegistroTipoCita repositorioTipoCita;

	@Autowired
	public ServicioRegistroTipoCita(RepositorioRegistroTipoCita repositorioTipoCita) {
		this.repositorioTipoCita = repositorioTipoCita;
	}

	public TipoCita crearOModificar(TipoCita tipoCita) {
		return repositorioTipoCita.crearOModificar(tipoCita);
	}

	public void eliminarPorId(Long idTipo) {
		repositorioTipoCita.eliminarPorId(idTipo);
	}

	@Transactional(readOnly = true)
	public void verificarEliminacion(Long idTipo) {
		if (repositorioTipoCita.obtenerPorId(idTipo) != null)
			throw new ExcepcionNoSePudoBorrarTipoCita(NO_SE_PUDO_BORRAR_TIPO);
	}
}
