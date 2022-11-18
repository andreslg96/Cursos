package com.alg.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alg.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app") //Ruta de primer nivel para acceder al controlador, /index sería de segundo nivel para acceder a los métodos, útil cuando se usa CRUD
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//@RequesttMapping(value="/index", method=RequestMethod.GET) lo mismo que abajo, lo de method no es necesario para GET
	@GetMapping({"/index","/","/home"}) //métodos handler
	//public String index(ModelMap model) { este ModelMap es una clase pero se maneja igual que Model (que es una interfaz)
	//-------------------
	//public String index(Map<String, Object>map){ en vez de usar model, map es de la interfaz java, quedaría así:
	//map.put("titulo", "hola Spring Framework");
	//------------------
	//public ModelAndView index(ModelAndView mv) { //al igual que ModelMap y Map, trabaja con map de java pero permite agregarle un nombre a la vista
	//mv.addObject("titulo", "hola Spring Framework");
	//mv.setViewName("index");
	//return mv;
	public String index(Model model) {
		//model.addAttribute("titulo", textoIndex); borrar la línea de abajo y usar esta para inyectar el valor con @value
		model.addAttribute("titulo", "hola Spring Framework");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("López");
		usuario.setEmail("andres@correo.com");
		model.addAttribute("usuario", usuario);
		//model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre())); para que funcione con @Value
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		//una forma más eficiente de hacer la lista es:
		//List<Usuario> usuarios = Arryas.asList(new Usuario("Andrés", "López", "andres@correo.com"),
		//new Usuario("John", "Cash", "cash@correo.com"),
		//new Usuario("Will", "Nelson", "nelson@correo.com"));
		//-------------
//		List<Usuario> usuarios = new ArrayList<>();
//		usuarios.add(new Usuario("Andrés", "López", "andres@correo.com"));
//		usuarios.add(new Usuario("John", "Cash", "cash@correo.com"));
//		usuarios.add(new Usuario("Will", "Nelson", "nelson@correo.com"));
//		usuarios.add(new Usuario("Merle", "Haggard", "haggard@correo.com"));
		//model.addAttribute("titulo", textoListar); para usar con @Value
		model.addAttribute("titulo", "listado de usuarios");
//		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrés", "López", "andres@correo.com"),
				new Usuario("John", "Cash", "cash@correo.com"),
				new Usuario("Will", "Nelson", "nelson@correo.com"),
				new Usuario("Merle", "Haggard", "haggard@correo.com"));
		return usuarios;
	}
}
