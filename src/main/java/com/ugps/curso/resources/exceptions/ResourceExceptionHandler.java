package com.ugps.curso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ugps.curso.services.exceptions.DatabaseException;
import com.ugps.curso.services.exceptions.ResourceNotFoundException;

@ControllerAdvice //isso aqui é o que vai interceptar as exceções que vão estourar
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) 
	//essa anotation permite que esse método abaixo vai interceptar exceção do tipo ResourceNotFoundException e tratar.
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(DatabaseException.class) 
	//essa anotation permite que esse método abaixo vai interceptar exceção do tipo ResourceNotFoundException e tratar.
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	
}
