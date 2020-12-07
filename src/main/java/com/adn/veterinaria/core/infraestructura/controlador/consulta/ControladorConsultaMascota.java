package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.veterinaria.core.aplicacion.consulta.manejador.ManejadorConsultaMascota;
import com.adn.veterinaria.core.dominio.modelo.Mascota;

@RestController
@RequestMapping("/consulta/mascotas")
@CrossOrigin("http://localhost:4200")
public class ControladorConsultaMascota {

	private final ManejadorConsultaMascota manejadorConsultaMascota;

	@Autowired
	public ControladorConsultaMascota(ManejadorConsultaMascota manejadorConsultaMascota) {
		this.manejadorConsultaMascota = manejadorConsultaMascota;
	}

	@GetMapping
	public List<Mascota> obtener() {
		return this.manejadorConsultaMascota.obtener();
	}

	@GetMapping("/{idResponsable}")
	public List<Mascota> obtenerPorResponsable(@PathVariable("idResponsable") Long idResponsable) {
		return this.manejadorConsultaMascota.obtenerPorResponsable(idResponsable);
	}

}
