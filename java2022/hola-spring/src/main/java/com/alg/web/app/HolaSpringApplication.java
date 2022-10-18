package com.alg.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class HolaSpringApplication {
	
	@GetMapping("/hola")
	public String hola() {
		return "index";
	}
	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);
	}

}
