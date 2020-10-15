package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.entity.Restaurante;
import com.br.myfood.cadastro.repository.RestaurantRepository;

@Service
public class RestauranteService {

	private final RestaurantRepository restaurantRepository;

	@Autowired
	public RestauranteService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public Restaurante insertRestaurante(Restaurante restaurante) {
		return restaurantRepository.save(restaurante);
	}

	public Restaurante updateRestaurante(Restaurante restaurante) {

		Optional<Restaurante> r = restaurantRepository.findById(restaurante.getId());

		if (r.isPresent()) {
			return restaurantRepository.save(restaurante);
		} else {
			return null;
		}
	}

	public boolean deleteRestaurante(Long id) {

		Optional<Restaurante> cli = restaurantRepository.findById(id);

		if (cli.isPresent()) {
			restaurantRepository.delete(cli.get());
			return true;
		} else {
			return false;
		}

	}
	
	public Optional<Restaurante> findById(Long id) {
		return restaurantRepository.findById(id);
		
	}

}
