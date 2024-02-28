package com.IsabelaMarques.PrjDTO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IsabelaMarques.PrjDTO.entities.entity;


public interface repository extends JpaRepository<entity, Long>{

}