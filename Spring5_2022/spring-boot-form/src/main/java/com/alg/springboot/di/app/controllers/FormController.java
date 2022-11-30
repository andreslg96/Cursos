package com.alg.springboot.di.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.alg.springboot.di.app.models.domain.Usuario;
import com.alg.springboot.di.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")//para que persista la info con la petición http
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setValidator(validador); //con setValidator únicamente lanza el texto personalizado que se agrego en la clase UsuarioValidador
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);//con false hace que sea estricto y no flexible en cuanto al formato de la fecha
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false)); //"fechaNacimiento" se agrega para el otro constructor
		//si se quiere ser más específico de que formatear, de no ponerlo aplicara a todos los parámetros de tipo Date que estén en un input
		//si cambiaramos a true, aceptaría valores null y cambiará el mensaje de aviso del formato al de no puede ser nulo (por el if en la clase CustomDateEditor)
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-K");
		model.addAttribute("titulo","Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	//public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model, SessionStatus status){//este user lo podemos poner en vez del usuario en l 25 o en la vista
	public String procesar(@Valid  Usuario usuario, BindingResult result, Model model, SessionStatus status){	
			//@RequestParam String username,
			//@RequestParam(name="username") String username, en este caso como se llaman igual sale sobrando la opción de value
			//@RequestParam String password,
			//@RequestParam String email) {
		
		//esto se puede optimizar al poner el Usuario usuario como atributo junto con el modelo, también podemos quitar los @RequesParam
//		Usuario usuario = new Usuario();
//		usuario.setUsername(username);
//		usuario.setEmail(email);
//		usuario.setPassword(password);
		//validador.validate(usuario, result);
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
		status.setComplete();
		
		//ponemos el usuario en el model en vez de poner dato por dato como abajo, en la vista debe cambiar a usuario.x
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);
		
		return "resultado";
	}

}
