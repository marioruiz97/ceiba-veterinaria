package com.adn.veterinaria.core.dominio.servicio.operador;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioAsignacionCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroMascota;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroTipoCita;
import com.adn.veterinaria.core.dominio.repositorio.operador.RepositorioRegistroVeterinario;

@Service
public class ServicioAsignacionCita {

	private static final String RECURSO_NO_ENCONTRADO = "%s no se encontró en base de datos, por favor verifique los datos de ingreso";

	private final RepositorioAsignacionCita repositorioAsignacionCita;
	private final RepositorioRegistroTipoCita repositorioTipoCita;
	private final RepositorioRegistroVeterinario repositorioVeterinario;
	private final RepositorioRegistroMascota repositorioRegistroMascotas;

	@Autowired
	public ServicioAsignacionCita(RepositorioAsignacionCita repositorioAsignacionCita,
			RepositorioRegistroTipoCita repositorioTipoCita, RepositorioRegistroVeterinario repositorioVeterinario,
			RepositorioRegistroMascota repositorioRegistroMascotas) {
		this.repositorioAsignacionCita = repositorioAsignacionCita;
		this.repositorioTipoCita = repositorioTipoCita;
		this.repositorioVeterinario = repositorioVeterinario;
		this.repositorioRegistroMascotas = repositorioRegistroMascotas;
	}

	public CitaVeterinaria asignar(Date fechaCita, Long idVeterinario, Long idMascota, Long idTipoCita) {
		// crear objetos para asignar cita
		Veterinario veterinario = repositorioVeterinario.obtenerPorId(idVeterinario);
		Mascota mascota = repositorioRegistroMascotas.obtenerPorId(idMascota);
		TipoCita tipoCita = repositorioTipoCita.obtenerPorId(idTipoCita);

		// validar que la consulta a bd retornó valores
		validarExistencia(veterinario, "El veterinario");
		validarExistencia(mascota, "La mascota");
		validarExistencia(tipoCita, "El tipo de cita");

		CitaVeterinaria citaVeterinaria = CitaVeterinaria.crear(fechaCita, veterinario, mascota, tipoCita);
		return repositorioAsignacionCita.asignar(citaVeterinaria);
	}

	private static void validarExistencia(Object objeto, String campo) {
		if (objeto == null)
			throw new ExcepcionRecursoNoEncontrado(String.format(RECURSO_NO_ENCONTRADO, campo));
	}

}
