package com.adn.veterinaria.core.infraestructura.controlador.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.comando.ComandoCitaVeterinaria;
import com.adn.veterinaria.core.aplicacion.manejador.ManejadorAsignacionCita;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;

@RestController
@RequestMapping("/citas/asignar")
@CrossOrigin("http://localhost:4200")
public class ControladorAsignacionCita {

	private final ManejadorAsignacionCita manejadorAsignacionCita;

	@Autowired
	public ControladorAsignacionCita(ManejadorAsignacionCita manejadorAsignacionCita) {
		this.manejadorAsignacionCita = manejadorAsignacionCita;
	}

	@PostMapping
	public ResponseEntity<CitaVeterinaria> asignar(@RequestBody ComandoCitaVeterinaria comandoCita) {
		CitaVeterinaria citaVeterinaria = manejadorAsignacionCita.asignar(comandoCita);
		return new ResponseEntity<>(citaVeterinaria, HttpStatus.CREATED);
	}
}
