package com.adn.veterinaria.core.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.adn.veterinaria.core.aplicacion.comando.ComandoMascota;
import com.adn.veterinaria.core.aplicacion.fabrica.FabricaMascota;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroMascota;

@Component
public class ManejadorRegistroMascota {

	private final ServicioRegistroMascota servicioRegistroMascotas;
	private final FabricaMascota fabricaMascota;

	@Autowired
	public ManejadorRegistroMascota(ServicioRegistroMascota servicioRegistroMascotas, FabricaMascota fabricaMascota) {
		this.servicioRegistroMascotas = servicioRegistroMascotas;
		this.fabricaMascota = fabricaMascota;
	}

	@Transactional
	public Mascota crearOModificar(ComandoMascota comandoMascota) {
		return servicioRegistroMascotas.crearOModificar(fabricaMascota.crear(comandoMascota),
				comandoMascota.getIdResponsableMascota());
	}

}