package com.alg.springboot.di.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alg.springboot.di.app.services.RoleService;

@Component
public class RolesEditor extends PropertyEditorSupport{
	
	@Autowired
	private RoleService service;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(text);
			setValue(service.obtenerPorId(id));
		}catch(NumberFormatException e) {
			setValue(null);
		}
	}

}
