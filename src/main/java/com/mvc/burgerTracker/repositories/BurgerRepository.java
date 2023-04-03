package com.mvc.burgerTracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.burgerTracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Integer>{
	List<Burger> findAll();
	List<Burger> findByBurgerName(String burgerName);
}
