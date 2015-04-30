package com.br.operacoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.dao.UsuarioDao;
import com.br.model.Usuario;

public class CadastroUsuario implements Command{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setUsuario(nome);
		usuario.setSenha(senha);
		try {
			UsuarioDao usuarioDAO = new UsuarioDao();
			usuarioDAO.adicionarUsuario(usuario);
		} catch (ClassNotFoundException e) {
			System.out.println("Aconteceu algum erro ");
			e.printStackTrace();
		}
		return "index.jsp";
	}

}
