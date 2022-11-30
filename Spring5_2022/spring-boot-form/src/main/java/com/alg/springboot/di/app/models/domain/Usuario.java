package com.alg.springboot.di.app.models.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alg.springboot.di.app.validation.IdentificadorRegex;
import com.alg.springboot.di.app.validation.Requerido;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {
	
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][a-zA-Z]{1}") // el \\d es igual al rango de 0-9
	@IdentificadorRegex()
	private String identificador;
	
	//@NotEmpty(message = "el nombre no puede ser vacio")
	private String nombre;
	
	//@NotEmpty
	@Requerido
	private String apellido;
	
	@NotBlank
	@Size(min = 3, max = 8)
	private String username;
	
	@NotEmpty
	private String password;
	
	//@NotEmpty
	@Requerido
	@Email(message = "correo de formato incorrecto")
	private String email;
	
	@NotNull //para objetos, NotEmpty es para strings
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	@Future
	//@Past
	//@DateTimeFormat(pattern = "yyyy-MM-dd")//con - para que sea compatible con type="date" de html5
	private Date fechaNacimiento;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

}
