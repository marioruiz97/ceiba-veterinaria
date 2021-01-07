package com.adn.veterinaria.core.infraestructura.controlador.health_check;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class ControladorHealthCheck {

    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Server running", HttpStatus.OK);
    }
}
