package com.br.operacoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class CreditoServlet
 */

public class Debito implements Command {

	public Debito() {
		super();
	}


	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Object cc = new Object();
		String pagina = "";
		String mensagem = "";

		float valor = 0;
		float resultado = 0;
		float saldo = 0;

		HttpSession sessao = request.getSession();

		cc = sessao.getAttribute("cc");
		valor = Integer.parseInt(request.getParameter("valor"));
		resultado = 0;


		try{
			Conta conta = new Conta();
			conta.setCc(cc.toString());
			ContaDao contadao = new ContaDao();
			saldo = contadao.Saldo(conta);

			if(saldo >= valor & saldo >= 2){
				resultado = saldo - valor;

				conta.setValor(resultado);
				contadao.Debitar(conta);
				mensagem = "Debito no valor: " + valor + " para a conta " + cc + " realizado com sucesso";
				pagina = "debitar.jsp";
				response.setContentType("text/html");
				sessao.setAttribute("saveSaldo", saldo);
				sessao.setAttribute("valormensagemdebito", mensagem);
			}else{
				mensagem = "Seu Saldo eh Insuficiente tente um valor menor";
				pagina = "debitar.jsp";
				response.setContentType("text/html");
				sessao.setAttribute("saveSaldo", saldo);
				sessao.setAttribute("valormensagemdebito", mensagem);
			}



		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		return pagina;
	}

}
