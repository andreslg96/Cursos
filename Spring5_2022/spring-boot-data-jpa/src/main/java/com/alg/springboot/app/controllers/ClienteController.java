package com.alg.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.alg.springboot.app.models.dao.IClienteDao;
import com.alg.springboot.app.models.entity.Cliente;
import com.alg.springboot.app.models.service.IClienteService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	//@Qualifier("clienteDaoJPA") //En este caso no es necesario porque solo hay una implementación
	private IClienteService clienteService; //Este cambio se hace por el cambio de @Transaccional de clienteDaoImp a clienteServiceImlp
	//private IClienteDao clienteDao;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());//Se cambia clienteDao por clienteService
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Cliente cliente=null;
		
		if(id>0) {
			cliente = clienteService.findOne(id); //Se cambia clienteDao por clienteService
		}else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST) //si usamos @SessionAttributes para el id, agregar SessionStatus status después de Model
	public String guardar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model, SessionStatus status) { //ModelAttribute va de sobra, es por si en el Get de arriba se llamara diferente
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		
		
		clienteService.save(cliente); //se cambia clienteDao por clienteService
		status.setComplete(); //para el id con @SessionAttributes
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			clienteService.delete(id); //se cambia clienteDao por clienteService
		}
		return "redirect:/listar";
	}

}
