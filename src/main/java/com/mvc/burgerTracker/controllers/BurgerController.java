package com.mvc.burgerTracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.burgerTracker.models.Burger;
import com.mvc.burgerTracker.services.BurgerService;


@Controller
@RequestMapping("/burgers")
public class BurgerController {
	
	@Autowired
	BurgerService bService;

	@GetMapping("")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		
		List<Burger> burgers = bService.allBurger();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	@PostMapping("")
	public String addBurger(
			@Valid
			@ModelAttribute("burger") Burger burger
			, BindingResult result
			,Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("burgers", bService.allBurger());
			return "index.jsp";
		}
		bService.createBurger(burger);
		return "redirect:/burgers";
	}
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") Integer burgerId, Model model) {
		
//		Retrieve the burger according to it's ID
		model.addAttribute("burger", bService.getBurgerById(burgerId));
		
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editing(
			@PathVariable("id") Integer id
			, @Valid @ModelAttribute("burger") Burger burger
			, BindingResult result
			,Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("burgers", bService.allBurger());
			return "edit.jsp";
		}
		bService.createBurger(burger);
		return "redirect:/burgers";
	} 
	
}
