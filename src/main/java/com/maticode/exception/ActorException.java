package com.maticode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ActorException extends Exception {

	private static final long serialVersionUID = 1L;

	public ActorException(String mensaje) {
		super(mensaje);
	}

}
