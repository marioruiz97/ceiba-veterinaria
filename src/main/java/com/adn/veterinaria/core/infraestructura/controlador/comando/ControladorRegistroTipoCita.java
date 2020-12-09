package com.adn.veterinaria.core.infraestructura.controlador.comando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.comando.ComandoTipoCita;
import com.adn.veterinaria.core.aplicacion.manejador.ManejadorRegistroTipoCita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;

@RestController
@RequestMapping("/operador/tipo-citas")
@CrossOrigin("http://localhost:4200")
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
		TipoCita tipoCita = manejadorTipoCita.crear(comandoTipoCita);
		return new ResponseEntity<>(tipoCita, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<TipoCita> modificar(@RequestBody ComandoTipoCita comandoTipoCita, @PathVariable("id") Long idTipo) {
		TipoCita tipoCita = manejadorTipoCita.modificar(comandoTipoCita, idTipo);
		return new ResponseEntity<>(tipoCita, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long idTipo) {
		manejadorTipoCita.eliminarPorId(idTipo);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
