package com.br.controller;

import javax.servlet.http.HttpServletRequest;

import com.br.operacoes.*;

public class Helper {

	private HttpServletRequest request;
	
	public Helper(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public Command getCommand() {
		String cmd = request.getParameter("cmd");
		Command comando = null;
		
		
		if (cmd.equals("Login")) {
			comando = new Login();
		}
		if (cmd.equals("Logout")) {
			comando = new Logout();
		}
		if(cmd.equals("saldo")){
			comando = new Saldo();
		}
		if(cmd.equals("transferencia")){
			comando = new Transferencia();
		}
		if(cmd.equals("Creditar")){
			comando = new Credito();
		}
		if(cmd.equals("Debitar")){
			comando = new Debito();
		}
		if (cmd.equals("cadastroConta")) {
			comando = new CadastroConta();
		}
		if (cmd.equals("cadastroUsuario")) {
			comando = new CadastroUsuario();
		}
		if (cmd.equals("bonus")) {
			comando = new Bonus();
		}
		
		
		
		return comando;
	}

}
