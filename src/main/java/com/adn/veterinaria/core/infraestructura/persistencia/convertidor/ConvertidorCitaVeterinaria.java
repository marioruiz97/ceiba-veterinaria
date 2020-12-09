package com.adn.veterinaria.core.infraestructura.persistencia.convertidor;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinariaDto;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadCitaVeterinaria;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadTipoCita;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadVeterinario;

public final class ConvertidorCitaVeterinaria {

	private ConvertidorCitaVeterinaria() {
	}

	public static CitaVeterinaria convertirADominio(EntidadCitaVeterinaria entidadCita) {
		CitaVeterinaria citaVeterinaria = null;

		if (entidadCita != null) {
			Veterinario veterinario = ConvertidorVeterinario.convertirADominio(entidadCita.getVeterinario());
			Mascota mascota = ConvertidorMascota.convertirADominio(entidadCita.getMascota());
			TipoCita tipoCita = ConvertidorTipoCita.convertirADominio(entidadCita.getTipoCita());
			citaVeterinaria = new CitaVeterinaria(entidadCita.getCodigoCita(), entidadCita.getFechaCita(), veterinario,
					mascota, tipoCita);
		}
		return citaVeterinaria;
	}

	public static CitaVeterinariaDto convertirADTO(EntidadCitaVeterinaria entidadCita) {
		CitaVeterinariaDto citaVeterinaria = null;

		if (entidadCita != null) {
			Veterinario veterinario = ConvertidorVeterinario.convertirADominio(entidadCita.getVeterinario());
			Mascota mascota = ConvertidorMascota.convertirADominio(entidadCita.getMascota());
			TipoCita tipoCita = ConvertidorTipoCita.convertirADominio(entidadCita.getTipoCita());
			citaVeterinaria = new CitaVeterinariaDto(entidadCita.getCodigoCita(), entidadCita.getFechaCita(),
					veterinario, mascota, tipoCita, entidadCita.getValorFinal());
		}
		return citaVeterinaria;
	}

	public static EntidadCitaVeterinaria convertirAEntidad(CitaVeterinaria dominio) {
		EntidadVeterinario veterinario = ConvertidorVeterinario.convertirAEntidad(dominio.getMedicoVeterinario());
		EntidadMascota mascota = ConvertidorMascota.convertirAEntidad(dominio.getMascota());
		EntidadTipoCita tipoCita = ConvertidorTipoCita.convertirAEntidad(dominio.getTipoCita());

		EntidadCitaVeterinaria entidadCita = new EntidadCitaVeterinaria();

		entidadCita.setCodigoCita(dominio.getCodigoCita());
		entidadCita.setFechaCita(dominio.getFechaCita());
		entidadCita.setValorFinal(dominio.getValorFinal());
		entidadCita.setVeterinario(veterinario);
		entidadCita.setMascota(mascota);
		entidadCita.setTipoCita(tipoCita);

		return entidadCita;
	}
}
