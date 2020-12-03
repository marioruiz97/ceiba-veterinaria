package com.adn.veterinaria.core.aplicacion.comando;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoCitaVeterinaria {

	@Setter
	private Long codigoCita;

	private Date fechaCita;
	private Long idVeterinario;
	private Long idMascota;
	private Long idTipoCita;

}
