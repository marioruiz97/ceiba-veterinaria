package com.adn.veterinaria.core.infraestructura.persistencia.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mascota")
@NoArgsConstructor
@Getter
@Setter
public class EntidadMascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private Date fechaNacimiento;
	private Double peso;
	private String rasgosCaracteristicos;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_responsable_mascota")
	private EntidadResponsableMascota responsableMascota;
	
}