package com.adn.veterinaria.core.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.aplicacion.fabrica.FabricaResponsableMascota;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.servicio.operador.ServicioRegistroResponsableMascota;

@Component
public class ManejadorRegistroResponsableMascota {

	private final ServicioRegistroResponsableMascota servicioResponsableMascota;
	private final FabricaResponsableMascota fabricaResponsable;

	@Autowired
	public ManejadorRegistroResponsableMascota(ServicioRegistroResponsableMascota servicioResponsableMascota,
			FabricaResponsableMascota fabrica) {
		this.servicioResponsableMascota = servicioResponsableMascota;
		this.fabricaResponsable = fabrica;
	}

	@Transactional
	public ResponsableMascota crear(ComandoPersona comando) {
		return servicioResponsableMascota.crear(fabricaResponsable.crear(comando));
	}

	@Transactional
	public ResponsableMascota modificar(ComandoPersona comando) {
		return servicioResponsableMascota.modificar(fabricaResponsable.crear(comando));
	}

}
