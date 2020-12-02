package com.adn.veterinaria.core.infraestructura.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {

	private String nombreExcepcion;
	private String mensaje;

}
