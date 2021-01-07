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

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.aplicacion.manejador.ManejadorRegistroResponsableMascota;
import com.adn.veterinaria.core.aplicacion.manejador.ManejadorRegistroVeterinario;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;

@RestController
@RequestMapping("/operador/")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class ControladorRegistroPersona {

	private static final String PATH_VETERINARIO = "veterinarios";
	private static final String PATH_RESPONSABLE = "responsables";

	private final ManejadorRegistroResponsableMascota manejadorRegistroResponsable;
	private final ManejadorRegistroVeterinario manejadorRegistroVeterinario;

	@Autowired
	public ControladorRegistroPersona(ManejadorRegistroResponsableMascota manejadorRegistroResponsable,
			ManejadorRegistroVeterinario manejadorRegistroVeterinario) {
		this.manejadorRegistroResponsable = manejadorRegistroResponsable;
		this.manejadorRegistroVeterinario = manejadorRegistroVeterinario;
	}

	@PostMapping(path = PATH_VETERINARIO)
	public ResponseEntity<Veterinario> crearVeterinario(@RequestBody ComandoPersona comandoVeterinario) {
		comandoVeterinario.setIdPersona(null);
		Veterinario veterinario = manejadorRegistroVeterinario.crear(comandoVeterinario);
		return new ResponseEntity<>(veterinario, HttpStatus.CREATED);
	}

	@PutMapping(path = PATH_VETERINARIO + "/{id}")
	public ResponseEntity<Veterinario> actualizarVeterinario(@PathVariable("id") Long idVeterinario,
			@RequestBody ComandoPersona comandoVeterinario) {
		comandoVeterinario.setIdPersona(idVeterinario);
		Veterinario result = manejadorRegistroVeterinario.modificar(comandoVeterinario);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping(path = PATH_RESPONSABLE)
	public ResponseEntity<ResponsableMascota> crearResponsable(@RequestBody ComandoPersona comandoPersona) {
		comandoPersona.setIdPersona(null);
		ResponsableMascota result = manejadorRegistroResponsable.crear(comandoPersona);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PutMapping(path = PATH_RESPONSABLE + "/{id}")
	public ResponseEntity<ResponsableMascota> actualizarResponsable(@PathVariable("id") Long idResponsable,
			@RequestBody ComandoPersona comandoResponsableMascota) {
		comandoResponsableMascota.setIdPersona(idResponsable);
		ResponsableMascota result = manejadorRegistroResponsable.modificar(comandoResponsableMascota);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
