package com.br.operacoes;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.dao.ContaDao;
import com.br.dao.UsuarioDao;
import com.br.model.Conta;
import com.br.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class Login implements Command {
	String nome = "";
	String senha = "";
	String cc = "";
	int id_usuario = 0;
	//int saldo = 0;
	String id_usuario2 = "";
	
    public Login() {
        super();
    }


	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Object saldo = new Object();
		float saldo = 0;
		nome = request.getParameter("nome");
		senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(nome);
		usuario.setSenha(senha);
		
		Conta conta = new Conta();
		conta.setCc(cc);
		try {
			ContaDao contadao = new ContaDao();
			saldo = contadao.Saldo(conta);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		try {
			UsuarioDao usuarioDAO = new UsuarioDao();
			if(usuarioDAO.AutenticarUsuario(usuario) == true){
				
				id_usuario = usuarioDAO.id_usuario(usuario);
				id_usuario2 = Integer.toString(id_usuario);
				cc = usuarioDAO.cc(usuario);
				//saldo = usuarioDAO.Saldo(usuario);
				response.setContentType("text/html");
				HttpSession sessao = request.getSession();
				//saldo = sessao.getAttribute("saveSaldo");
				//sessao.setAttribute("saldo", saldo);
				sessao.setAttribute("cc", cc);
				sessao.setAttribute("nome", nome);
				sessao.setAttribute("id_usuario", id_usuario);
				sessao.setAttribute("saveSaldo", saldo);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("inicio.jsp");
				//dispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return "inicio.jsp";
	}

}
