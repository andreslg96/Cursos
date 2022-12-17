package com.alg.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alg.springboot.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext //va a inyectar el entitymanager automáticamente según la config de la persistencia, usará H2 si no configuramos en applicationproperties
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true) //se omite si se requiere hacer más que solo leer
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional 
	public void save(Cliente cliente) {
		em.persist(cliente); //sesión 120

	}

}
