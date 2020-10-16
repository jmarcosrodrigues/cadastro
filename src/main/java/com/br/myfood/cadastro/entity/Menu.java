package com.br.myfood.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.br.myfood.cadastro.dto.MenuDto;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurante restaurante;
	
	public static Menu create(MenuDto menuDto) {
		return new ModelMapper().map(menuDto, Menu.class);
	}
	
	

}
