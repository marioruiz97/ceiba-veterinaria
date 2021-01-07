package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.consulta.manejador.ManejadorConsultaVeterinario;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;

@RestController
@RequestMapping("/consulta/veterinarios")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class ControladorConsultaVeterinario {

	private final ManejadorConsultaVeterinario manejadorConsultaVeterinario;

	@Autowired
	public ControladorConsultaVeterinario(ManejadorConsultaVeterinario manejadorConsultaVeterinario) {
		this.manejadorConsultaVeterinario = manejadorConsultaVeterinario;
	}

	@GetMapping
	public List<Veterinario> obtener() {
		return this.manejadorConsultaVeterinario.obtener();
	}

	@GetMapping(path = "/{id}")
	public Veterinario obtenerPorId(@PathVariable("id") Long idVeterinario) {
		return this.manejadorConsultaVeterinario.obtenerPorId(idVeterinario);
	}

}
