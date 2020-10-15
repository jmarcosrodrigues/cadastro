package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.entity.Cliente;
import com.br.myfood.cadastro.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente insertCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(Cliente cliente) {

		Optional<Cliente> cli = clienteRepository.findById(cliente.getId());

		if (cli.isPresent()) {
			return clienteRepository.save(cliente);
		} else {
			return null;
		}
	}

	public boolean deleteCliente(Long id) {

		Optional<Cliente> cli = clienteRepository.findById(id);

		if (cli.isPresent()) {
			clienteRepository.delete(cli.get());
			return true;
		} else {
			return false;
		}

	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
		
	}

}
