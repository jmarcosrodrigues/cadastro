package com.br.myfood.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.br.myfood.cadastro.dto.RestauranteDto;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_restaurante")
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	private String email;
	private String password;	
	
	public static Restaurante create(RestauranteDto restauranteDto) {
		return new ModelMapper().map(restauranteDto, Restaurante.class);
	} 

}
