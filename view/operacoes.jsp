<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="./design/css/style.css" />
<link rel="stylesheet" type="text/css"  href="./design/css/estilo.css" />

</head>
<body>
<div class="container">
	<section id="content">
		
	
	<ol id="toc" >
    <li><a href="inicio.jsp">Home</a></li>
    <li>
    <form action="Controller" method="post">
        <a href="saldo.jsp" onclick="parentNode.submit();">Saldo</a>
				<input type="hidden" id="cmd" required  name="cmd" value="saldo"/>
    </form>
	</li>
    <li class="current"><a href="creditar.jsp">Crédito</a></li>
    <li><a href="transferencia.jsp">Transferencia</a></li>
    <li><a href="debitar.jsp">Debitar</a></li>
    <li>
    <form action="Controller" method="post">
        <a href="bonus.jsp" onclick="parentNode.submit();">Bonus</a>
				<input type="hidden" id="cmd" required  name="cmd" value="bonus"/>
    </form>
	</li>
    
    
</ol>

		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
