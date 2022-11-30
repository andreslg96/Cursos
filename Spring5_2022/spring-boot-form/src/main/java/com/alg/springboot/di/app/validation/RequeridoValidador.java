package com.alg.springboot.di.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.isEmpty() || value.isBlank()) { //Una alternativa para isEmpty e isBlank es !StringUtils.hasText(value)
			return false;
		}
		return true;
	}

}
