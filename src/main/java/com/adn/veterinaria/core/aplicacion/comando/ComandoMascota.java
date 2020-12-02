package com.adn.veterinaria.core.aplicacion.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ComandoMascota {

	@Setter
	private Long idMascota;
	private String nombre;
	private Date fechaNacimiento;
	private Double peso;
	private String rasgosCaracteristicos;
	private Long idResponsableMascota;

}
