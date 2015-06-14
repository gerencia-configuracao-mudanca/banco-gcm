package com.br.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.conexao.ConnectionFactory;
import com.br.model.Conta;



public class ContaDao implements ContaInterface{

	private Connection connection;

	public ContaDao() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionarConta(Conta conta) {
		String sql = "INSERT INTO conta (ag,cc,valor,id_conta, tipo) VALUES (?,?,?,?,?)";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, conta.getAg());
			ps.setString(2, conta.getCc());
			ps.setFloat(3, conta.getValor());
			ps.setLong(4, conta.getId_conta());
			ps.setFloat(5, conta.getTipo());
			ps.execute();
			ps.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
	}


	public ResultSet ListarUsuario() {
		ResultSet rs;
		String sql = "SELECT conta.ag, conta.cc, conta.valor, conta.tipo, usuarios.nome	FROM usuarios INNER JOIN conta on conta.id_conta = usuarios.id_usuario";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return rs;

	}


	public float Saldo(Conta conta) {
		ResultSet rs;
		float valor2 = 0;
		String sql = "SELECT conta.valor FROM usuarios INNER JOIN conta on usuarios.id_usuario = conta.id_conta WHERE conta.cc='"+conta.getCc()+"';";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				valor2 = rs.getInt("valor");
				//System.out.println(valor2);
			}
			//rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return valor2;
	}

	public float Bonus(String conta) {
		ResultSet rs;
		float bonus = 0;
		String sql = "SELECT bonus FROM conta WHERE conta.cc = "+conta+";";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				bonus = rs.getInt("bonus");
			}
			//System.out.println("Bonus igual a: " + bonus);
			//rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return bonus;
	}


	public float tipo(String conta) {
		ResultSet rs;
		float tipo = 0;
		String sql = "SELECT tipo FROM conta WHERE conta.cc = "+conta+";";
		try{
			java.sql.Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				tipo = rs.getInt("tipo");
			}
			//System.out.println("tipo igual a: " + tipo);
			//rs.close();
		}catch(SQLException erro){
			throw new RuntimeException(erro);
		}
		return tipo;
	}



	public void Creditar(Conta conta) {
		String sql = "UPDATE conta SET conta.valor= "+ conta.getValor()+", conta.bonus= "+conta.getBonus()+" where conta.cc= '"+conta.getCc()+ "';";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			ps.execute();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
	}


	public void Debitar(Conta conta) {
		String sql = "UPDATE conta SET conta.valor= "+ conta.getValor()+" where conta.cc= '"+conta.getCc()+ "';";
		try{
			PreparedStatement	ps = connection.prepareStatement(sql);
			ps.execute();
		}catch(SQLException erro){
			throw new RuntimeException(erro);

		}
	}


}