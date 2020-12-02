package com.adn.veterinaria.core.infraestructura.persistencia.convertidor;

import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadTipoCita;

public final class ConvertidorTipoCita {

	private ConvertidorTipoCita() {
	}

	public static TipoCita convertirADominio(EntidadTipoCita entidad) {
		TipoCita tipoCita = null;

		if (entidad != null) {
			tipoCita = new TipoCita(entidad.getIdTipoCita(), entidad.getNombre(), entidad.getTarifaBasica(),
					entidad.getDescripcionBreve());
		}
		return tipoCita;
	}

	public static EntidadTipoCita convertirAEntidad(TipoCita dominio) {
		EntidadTipoCita entidadTipo = new EntidadTipoCita();
		entidadTipo.setIdTipoCita(dominio.getIdTipoCita());
		entidadTipo.setNombre(dominio.getNombre());
		entidadTipo.setTarifaBasica(dominio.getTarifaBasica());
		entidadTipo.setDescripcionBreve(dominio.getDescripcionBreve());

		return entidadTipo;
	}
}
