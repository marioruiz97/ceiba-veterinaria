package com.adn.veterinaria.core.dominio.modelo;

import java.util.Date;

import com.adn.veterinaria.core.dominio.modelo.validador.ValidadorArgumento;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Mascota {

	private Long idMascota;
	private String nombre;
	private Date fechaNacimiento;
	private Double peso;
	private String rasgosCaracteristicos;

	@Setter
	private ResponsableMascota responsableMascota;
	
	public Mascota(Long idMascota, String nombre, Date fechaNacimiento, Double peso, String rasgosCaracteristicos) {
		validarDatosDeEntrada(nombre, fechaNacimiento, peso);
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.fechaNacimiento = new Date(fechaNacimiento.getTime());
		this.peso = peso;
		this.rasgosCaracteristicos = rasgosCaracteristicos;
	}

	public Mascota(Long idMascota, String nombre, Date fechaNacimiento, Double peso, String rasgosCaracteristicos,
			ResponsableMascota responsableMascota) {
		validarDatosDeEntrada(nombre, fechaNacimiento, peso);
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.fechaNacimiento = new Date(fechaNacimiento.getTime());
		this.peso = peso;
		this.rasgosCaracteristicos = rasgosCaracteristicos;
		this.responsableMascota = responsableMascota;
	}

	private static void validarDatosDeEntrada(String nombre, Date fechaNacimiento, Double peso) {
		ValidadorArgumento.validarObligatorio(nombre, "El nombre");
		ValidadorArgumento.validarObligatorio(fechaNacimiento, "La fecha");
		ValidadorArgumento.validarFechaPasada(fechaNacimiento);
		ValidadorArgumento.validarObligatorio(peso, "El peso");
		ValidadorArgumento.validarValorNegativo(peso, "El peso");
	}

	

}
