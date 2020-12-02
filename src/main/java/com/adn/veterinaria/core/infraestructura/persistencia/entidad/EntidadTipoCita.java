package com.adn.veterinaria.core.infraestructura.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_cita")
@NoArgsConstructor
@Getter
@Setter
public class EntidadTipoCita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoCita;

	private String nombre;
	private Double tarifaBasica;
	private String descripcionBreve;
}
