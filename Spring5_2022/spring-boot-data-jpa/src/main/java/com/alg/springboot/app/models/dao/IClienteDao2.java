package com.alg.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.alg.springboot.app.models.entity.Cliente;

public interface IClienteDao2 extends CrudRepository<Cliente, Long>{
	//En esta IClienteDao2 haremos lo mismo que en el primero, pero en vez de añadir manualmente los métodos, usaremos @Query y JPQL para hacer
	//las consultas automaticamente como nos ofrece Spring JPA CrudRepository, ctrl + clic sobre CrudRepository para ver métodos
	
	
	
	

}
