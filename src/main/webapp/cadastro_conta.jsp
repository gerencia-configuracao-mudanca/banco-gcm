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
</head>
<body>
	<div class="container">
		<section id="content">
			<form name="formConta" method="post" action="Controller">
				<input type="hidden" id="cmd" required name="cmd"
					value="cadastroConta" />
				<div>
					<input type="text" required name="ag"
						placeholder="Numero da Agencia"><br>
				</div>
				<div>
					<input type="text" required name="cc" placeholder="Numero da Conta"><br>

				</div>
				<div>
					<input type="text" required name="tc" placeholder="Tipo da Conta"><br>

				</div>
				<div>
					<input type="text" required name="valor"
						placeholder="Quantidade de dinheiro"><br>
				</div>
				<div>
					<input type="submit" id="enviar" value="Enviar">
				</div>
			</form>
			<!-- form -->
			<div class="button"></div>
			<!-- button -->
		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
</html>