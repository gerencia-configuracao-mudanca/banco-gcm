package com.br.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String url = "jdbc:mysql://localhost/gerencia";
	private String usuario = "root";
	private String senha = "root";
	Connection conexao;
	String driver = "org.gjt.mm.mysql.Driver";
	public Connection getConnection() throws ClassNotFoundException{
		try{
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		}catch(SQLException erro){
			throw new RuntimeException(erro); 
		}

	}

	public void fecharConexao(){
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
