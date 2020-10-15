package com.br.myfood.cadastro.controller;

import java.util.Objects;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.cadastro.dto.ClienteDto;
import com.br.myfood.cadastro.entity.Cliente;
import com.br.myfood.cadastro.service.ClienteService;

@RequestMapping("/client")
@RestController
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping("/insert")
	public ResponseEntity insertClient(@RequestBody ClienteDto clienteDto) {

		try {

			return ResponseEntity.ok(clienteService.insertCliente(Cliente.create(clienteDto)));

		} catch (Exception e) {
			ResponseEntity.badRequest().body(e);
			return null;
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity updateClient(@PathVariable(name = "id") Long id, @RequestBody ClienteDto clienteDto) {

		Cliente cliente = Cliente.create(clienteDto);
		cliente.setId(id);

		Cliente updateCliente = clienteService.updateCliente(cliente);

		return Objects.nonNull(updateCliente) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteCliente(@PathVariable("id") Long id) {
		return clienteService.deleteCliente(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

	}

	@GetMapping("/find/{id}")
	public ResponseEntity findById(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
		
	}

}
