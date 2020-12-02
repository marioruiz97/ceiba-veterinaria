package com.adn.veterinaria.core.infraestructura.persistencia.convertidor;

import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadResponsableMascota;

public final class ConvertidorResponsableMascota {

	private ConvertidorResponsableMascota() {
	}

	public static ResponsableMascota convertirADominio(EntidadResponsableMascota entidad) {
		ResponsableMascota responsableMascota = null;

		if (entidad != null) {
			responsableMascota = new ResponsableMascota(entidad.getId(), entidad.getIdentificacion(),
					entidad.getNombre(), entidad.getApellido1(), entidad.getApellido2(), entidad.getTelefonoContacto());
		}

		return responsableMascota;
	}

	public static EntidadResponsableMascota convertirAEntidad(ResponsableMascota dominio) {
		EntidadResponsableMascota entidadResponsable = new EntidadResponsableMascota();
		entidadResponsable.setId(dominio.getIdResponsable());
		entidadResponsable.setIdentificacion(dominio.getIdentificacion());
		entidadResponsable.setNombre(dominio.getNombre());
		entidadResponsable.setApellido1(dominio.getApellido1());
		entidadResponsable.setApellido2(dominio.getApellido2());
		entidadResponsable.setTelefonoContacto(dominio.getTelefonoContacto());

		return entidadResponsable;
	}
}
