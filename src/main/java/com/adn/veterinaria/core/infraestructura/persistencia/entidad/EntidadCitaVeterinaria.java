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
@Table(name = "cita_veterinaria")
@NoArgsConstructor
@Getter
@Setter
public class EntidadCitaVeterinaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoCita;

	private Date fechaCita;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_veterinario")
	private EntidadVeterinario veterinario;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_mascota")
	private EntidadMascota mascota;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_cita")
	private EntidadTipoCita tipoCita;

	private Double valorFinal;
}
