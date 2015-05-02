package com.br.operacoes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class saqueServlet
 */

public class Credito implements Command{
	
	
	public Credito() {
		super();
	}

	


	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Object numero_conta = new Object();
		float bonus_atual = 0;
		float bonus_operacao = 0;
		float valor = 0;
		float saldo = 0;
		String mensagem  = "";
		

		HttpSession sessao = request.getSession();
		numero_conta = sessao.getAttribute("cc");
		valor = Float.parseFloat(request.getParameter("valor"));
		bonus_operacao =  (float) Math.floor(valor * 0.03);
		
		
		
		try{
			Conta conta = new Conta();
			ContaDao contadao = new ContaDao();
			
			conta.setCc(numero_conta.toString());
			saldo = contadao.Saldo(conta);
			bonus_atual = contadao.Bonus(numero_conta.toString());
			
			
			
			conta.setBonus(bonus_atual + bonus_operacao);
			conta.setValor(saldo + valor);
			
			contadao.Creditar(conta);
			
			mensagem = "Crédito no valor: " + valor + " para a conta " + numero_conta + " realizado com sucesso";
			response.setContentType("text/html");
			sessao.setAttribute("saveSaldo", saldo);
			sessao.setAttribute("valormensagemcredito", mensagem);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return "creditar.jsp";

	}

}
