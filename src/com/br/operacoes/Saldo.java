package com.br.operacoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.br.dao.ContaDao;
import com.br.model.Conta;

public class Saldo implements Command {
       
   
    public Saldo() {
        super();
    }
    
    
		public String execute(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object numero_conta = new Object();
			float saldo = 0;
			try{
				Conta conta = new Conta();
				HttpSession sessao = request.getSession();
				numero_conta = sessao.getAttribute("cc");
				conta.setCc(numero_conta.toString());
				ContaDao contadao = new ContaDao();
				saldo = contadao.Saldo(conta);
				response.setContentType("text/html");
				sessao.setAttribute("saveSaldo", saldo);
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			return "saldo.jsp";

		}
	
	
}