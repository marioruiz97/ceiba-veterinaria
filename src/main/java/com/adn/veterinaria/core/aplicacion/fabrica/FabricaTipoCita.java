package com.adn.veterinaria.core.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;

@Component
public class FabricaTipoCita {

	public TipoCita crear(ComandoTipoCita comandoTipoCita) {
		return new TipoCita(comandoTipoCita.getIdTipoCita(), comandoTipoCita.getNombre(),
				comandoTipoCita.getTarifaBasica(), comandoTipoCita.getDescripcionBreve());
	}
}
