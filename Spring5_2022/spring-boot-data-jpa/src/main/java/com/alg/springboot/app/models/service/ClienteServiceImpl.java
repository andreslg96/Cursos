package com.alg.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alg.springboot.app.models.dao.IClienteDao;
import com.alg.springboot.app.models.dao.IClienteDao2;
import com.alg.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	//private IClienteDao clienteDao; //este para el dao escrito manualmente
	private IClienteDao2 clienteDao; //este para el dao usando JPA CrudRepository 
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		//return clienteDao.findAll(); //Dao1
		return (List<Cliente>) clienteDao.findAll(); //Dao2
	}

	@Override
	@Transactional 
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		//return clienteDao.findOne(id); // Dao1
		return clienteDao.findById(id).orElse(null); //Dao2 (checar los diferentes métodos, los más comunes son get() y el actual, orElse()
	}

	@Override
	@Transactional 
	public void delete(Long id) {
		//clienteDao.delete(id); // Dao1
		clienteDao.deleteById(id); // Dao2
		
	}

}
