package com.alg.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope //antes al ser singleton dura toda la app y todos los usuarios la usan por defecto, al usar RS el scope es para cada http request, sería una factura para 
//cada usuario, también está el SessionScope
//@SessionScope
//@ApplicationScope //casi igual al scope singleton pero se guarda en servlet context y no en el aplication context de spring, que es solo 1
public class Factura implements Serializable{

	private static final long serialVersionUID = -7415315772715599230L;//este es para el SessionScope

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct //este si aplica si cambiamos el scope, pero no el PreDestroy
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ".concat("Sik")));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
