package com.br.myfood.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.entity.Restaurante;
import com.br.myfood.cadastro.repository.MenuRepository;
import com.br.myfood.cadastro.repository.RestaurantRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final RestaurantRepository restauranteRepository;

	@Autowired
	public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
		this.menuRepository = menuRepository;
		this.restauranteRepository = restaurantRepository;
	}

	public Menu insertMenu(MenuDto menuDto) {
		Optional<Restaurante> restourante = restauranteRepository.findById(menuDto.getRestaurante());
		
		if(restourante.isPresent()) {
			Menu menu = Menu.create(menuDto);
			menu.setRestaurante(menuDto.getRestaurante());
			return menuRepository.save(menu);
		}else {
			return null;
		}
		
		
	}

	public Menu updateMenu(Menu menu) {

		Optional<Menu> m = menuRepository.findById(menu.getId());

		if (m.isPresent()) {
			return menuRepository.save(menu);
		} else {
			return null;
		}
	}

	public boolean deleteMenu(Long id) {

		Optional<Menu> cli = menuRepository.findById(id);

		if (cli.isPresent()) {
			menuRepository.delete(cli.get());
			return true;
		} else {
			return false;
		}

	}
	
	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);
		
	}

}
