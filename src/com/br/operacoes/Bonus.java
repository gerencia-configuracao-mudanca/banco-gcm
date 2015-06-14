package com.br.operacoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class saldoServlet
 */

public class Bonus implements Command {


	public Bonus() {
		super();
	}


	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		float qtd = 0;
		String mensagem = "";
		Object numconta = new Object();
		try{
			Conta conta = new Conta();
			//Usuario usuario = new Usuario();
			HttpSession sessao = request.getSession();
			numconta = sessao.getAttribute("cc");
			conta.setCc(numconta.toString());
			ContaDao contadao = new ContaDao();
			qtd = contadao.Bonus(numconta.toString());
			System.out.println(qtd);
			mensagem = "Seu Bonus eh : " + qtd + " Continue usando nossos servicos e acumule bonus.";
			response.setContentType("text/html");
			sessao.setAttribute("saveBonus", mensagem);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		return "bonus.jsp";

	}


}