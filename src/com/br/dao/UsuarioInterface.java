package com.br.dao;


import java.sql.ResultSet;

import com.br.model.Usuario;

public interface UsuarioInterface {
	public void adicionarUsuario(Usuario usuario);

	boolean AutenticarUsuario(Usuario usuario);

	ResultSet ListarUsuario();

	int id_usuario(Usuario usuario);

	String cc(Usuario usuario);

	
}
