package com.ugps.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugps.curso.entities.Category;
import com.ugps.curso.repositories.CategoryRepository;

//registramos a classe como Component para que ela seja um componente do Spring e assim seja injetado automaticamente com autowired
@Service
public class CategoryService {
	//aqui vamos montar duas operações: 1) buscar todos as categorias; 2) buscar categoria por id;
	
	//essa anotation é para o spring fazer a injeção de dependência independente do programador
	@Autowired 
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	//aqui vamos usar o recurso do objeto Optional. O comando get pega o objeto do tipo que está entre <>
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
}






