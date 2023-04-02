package com.mvc.burgerTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.burgerTracker.models.Burger;
import com.mvc.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	@Autowired
	private BurgerRepository bRepo;
	
	public List<Burger> allBurger() {
		return bRepo.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return bRepo.save(burger);
	}
}
