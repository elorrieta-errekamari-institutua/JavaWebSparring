<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>

	<h1 class="center">Registro</h1>


	<p class="center red">${mensaje}</p>

	<div class="centralBox">
		<form method="post" action="login">
			<ul>
				<li>
					<label>Nombre: </label>
					<input class="right"  type="text" name="nombre">
				</li>
				<li>
					<label>Contrase&ntilde;a</label>
					<input class="right" type="password" name="password">
				</li>
				<li>
					<label>Contrase&ntilde;a</label>
					<input class="right" type="password" name="password">
				</li>
				<li>
					<input type="submit" value="Submit">
					<a class="right" href="">Login</a>
				</li>
			</ul>
		</form>
	</div>

</body>
</html>