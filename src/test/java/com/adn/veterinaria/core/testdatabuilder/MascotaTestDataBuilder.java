package com.adn.veterinaria.core.testdatabuilder;

import java.util.Calendar;
import java.util.Date;

import com.adn.veterinaria.core.aplicacion.comando.ComandoMascota;
import com.adn.veterinaria.core.dominio.modelo.Mascota;

public class MascotaTestDataBuilder {

	private static final String NOMBRE = "Nala Ruiz";
	private static final Date FECHA_NACIMIENTO;
	private static final Double PESO = 2.5D;
	private static final String RASGOS_CARACTERISTICOS = "Golden retriever saludable";
	private static final Long RESPONSABLE_MASCOTA = 1L;

	private Long idMascota;
	private String nombre;
	private Date fechaNacimiento;
	private Double peso;
	private String rasgosCaracteristicos;
	private Long responsableMascota;

	static {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 9, 1);
		FECHA_NACIMIENTO = calendar.getTime();
	}

	public MascotaTestDataBuilder() {
		this.idMascota = null;
		this.nombre = NOMBRE;
		this.fechaNacimiento = FECHA_NACIMIENTO;
		this.peso = PESO;
		this.rasgosCaracteristicos = RASGOS_CARACTERISTICOS;
		this.responsableMascota = RESPONSABLE_MASCOTA;
	}

	public MascotaTestDataBuilder conIdMascota(Long id) {
		this.idMascota = id;
		return this;
	}

	public MascotaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public MascotaTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public MascotaTestDataBuilder conPeso(Double peso) {
		this.peso = peso;
		return this;
	}

	public MascotaTestDataBuilder conRasgosCaracteristicos(String rasgosCaracteristicos) {
		this.rasgosCaracteristicos = rasgosCaracteristicos;
		return this;
	}

	public MascotaTestDataBuilder conResponsableMascota(Long responsableMascota) {
		this.responsableMascota = responsableMascota;
		return this;
	}

	public Mascota build() {
		return new Mascota(this.idMascota, this.nombre, this.fechaNacimiento, this.peso, this.rasgosCaracteristicos);
	}

	public ComandoMascota buildComando() {
		return new ComandoMascota(this.idMascota, this.nombre, this.fechaNacimiento, this.peso,
				this.rasgosCaracteristicos, this.responsableMascota);
	}
}
