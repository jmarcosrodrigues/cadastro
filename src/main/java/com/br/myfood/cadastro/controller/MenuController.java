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

import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.service.MenuService;

@RequestMapping("/menu")
@RestController
public class MenuController {

	private final MenuService menuService;

	
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@PostMapping("/insert")
	public ResponseEntity insertMenu(@RequestBody MenuDto menuDto) {

		try {

			return ResponseEntity.ok(menuService.insertMenu(menuDto));

		} catch (Exception e) {
			ResponseEntity.badRequest().body(e);
			return null;
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity updatMenu(@PathVariable(name = "id") Long id, @RequestBody MenuDto menuDto) {

		Menu menu = Menu.create(menuDto);
		menu.setId(id);

		Menu updateMenu = menuService.updateMenu(menu);

		return Objects.nonNull(updateMenu) ? ResponseEntity.ok(updateMenu) : ResponseEntity.notFound().build();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteMenu(@PathVariable("id") Long id) {
		return menuService.deleteMenu(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

	}

	@GetMapping("/find/{id}")
	public ResponseEntity findById(@PathVariable("id") Long id) {
		Optional<Menu> menu = menuService.findById(id);
		return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
		
	}

}
