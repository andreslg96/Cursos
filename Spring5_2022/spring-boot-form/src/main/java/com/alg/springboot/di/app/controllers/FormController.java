package com.alg.springboot.di.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.alg.springboot.di.app.editors.NombreMayusculaEditor;
import com.alg.springboot.di.app.editors.PaisPropertyEditor;
import com.alg.springboot.di.app.editors.RolesEditor;
import com.alg.springboot.di.app.models.domain.Pais;
import com.alg.springboot.di.app.models.domain.Role;
import com.alg.springboot.di.app.models.domain.Usuario;
import com.alg.springboot.di.app.services.PaisService;
import com.alg.springboot.di.app.services.RoleService;
import com.alg.springboot.di.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")//para que persista la info con la petición http
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RolesEditor roleEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setValidator(validador); //con setValidator únicamente lanza el texto personalizado que se agrego en la clase UsuarioValidador
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);//con false hace que sea estricto y no flexible en cuanto al formato de la fecha
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false)); //"fechaNacimiento" se agrega para el otro constructor
		//si se quiere ser más específico de que formatear, de no ponerlo aplicara a todos los parámetros de tipo Date que estén en un input
		//si cambiaramos a true, aceptaría valores null y cambiará el mensaje de aviso del formato al de no puede ser nulo (por el if en la clase CustomDateEditor)
		
		binder.registerCustomEditor(String.class, "nombre" , new NombreMayusculaEditor()); //"nombre" indica que solo a ese campo se aplica el cambio a mayúsculas
		binder.registerCustomEditor(String.class, "apellido" , new NombreMayusculaEditor());
		binder.registerCustomEditor(Pais.class, "pais" , paisEditor);
		binder.registerCustomEditor(Role.class, "roles" , roleEditor);
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre", "Mujer");
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}
	
	@ModelAttribute("listaPaises")//si no agregamos el nombre, se pone por defecto el nombre del método, pero es mejor ponerlo de forma explícita
	public List<Pais> listaPaises(){
		return paisService.listar();
//		return Arrays.asList(
//				new Pais (1, "ES", "España"),
//				new Pais (2, "MX", "México"),
//				new Pais (3, "CL", "Chile"),
//				new Pais (4, "AR", "Argentina"), 
//				new Pais (5, "PE", "Perú"),
//				new Pais (6, "CO", "Colombia"),
//				new Pais (7, "VE", "Venezuela"));
	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap(){
		Map<String, String> roles = new HashMap<String,String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}
	
	@ModelAttribute("paises")//si no agregamos el nombre, se pone por defecto el nombre del método, pero es mejor ponerlo de forma explícita
	public List<String> paises(){
		return Arrays.asList("España","México","Chile","Argentina", "Perú","Colombia","Venezuela");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		Map<String, String> paises = new HashMap<String,String>();
		paises.put("ES", "España");
		paises.put("MX", "México");
		paises.put("CL", "Chile");
		paises.put("AR", "Argentina");
		paises.put("PE", "Perú");
		paises.put("CO", "Colombia");
		paises.put("VE", "Venezuela");
		return paises;
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-K");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algún valor secreto ****");
		usuario.setPais(new Pais(2, "MX", "México"));
		usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
		model.addAttribute("titulo","Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	//public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model, SessionStatus status){//este user lo podemos poner en vez del usuario en l 25 o en la vista
	public String procesar(@Valid  Usuario usuario, BindingResult result, Model model){	
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
		
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Resultado form");
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(error ->{
//				errores.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
//			});
//			model.addAttribute("error", errores);
			
			return "form";
		}
		//model.addAttribute("usuario", usuario);
		
		
		//ponemos el usuario en el model en vez de poner dato por dato como abajo, en la vista debe cambiar a usuario.x
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario", required = false)  Usuario usuario, Model model, SessionStatus status) {
		
		if (usuario==null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Resultado form");
		status.setComplete();
		return "resultado";
	}
	

}
