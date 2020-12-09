package com.adn.veterinaria.core.dominio.modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CitaVeterinariaDto {

	private Long codigoCita;
	private Date fechaCita;
	private Veterinario medicoVeterinario;
	private Mascota mascota;
	private TipoCita tipoCita;
	private Double valorFinal;
}
