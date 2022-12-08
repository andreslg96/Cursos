package com.alg.springboot.horariointerceptor.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements WebMvcConfigurer{
	
	@Autowired
	@Qualifier("horario")
	private HandlerInterceptor horario;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(horario).excludePathPatterns("/cerrado"); //con exclude nos aseguramos de que no aplique a cerrado, que es la alternativa, de otro modo no cargará la página
	}

}
