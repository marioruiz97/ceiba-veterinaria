package com.adn.veterinaria.core.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adn.veterinaria.core.dominio.excepcion.ExcepcionNoSePudoBorrarTipoCita;
import com.adn.veterinaria.core.dominio.excepcion.ExcepcionResponsableNoEncontrado;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ManejadorError() {
		CODIGOS_ESTADO.put(ExcepcionResponsableNoEncontrado.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
		CODIGOS_ESTADO.put(ExcepcionNoSePudoBorrarTipoCita.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiError> handleAllExceptions(Exception exception) {
		ResponseEntity<ApiError> resultado;

		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

		if (codigo != null) {
			ApiError error = new ApiError(excepcionNombre, mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
			ApiError error = new ApiError(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resultado;
	}
}