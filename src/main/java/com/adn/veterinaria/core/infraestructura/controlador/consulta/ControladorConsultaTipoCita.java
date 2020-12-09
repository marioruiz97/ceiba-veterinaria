package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.consulta.manejador.ManejadorConsultaTipocita;
import com.adn.veterinaria.core.dominio.modelo.TipoCita;

@RestController
@RequestMapping("/consulta/tipo-citas")
@CrossOrigin("http://localhost:4200")
public class ControladorConsultaTipoCita {

	private final ManejadorConsultaTipocita manejadorConsultaTipocita;

	@Autowired
	public ControladorConsultaTipoCita(ManejadorConsultaTipocita manejadorConsultaTipocita) {
		this.manejadorConsultaTipocita = manejadorConsultaTipocita;
	}

	@GetMapping
	public List<TipoCita> obtener() {
		return this.manejadorConsultaTipocita.obtener();
	}

	@GetMapping(path = "/{id}")
	public TipoCita obtenerPorId(@PathVariable("id") Long id) {
		return this.manejadorConsultaTipocita.obtenerPorId(id);
	}
}
