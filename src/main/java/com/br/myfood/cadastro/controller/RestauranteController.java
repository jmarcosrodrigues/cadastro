package com.br.myfood.cadastro.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.cadastro.dto.RestauranteDto;
import com.br.myfood.cadastro.entity.Restaurante;
import com.br.myfood.cadastro.service.RestauranteService;

@RequestMapping("/restaurante")
@RestController
public class RestauranteController {

	private final RestauranteService restauranteService;

	
	@Autowired
	public RestauranteController(RestauranteService restauranteService) {
		this.restauranteService = restauranteService;
	}

	@PostMapping("/insert")
	public ResponseEntity insertRestaurante(@RequestBody RestauranteDto restauranteDto) {

		try {

			return ResponseEntity.ok(restauranteService.insertRestaurante(Restaurante.create(restauranteDto)));

		} catch (Exception e) {
			ResponseEntity.badRequest().body(e);
			return null;
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity updateRestaurante(@PathVariable(name = "id") Long id, @RequestBody RestauranteDto restauranteDto) {

		Restaurante restaurante = Restaurante.create(restauranteDto);
		restaurante.setId(id);

		Restaurante updateCliente = restauranteService.updateRestaurante(restaurante);

		return Objects.nonNull(updateCliente) ? ResponseEntity.ok(restaurante) : ResponseEntity.notFound().build();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteRestaurante(@PathVariable("id") Long id) {
		return restauranteService.deleteRestaurante(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

	}

	@GetMapping("/find/{id}")
	public ResponseEntity findById(@PathVariable("id") Long id) {
		Optional<Restaurante> restaurante = restauranteService.findById(id);
		return restaurante.isPresent() ? ResponseEntity.ok(restaurante.get()) : ResponseEntity.notFound().build();
		
	}

}
