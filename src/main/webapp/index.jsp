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
	<h1 class="center">Login</h1>


	<p class="center red">${nombre}</p>

	<div class="centralBox">
		<form method="post" action="login">
			<ul>
				<li>
					<div class="right">
						<label for="nombre">Nombre:</label>
						<input  type="text" name="nombre" id="right" size="10">
					</div>
				</li>
				<li>
					<div class="right">
						<label for="pass">Contrase&ntilde;a:</label>
						<input class="right" type="password" name="pass" id="pass" size="10">
					</div>
				</li>
				<li>
					<input type="submit" value="Entrar">
					<a class="right" href="registro.jsp">Registrarse</a>
				</li>
			</ul>
		</form>
	</div>

</body>
</html>