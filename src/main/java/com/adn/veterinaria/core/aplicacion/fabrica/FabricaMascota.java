package com.adn.veterinaria.core.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.adn.veterinaria.core.aplicacion.comando.ComandoMascota;
import com.adn.veterinaria.core.dominio.modelo.Mascota;

@Component
public class FabricaMascota {

	public Mascota crear(ComandoMascota comando) {
		return new Mascota(comando.getIdMascota(), comando.getNombre(), comando.getFechaNacimiento(), comando.getPeso(),
				comando.getRasgosCaracteristicos());
	}
}
