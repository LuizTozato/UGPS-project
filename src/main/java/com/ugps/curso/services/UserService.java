package com.ugps.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ugps.curso.entities.User;
import com.ugps.curso.repositories.UserRepository;
import com.ugps.curso.services.exceptions.DatabaseException;
import com.ugps.curso.services.exceptions.ResourceNotFoundException;

//registramos a classe como Component para que ela seja um componente do Spring e assim seja injetado automaticamente com autowired
@Service
public class UserService {
	//aqui vamos montar duas operações: 1) buscar todos os users; 2) buscar user por id;
	
	//essa anotation é para o spring fazer a injeção de dependência independente do programador
	@Autowired 
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//aqui vamos usar o recurso do objeto Optional. O comando get pega o objeto do tipo que está entre <>
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id); //getOne não pega o objeto mas deixa ele em monitoramento.
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}






