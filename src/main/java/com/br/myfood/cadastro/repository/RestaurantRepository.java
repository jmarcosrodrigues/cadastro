package com.br.myfood.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.myfood.cadastro.entity.Restaurante;

public interface RestaurantRepository extends JpaRepository<Restaurante, Long> {

}
