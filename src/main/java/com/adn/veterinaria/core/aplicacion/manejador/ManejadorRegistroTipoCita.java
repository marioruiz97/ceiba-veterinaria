package com.adn.veterinaria.core.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.aplicacion.fabrica.FabricaTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroTipoCita;

@Component
public class ManejadorRegistroTipoCita {

	private final ServicioRegistroTipoCita servicioTipoCita;
	private final FabricaTipoCita fabricaTipoCita;

	@Autowired
	public ManejadorRegistroTipoCita(ServicioRegistroTipoCita servicioTipoCita, FabricaTipoCita fabricaTipoCita) {
		this.servicioTipoCita = servicioTipoCita;
		this.fabricaTipoCita = fabricaTipoCita;
	}

	@Transactional
	public TipoCita crear(ComandoTipoCita comandoTipoCita) {
		TipoCita tipoCita = fabricaTipoCita.crear(comandoTipoCita);
		return servicioTipoCita.crearOModificar(tipoCita);
	}

	@Transactional
	public TipoCita modificar(ComandoTipoCita comandoTipoCita, Long idTipo) {
		TipoCita tipoCita = fabricaTipoCita.crear(comandoTipoCita);
		tipoCita.setIdTipoCita(idTipo);
		return servicioTipoCita.crearOModificar(tipoCita);
	}

	@Transactional
	public void eliminarPorId(Long idTipo) {
		servicioTipoCita.eliminarPorId(idTipo);
		servicioTipoCita.verificarEliminacion(idTipo);
	}
}
