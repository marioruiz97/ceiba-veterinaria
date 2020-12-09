package com.adn.veterinaria.core.infraestructura.controlador.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.comando.ComandoMascota;
import com.adn.veterinaria.core.aplicacion.manejador.ManejadorRegistroMascota;
import com.adn.veterinaria.core.dominio.modelo.Mascota;

@RestController
@RequestMapping("/operador/mascotas")
@CrossOrigin("http://localhost:4200")
public class ControladorRegistroMascota {

	private final ManejadorRegistroMascota manejadorRegistroMascota;

	@Autowired
	public ControladorRegistroMascota(ManejadorRegistroMascota manejadorRegistroMascota) {
		this.manejadorRegistroMascota = manejadorRegistroMascota;
	}

	@PostMapping
	public ResponseEntity<Mascota> crearMascota(@RequestBody ComandoMascota comandoMascota) {
		comandoMascota.setIdMascota(null);
		Mascota result = manejadorRegistroMascota.crearOModificar(comandoMascota);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Mascota> modificarMascota(@RequestBody ComandoMascota comandoMascota,
			@PathVariable("id") Long idMascota) {
		comandoMascota.setIdMascota(idMascota);
		Mascota result = manejadorRegistroMascota.crearOModificar(comandoMascota);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
