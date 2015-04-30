package com.br.operacoes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.model.Conta;


public class Transferencia implements Command {
       
   
    public Transferencia() {
        super();
    }

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Object numero_conta = new Object();
		HttpSession sessao = request.getSession();
		
		
		float bonus_atual = 0;
		float bonus_operacao = 0;
		float saldo = 0;
		float saldoDestino = 0;
		
		String redirecionar = "";
		String mensagem = "";
		
		String numero_conta_destino = request.getParameter("cc");
		float valor = Float.parseFloat(request.getParameter("valor"));
		
		
		numero_conta = sessao.getAttribute("cc");
		bonus_operacao = (float) Math.floor(valor/10);
		
		
		try{
			Conta conta = new Conta();
			Conta conta2 = new Conta();
			
			ContaDao contadao = new ContaDao();
			
			conta.setCc(numero_conta.toString());
			conta2.setCc(numero_conta_destino);
			
			
			saldo = contadao.Saldo(conta);
			saldoDestino = contadao.Saldo(conta2);
			bonus_atual = contadao.Bonus(numero_conta_destino);
			if(saldo >= valor){
				conta2.setValor(saldoDestino + valor);
				conta.setValor(saldo - valor);
				conta2.setBonus(bonus_atual + bonus_operacao);
				mensagem = "Tranferencia no valor: " + valor + " para a conta: " + numero_conta_destino + " realizado com sucesso";
				contadao.Creditar(conta2);
				contadao.Debitar(conta);
				response.setContentType("text/html");
				sessao.setAttribute("saveSaldo", saldo);
				sessao.setAttribute("valormensagemtransferencia", mensagem);
				redirecionar = "transferencia.jsp";
			}else{
				mensagem = "Seu Saldo é Insuficiente tente um valor menor";
				response.setContentType("text/html");
				sessao.setAttribute("saveSaldo", saldo);
				sessao.setAttribute("valormensagemtransferencia", mensagem);
				redirecionar = "transferencia.jsp";
				//redirecionar = "saldo_insuficiente.jsp";
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return redirecionar;
	}

}
