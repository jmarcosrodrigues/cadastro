package com.br.myfood.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
	
	private String name;
	private String email;
	private String password;	

}
