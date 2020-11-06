package com.ugps.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugps.curso.entities.Product;
import com.ugps.curso.repositories.ProductRepository;

//registramos a classe como Component para que ela seja um componente do Spring e assim seja injetado automaticamente com autowired
@Service
public class ProductService {
	//aqui vamos montar duas operações: 1) buscar todos os products; 2) buscar products por id;
	
	//essa anotation é para o spring fazer a injeção de dependência independente do programador
	@Autowired 
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	//aqui vamos usar o recurso do objeto Optional. O comando get pega o objeto do tipo que está entre <>
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
}






