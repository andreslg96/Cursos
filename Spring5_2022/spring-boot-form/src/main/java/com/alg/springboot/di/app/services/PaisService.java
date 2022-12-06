package com.alg.springboot.di.app.services;

import java.util.List;

import com.alg.springboot.di.app.models.domain.Pais;

public interface PaisService {
	
	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);

}
