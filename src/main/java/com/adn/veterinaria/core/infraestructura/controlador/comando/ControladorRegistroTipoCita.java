package com.adn.veterinaria.core.infraestructura.controlador.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.aplicacion.manejador.ManejadorRegistroTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;

@RestController
@RequestMapping("/operador/tipo-citas")
public class ControladorRegistroTipoCita {

	private final ManejadorRegistroTipoCita manejadorTipoCita;

	@Autowired
	public ControladorRegistroTipoCita(ManejadorRegistroTipoCita manejadorTipoCita) {
		this.manejadorTipoCita = manejadorTipoCita;
	}

	@PostMapping
	public ResponseEntity<TipoCita> crear(@RequestBody ComandoTipoCita comandoTipoCita) {
		// asegurarse que se ejecutará una creación
		comandoTipoCita.setIdTipoCita(null);
		TipoCita result = manejadorTipoCita.crear(comandoTipoCita);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<TipoCita> modificar(@RequestBody ComandoTipoCita comandoTipoCita,
			@PathVariable("id") Long idTipo) {
		TipoCita result = manejadorTipoCita.modificar(comandoTipoCita, idTipo);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long idTipo) {
		manejadorTipoCita.eliminarPorId(idTipo);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
