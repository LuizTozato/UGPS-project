package com.ugps.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ugps.curso.entities.Category;
import com.ugps.curso.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping //indica que será usado um comenado Get
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//tenho que indicar para que haverá um "id" dentro do url da requisição 
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){ //para o spring aceitar o id, tenho que declarar o PathVariable 
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}



