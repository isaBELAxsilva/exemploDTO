package com.IsabelaMarques.PrjDTO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IsabelaMarques.PrjDTO.entities.entity;
import com.IsabelaMarques.PrjDTO.repositories.repository;


@Service
public class service {
	
	private final repository repositories;
	
	@Autowired
	public service(repository repositories) {
		this.repositories = repositories;
	}
	
	public entity salvar(entity entities) {
		entity salvarEntity = repositories.save(entities);
		return new entity(salvarEntity.getId(), salvarEntity.getTitulo(), salvarEntity.getAutor());
	}
	
	public entity atualizar(Long id, entity entities) {
		entity existeEntity = repositories.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
		existeEntity.setTitulo(entities.getTitulo());
		existeEntity.setAutor(entities.getAutor());
		entity updatedEntity = repositories.save(existeEntity);
		return new entity(updatedEntity.getId(), updatedEntity.getTitulo(), updatedEntity.getAutor());
	}
	
	public boolean deletar(Long id) {
		Optional <entity> existeCliente = repositories.findById(id);
		if(existeCliente.isPresent()) {
			repositories.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<entity> buscarTodos(){
		return repositories.findAll();
	}
	
	public entity buscarPorId(Long id) {
		Optional <entity> Entity = repositories.findById(id);
		return Entity.orElse(null);
	}
	
}
