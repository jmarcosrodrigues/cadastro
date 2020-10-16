package com.br.myfood.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.myfood.cadastro.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
