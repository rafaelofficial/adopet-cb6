package br.com.rafael.adopet.tutor.exceptions.handlers;

import br.com.rafael.adopet.tutor.exceptions.EntityAlreadyExistsException;
import br.com.rafael.adopet.tutor.exceptions.ResourceNotFoundException;
import br.com.rafael.adopet.tutor.exceptions.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
				var errorDetails = new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		}

		@ExceptionHandler(EntityAlreadyExistsException.class)
		public ResponseEntity<?> entityAlreadyExistsException(EntityAlreadyExistsException ex, WebRequest request) {
				var errorDetails = new ErrorResponse(new Date(), HttpStatus.UNPROCESSABLE_ENTITY.toString(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
				var errorDetails = new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
