package com.ugps.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugps.curso.entities.Order;
import com.ugps.curso.entities.Order;
import com.ugps.curso.repositories.OrderRepository;

//registramos a classe como Component para que ela seja um componente do Spring e assim seja injetado automaticamente com autowired
@Service
public class OrderService {
	//aqui vamos montar duas operações: 1) buscar todos os users; 2) buscar user por id;
	
	//essa anotation é para o spring fazer a injeção de dependência independente do programador
	@Autowired 
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	//aqui vamos usar o recurso do objeto Optional. O comando get pega o objeto do tipo que está entre <>
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
}






