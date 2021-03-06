package com.adn.veterinaria.core.infraestructura.controlador.consulta;

import com.adn.veterinaria.core.aplicacion.consulta.manejador.ManejadorConsultaCitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.CitaVeterinariaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consulta/citas")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class ControladorConsultaCitaVeterinaria {

    private final ManejadorConsultaCitaVeterinaria manejadorConsultaCita;

    @Autowired
    public ControladorConsultaCitaVeterinaria(ManejadorConsultaCitaVeterinaria manejadorConsultaCita) {
        this.manejadorConsultaCita = manejadorConsultaCita;
    }

    @GetMapping
    public List<CitaVeterinariaDto> obtener() {
        return this.manejadorConsultaCita.obtener();
    }
}
