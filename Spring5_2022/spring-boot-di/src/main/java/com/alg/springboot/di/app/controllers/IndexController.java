package com.alg.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alg.springboot.di.app.models.service.IServicio;
import com.alg.springboot.di.app.models.service.MiServicio;

@Controller
public class IndexController {
	//private MiServicio servicio = new MiServicio(); acá con la inyección de dependencias buscamos usar el principio hollywood
	
	@Autowired //este se va al set
	//private MiServicio servicio; acá ya no importamos la clase, si no la interfaz, así si la clase se modifica no hay que modificar todos los controladores
	//@Qualifier("miServicioPrincipal")//con este usamos complejo aunque simple tenga primary y se basa en el nombre del component
	//@Qualifier("miServicioComplejo") también podemos usar esta notación al usar configuration y llamando así al bean (AppConfig)
	private IServicio servicio;
	
	
	//@Autowired //esto remplaza al setter como otra forma de inyectar mediante un constructor, y se puede omitiar la notación
//	public IndexController(IServicio servicio) {
//		this.servicio = servicio;
//	}

	@GetMapping({"/index","","/"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}
	
//	@Autowired //se puede inyectar con setter en vez de con atributo
//	public void setServicio(IServicio servicio) {
//		this.servicio = servicio;
//	}

	
}
