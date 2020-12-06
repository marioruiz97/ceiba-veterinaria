package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.consulta.manejador.ManejadorConsultaResponsableMascota;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;

@RestController
@RequestMapping("/consulta/responsables")
@CrossOrigin("http://localhost:4200")
public class ControladorConsultaResponsablesMascotas {

	private final ManejadorConsultaResponsableMascota manejadorConsultaResponsable;

	@Autowired
	public ControladorConsultaResponsablesMascotas(ManejadorConsultaResponsableMascota manejadorConsultaResponsable) {
		this.manejadorConsultaResponsable = manejadorConsultaResponsable;
	}

	@GetMapping
	public List<ResponsableMascota> obtener() {
		return this.manejadorConsultaResponsable.obtener();
	}

	@GetMapping(path = "/{id}")
	public ResponsableMascota obtenerPorId(@PathVariable("id") Long idResponsable) {
		return this.manejadorConsultaResponsable.obtenerPorId(idResponsable);
	}

}
