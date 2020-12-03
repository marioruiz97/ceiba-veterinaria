package com.adn.veterinaria.core.infraestructura.convertidor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adn.veterinaria.core.dominio.modelo.CitaVeterinaria;
import com.adn.veterinaria.core.dominio.modelo.Mascota;
import com.adn.veterinaria.core.dominio.modelo.ResponsableMascota;
import com.adn.veterinaria.core.dominio.modelo.Veterinario;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorCitaVeterinaria;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.convertidor.ConvertidorVeterinario;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadCitaVeterinaria;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadResponsableMascota;
import com.adn.veterinaria.core.infraestructura.persistencia.entidad.EntidadVeterinario;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ConvertidorTest {

	@Test
	void convertidorMascotaTest() {
		// Arrange
		EntidadMascota mascotaEntidad = null;
		// Act
		Mascota mascota = ConvertidorMascota.convertirADominio(mascotaEntidad);
		// Assert
		assertThat(mascota).isNull();
	}

	@Test
	void convertidorVeterinarioTest() {
		// Arrange
		EntidadVeterinario veterinarioEntidad = null;
		// Act
		Veterinario veterinario = ConvertidorVeterinario.convertirADominio(veterinarioEntidad);
		// Assert
		assertThat(veterinario).isNull();
	}

	@Test
	void convertidorResponsableTest() {
		// Arrange
		EntidadResponsableMascota responsableEntidad = null;
		// Act
		ResponsableMascota responsable = ConvertidorResponsableMascota.convertirADominio(responsableEntidad);
		// Assert
		assertThat(responsable).isNull();
	}

	@Test
	void convertidorCitaVeterinariaTest() {
		// Arrange
		EntidadCitaVeterinaria citaEntidad = null;
		// Act
		CitaVeterinaria citaVeterinaria = ConvertidorCitaVeterinaria.convertirADominio(citaEntidad);
		// Assert
		assertThat(citaVeterinaria).isNull();
	}

}
