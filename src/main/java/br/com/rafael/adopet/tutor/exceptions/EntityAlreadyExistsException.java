package br.com.rafael.adopet.tutor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class EntityAlreadyExistsException extends Exception {

		public EntityAlreadyExistsException(String message) {
				super(message);
		}

}
