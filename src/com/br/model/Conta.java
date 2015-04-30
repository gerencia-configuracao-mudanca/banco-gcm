package com.br.model;

public class Conta {
	
	
	private int ag;
	private String cc;
	private float valor;
	private int id_conta;
	private float bonus;
	
	public int getId_conta() {
		return id_conta;
	}
	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	public int getAg() {
		return ag;
	}
	public void setAg(int ag) {
		this.ag = ag;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float valor) {
		this.bonus = valor;
	}

}
