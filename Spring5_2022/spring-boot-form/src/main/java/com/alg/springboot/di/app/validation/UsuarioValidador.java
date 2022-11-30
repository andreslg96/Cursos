package com.alg.springboot.di.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.alg.springboot.di.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Usuario usuario = (Usuario)target;
		
		//ValidationUtils.rejectIfEmpty(errors, "nombre", "Notempty.usuario.nombre"); con este los espacios en blanco serían aceptados
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Notempty.usuario.nombre");
		
		//Esto es otra opción
//		if(usuario.getNombre().isEmpty()) {
//			errors.rejectValue("nombre", "Notempty.usuario.nombre" );
//		}
		
//		if(usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][a-zA-Z]{1}")==false) {//o en vez de ==false agregar ! al principio
//			errors.rejectValue("identificador", "pattern.usuario.identificador");
//		} este if lo comentamos porque ahora estamos usando el Regex

	}

}
