package com.ugps.curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//vou passar para a função o id da pessoa que eu não encontrei
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id :" + id); //veja que a superclasse é a RuntimeException
	}
	
}
