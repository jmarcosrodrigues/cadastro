package com.br.myfood.cadastro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.cadastro.dto.ClienteDto;

@RequestMapping("/client")
@RestController
public class ClienteController {
	
	@PostMapping("insert")
	public ClienteDto insertClient(@RequestBody ClienteDto clienteDto) {
		return clienteDto;
		
		
	}

	

}
