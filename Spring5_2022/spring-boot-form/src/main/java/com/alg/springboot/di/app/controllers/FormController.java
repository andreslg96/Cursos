package com.alg.springboot.di.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alg.springboot.di.app.models.domain.Usuario;

import jakarta.validation.Valid;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-k");
		model.addAttribute("titulo","Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model, //este user lo podemos poner en vez del usuario en l 25 o en la vista
			@RequestParam String username,
			//@RequestParam(name="username") String username, en este caso como se llaman igual sale sobrando la opción de value
			@RequestParam String password,
			@RequestParam String email) {
		
		//esto se puede optimizar al poner el Usuario usuario como atributo junto con el modelo, también podemos quitar los @RequesParam
//		Usuario usuario = new Usuario();
//		usuario.setUsername(username);
//		usuario.setEmail(email);
//		usuario.setPassword(password);
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(error ->{
//				errores.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
//			});
//			model.addAttribute("error", errores);
			
			return "form";
		}
		model.addAttribute("usuario", usuario);
		
		//ponemos el usuario en el model en vez de poner dato por dato como abajo, en la vista debe cambiar a usuario.x
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);
		
		return "resultado";
	}

}
