package com.alg.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//return "redirect:/app/index";
		return "forward:/app/index"; //para una página de inicio ya que se mantiene el url, ej. localhost:8080 
		//return "redirect:https://www.google.com";
	}

}
