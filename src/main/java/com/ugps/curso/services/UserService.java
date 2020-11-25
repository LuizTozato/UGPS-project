package com.ugps.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugps.curso.entities.User;
import com.ugps.curso.repositories.UserRepository;

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
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
	
}






