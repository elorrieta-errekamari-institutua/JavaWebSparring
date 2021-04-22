<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<ul class="topnav">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#news">News</a></li>
		<li class="right"><a class="active" href="login.jsp">Entrar</a></li>
		<li class="right"><a href="registro.jsp">Registrate</a></li>
	</ul>

	<h1 class="center">Login</h1>


	<p class="center red">${nombre}</p>

	<div class="centralBox">
		<form method="post" action="login">
			<ul>
				<li>
					<div class="linea">
						<label for="nombre">Nombre:</label>
						<input  type="text" name="nombre" id="nombre" placeholder="Su nombre">
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="pass">Contrase&ntilde;a:</label>
						<input class="right" type="password" name="pass" id="pass" placeholder="Su contrase&ntilde;a">
					</div>
				</li>
				<li>
					<div class="linea">
						<input type="submit" value="Entrar">
						<a href="registro.jsp">Registrarse</a>
					</div>
				</li>
			</ul>
		</form>
	</div>

</body>
</html>