package com.IsabelaMarques.PrjDTO.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IsabelaMarques.PrjDTO.entities.entity;
import com.IsabelaMarques.PrjDTO.services.service;


@RestController
@RequestMapping("/livros")
public class controller {
	
	private final service services;
	
	@Autowired
	public controller(service services) {
		this.services = services;
	}
	
	@PostMapping
	public ResponseEntity<entity> criar(@RequestBody @Validated entity entities){
		entity salvarEntity = services.salvar(entities);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvarEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<entity> alteraClienteControl(@PathVariable Long id, @RequestBody @Validated entity entities){
		entity altera = services.atualizar(id, entities);
		if(altera != null) {
			return ResponseEntity.ok(altera);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<entity> buscarLivroPorId(@PathVariable Long id){
		boolean apagar = services.deletar(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<List<entity>> buscaTodosLivros(){
		List<entity> Entity = services.buscarTodos();
		return ResponseEntity.ok(Entity);
	}

}
