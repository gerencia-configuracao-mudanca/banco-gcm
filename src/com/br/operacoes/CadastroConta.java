package com.br.operacoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;

/**
 * Servlet implementation class contaServlet
 */

public class CadastroConta implements Command {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroConta() {
        super();
       
    }

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int ag = Integer.parseInt(request.getParameter("ag"));
		String cc = request.getParameter("cc");
		float valor = Float.parseFloat(request.getParameter("valor"));
		float tipo_conta = Float.parseFloat(request.getParameter("tc"));
		Object id = new Object();
	
		HttpSession session = request.getSession();
		id =  session.getAttribute("id_usuario");
		Integer numero = (Integer)id;
		
		
		Conta conta = new Conta();
		
		conta.setAg(ag);
		conta.setCc(cc);
		conta.setValor(valor);
		conta.setTipo(tipo_conta);
		conta.setId_conta(numero);
		//System.out.println("Numero da conta é: " + numero);
		try{
			ContaDao contadao = new ContaDao();
			contadao.adicionarConta(conta);
			session.setAttribute("tc", tipo_conta);
			//session.setAttribute("savenumeroconta", cc);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		return "inicio.jsp";
	}

}
