<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="./design/css/style.css" />
</head>
<body>
<div class="container">
	<section id="content">
		<form name="formCad" method="post" action="Controller">


				<input type="hidden" id="cmd" required  name="cmd" value="cadastroUsuario"/>
			
			<div>
				<input type="text" placeholder="Login" required  name="nome"/>
			</div>
			<div>
				<input type="password" placeholder="Senha" required name="senha" />
			</div>
			<div>
			
				<input type="submit" id="enviar" value="Enviar">
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
