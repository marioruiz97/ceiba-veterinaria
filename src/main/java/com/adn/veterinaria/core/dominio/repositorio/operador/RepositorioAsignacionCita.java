package com.adn.veterinaria.core.dominio.repositorio.operador;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;

public interface RepositorioAsignacionCita {

	public CitaVeterinaria asignar(CitaVeterinaria citaVeterinaria);

	public boolean aplicarDescuento(Long idMascota);

}
