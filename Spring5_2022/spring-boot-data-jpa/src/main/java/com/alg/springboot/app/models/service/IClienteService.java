package com.alg.springboot.app.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alg.springboot.app.models.entity.Cliente;

@Service //Patrón de diseño facade: un único punto de acceso hace diferentes daos o repositories
public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

}
