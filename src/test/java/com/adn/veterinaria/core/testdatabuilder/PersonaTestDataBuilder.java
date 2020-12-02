package com.adn.veterinaria.core.testdatabuilder;

import com.adn.veterinaria.core.aplicacion.comando.ComandoPersona;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;

public class PersonaTestDataBuilder {

	private static final String IDENTIFICACION = "1017251545";
	private static final String NOMBRE = "Mario Andres";
	private static final String APELLIDO1 = "Ruiz";
	private static final String APELLIDO2 = "Bedoya";
	private static final String TELEFONO_CONTACTO = "3015465076";

	private Long idPersona;
	private String identificacion;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefonoContacto;

	public PersonaTestDataBuilder() {
		this.idPersona = null;
		this.identificacion = IDENTIFICACION;
		this.nombre = NOMBRE;
		this.apellido1 = APELLIDO1;
		this.apellido2 = APELLIDO2;
		this.telefonoContacto = TELEFONO_CONTACTO;
	}

	public PersonaTestDataBuilder conIdPersona(Long id) {
		this.idPersona = id;
		return this;
	}

	public PersonaTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public PersonaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public PersonaTestDataBuilder conApellido1(String apellido1) {
		this.apellido1 = apellido1;
		return this;
	}

	public PersonaTestDataBuilder conApellido2(String apellido2) {
		this.apellido2 = apellido2;
		return this;
	}

	public PersonaTestDataBuilder conTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
		return this;
	}

	public Veterinario buildVeterinario() {
		return new Veterinario(this.idPersona, this.identificacion, this.nombre, this.apellido1, this.apellido2,
				this.telefonoContacto);
	}

	public ResponsableMascota buildResponsable() {
		return new ResponsableMascota(this.idPersona, this.identificacion, this.nombre, this.apellido1, this.apellido2,
				this.telefonoContacto);
	}

	public ComandoPersona buildComando() {
		return new ComandoPersona(this.idPersona, this.identificacion, this.nombre, this.apellido1, this.apellido2,
				this.telefonoContacto);
	}
}
