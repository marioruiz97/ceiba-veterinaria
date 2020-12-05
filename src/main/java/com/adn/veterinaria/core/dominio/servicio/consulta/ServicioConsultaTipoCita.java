package com.adn.veterinaria.core.dominio.servicio.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.repositorio.consulta.RepositorioConsultaTipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;

@Service
public class ServicioConsultaTipoCita {

	private final RepositorioConsultaTipoCita repositorioConsultaTipoCita;
	private final RepositorioRegistroTipoCita repositorioRegistroTipoCita;

	@Autowired
	public ServicioConsultaTipoCita(RepositorioConsultaTipoCita repositorioConsultaTipoCita,
			RepositorioRegistroTipoCita repositorioRegistroTipoCita) {
		this.repositorioConsultaTipoCita = repositorioConsultaTipoCita;
		this.repositorioRegistroTipoCita = repositorioRegistroTipoCita;
	}

	public List<TipoCita> obtener() {
		List<TipoCita> tipos = this.repositorioConsultaTipoCita.obtener();
		if (tipos.isEmpty())
			throw new ExcepcionRecursoNoEncontrado();
		return tipos;

	}

	public TipoCita obtenerPorId(Long idTipo) {
		TipoCita tipo = this.repositorioRegistroTipoCita.obtenerPorId(idTipo);
		if (tipo == null)
			throw new ExcepcionRecursoNoEncontrado();
		return tipo;
	}
}
