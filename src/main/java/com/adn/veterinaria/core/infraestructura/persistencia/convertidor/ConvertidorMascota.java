package com.adn.veterinaria.core.infraestructura.persistencia.convertidor;

import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadResponsableMascota;

public final class ConvertidorMascota {

	private ConvertidorMascota() {
	}

	public static Mascota convertirADominio(EntidadMascota entidad) {
		Mascota mascota = null;

		if (entidad != null) {
			ResponsableMascota responsable = ConvertidorResponsableMascota
					.convertirADominio(entidad.getResponsableMascota());
			mascota = new Mascota(entidad.getId(), entidad.getNombre(), entidad.getFechaNacimiento(), entidad.getPeso(),
					entidad.getRasgosCaracteristicos(), responsable);
		}
		return mascota;
	}

	public static EntidadMascota convertirAEntidad(Mascota dominio) {
		EntidadMascota entidadMascota = new EntidadMascota();
		entidadMascota.setId(dominio.getIdMascota());
		entidadMascota.setNombre(dominio.getNombre());
		entidadMascota.setFechaNacimiento(dominio.getFechaNacimiento());
		entidadMascota.setPeso(dominio.getPeso());
		entidadMascota.setRasgosCaracteristicos(dominio.getRasgosCaracteristicos());
		EntidadResponsableMascota responsable = ConvertidorResponsableMascota
				.convertirAEntidad(dominio.getResponsableMascota());
		entidadMascota.setResponsableMascota(responsable);

		return entidadMascota;
	}
}
