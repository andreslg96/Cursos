package com.alg.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Service igual que component pero puede tener texto descriptivo
//@Component("miServicioSimple")
//@Primary
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecuttando algún proceso importante simple...";
	}

	
}
