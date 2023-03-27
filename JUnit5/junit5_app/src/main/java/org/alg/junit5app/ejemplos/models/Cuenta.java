package org.alg.junit5app.ejemplos.models;

import java.math.BigDecimal;

import org.alg.junit5app.ejemplos.exceptions.DineroInsuficienteException;

public class Cuenta {
	private String persona;
	private BigDecimal saldo;
	private Banco banco;
	
	

	public Cuenta(String persona, BigDecimal saldo) {
		this.saldo = saldo;
		this.persona = persona;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
		
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void debito(BigDecimal monto) {
		BigDecimal nuevoSaldo = this.saldo.subtract(monto);
		if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
			throw new DineroInsuficienteException("Dinero insuficiente");
		}
		this.saldo = nuevoSaldo;
	}
	
	public void credito(BigDecimal credito) {
		this.saldo = this.saldo.add(credito);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Cuenta)) { //obj == null está de más, ya que obj debe existir para usar instanceof
			return false;
		}
		Cuenta c = (Cuenta) obj;
		if(this.persona == null|| this.saldo == null) {
			return false;
		}
		
		return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
	}
	
	

}
