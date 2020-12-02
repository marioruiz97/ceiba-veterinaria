package com.adn.veterinaria.core.dominio.modelo;

import com.adn.veterinaria.core.dominio.modelo.validador.ValidadorArgumento;

import lombok.Getter;

@Getter
public abstract class Persona {

	protected String identificacion;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String telefonoContacto;

	public Persona(String identificacion, String nombre, String apellido1, String apellido2, String telefonoContacto) {

		ValidadorArgumento.validarObligatorio(identificacion, "La identificacion");
		ValidadorArgumento.validarObligatorio(nombre, "El nombre");
		ValidadorArgumento.validarObligatorio(apellido1, "El primer apellido");
		ValidadorArgumento.validarObligatorio(telefonoContacto, "El telefono");
		ValidadorArgumento.validarFormatoTelefono(telefonoContacto);

		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefonoContacto = telefonoContacto;
	}

}
