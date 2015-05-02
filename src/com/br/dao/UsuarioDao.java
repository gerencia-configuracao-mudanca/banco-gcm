package com.br.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.conexao.ConnectionFactory;
import com.br.model.Usuario;

import java.sql.PreparedStatement;

public class UsuarioDao implements UsuarioInterface{

	private Connection connection;

	public UsuarioDao() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome,senha) VALUES (?,?)";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			ps.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}

	}

	

	public String cc(Usuario usuario) {
		ResultSet rs;
		String numeroConta = "";
		String sql = "SELECT conta.cc FROM usuarios INNER JOIN conta on usuarios.id_usuario = conta.id_conta WHERE usuarios.nome='"+usuario.getUsuario()+"';";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				numeroConta = rs.getString("cc");
			}
			rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
		return numeroConta;
	}
	
	
	

	public boolean AutenticarUsuario(Usuario usuario) {
		boolean autenticar = false;
		String sql = "select * from usuarios where " + "nome='"+usuario.getUsuario()+"' and "+"senha='"+usuario.getSenha()+"';";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rm = ps.executeQuery();
			if(rm.next()){
				autenticar = true;
			}
			rm.close();
			ps.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return autenticar;

	}
	
	public int id_usuario(Usuario usuario) {
		ResultSet rs;
		int valor2 = 0;
		String sql = "SELECT usuarios.id_usuario FROM usuarios WHERE " +  "nome='"+usuario.getUsuario()+"';";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				valor2 = rs.getInt("id_usuario");
				System.out.println(valor2);
			}
			rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return valor2;
	}
	

	

	public ResultSet ListarUsuario() {
		ResultSet rs;
		String sql = "SELECT conta.ag, conta.cc, conta.valor, usuarios.nome	FROM usuarios INNER JOIN conta on conta.id_conta = usuarios.id_usuario";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
		
		return rs;

	}

}
