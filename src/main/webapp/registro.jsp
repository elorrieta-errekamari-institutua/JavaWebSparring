<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<h1 class="center">Registro</h1>


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
						<input type="password" name="pass" id="pass" placeholder="Su contrase&ntilde;a">
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="pass2">Repita la contrase&ntilde;a:</label>
						<input type="password" name="pass2" id="pass2" placeholder="Su contrase&ntilde;a">
					</div>
				</li>
				<li>
					<div class="linea">
						<label for="email">E-mail:</label>
						<input type="email" name="email" id="email" placeholder="nombre@dominio.com">
					</div>
				</li>
				<li>
					<div class="linea">
						<input type="submit" value="Entrar">
						<a href="index.jsp">Iniciar sesion</a>
					</div>
				</li>
			</ul>
		</form>
	</div>

</body>
</html>