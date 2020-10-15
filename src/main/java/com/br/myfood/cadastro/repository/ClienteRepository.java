package com.br.myfood.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.myfood.cadastro.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
