package com.adn.veterinaria.core.dominio.repositorio.operador;

import com.adn.veterinaria.core.dominio.modelo.TipoCita;

public interface RepositorioRegistroTipoCita {

	public TipoCita crearOModificar(TipoCita tipoCita);

	public void eliminarPorId(Long idTipo);

	public TipoCita obtenerPorId(Long idTipo);

}
