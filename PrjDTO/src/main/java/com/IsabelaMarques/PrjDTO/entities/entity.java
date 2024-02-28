package com.IsabelaMarques.PrjDTO.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class entity {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		private String titulo;
		
		private String autor;
		
		public record entities(Long id, String titulo, String autor) {
			
		}
		
	}


