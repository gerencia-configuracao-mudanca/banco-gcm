<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="beanLogin" class="com.br.model.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="beanLogin" />
<jsp:useBean id="beanusuariodao" class="com.br.dao.UsuarioDao"></jsp:useBean>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="./design/css/style.css" />
<link rel="stylesheet" type="text/css" href="./design/css/estilo.css" />
</head>
<body>
	<div class="container">
		<section id="content">
			<div class="menu">
				<ol id="toc">
					<li><a href="inicio.jsp">Home</a></li>
					<li class="current"><a href="cadastro_conta.jsp">Cadastro
							de Conta</a></li>
					<li><a href="operacoes.jsp">Operações</a></li>
					<li><a href="listar_clientes.jsp">Listar Clientes</a></li>
				</ol>
			</div>
			<%
				ResultSet result = beanusuariodao.ListarUsuario();
			%>
			<table>
				<tr>
					<td>Numero da Agencia</td>
					<td>Numero da Conta</td>
					<td>Saldo</td>
					<td>Nome do dono da conta</td>
				</tr>
				<%
					while (result.next()) {
				%>
				<tr>
					<td><%=result.getString("ag")%></td>
					<td><%=result.getString("cc")%></td>
					<td><%=result.getString("valor")%></td>
					<td><%=result.getString("nome")%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				result.close();
			%>
		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
</html>
