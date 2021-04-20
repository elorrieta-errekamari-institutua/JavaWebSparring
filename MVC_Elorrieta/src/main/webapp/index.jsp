<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
	body {
		background-color: slategrey;
	}
	.center {
		text-align: center;
	}
	.right {
		float: right;
	}
	.red {
		color: red;
	}
	.central {
		width: 19em;
		margin: auto;
		padding: 10px;
	}
	ul {
		list-style-type: none;
	}
	li {
		padding: 3px;
	}
</style>
</head>
<%
int count = 0;
%>
<body>
	<h1 class="center">Login</h1>


	<p class="center red">${mensaje}</p>

	<div class="central">
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
					<input type="submit" value="Submit">
				</li>
			</ul>
		</form>
	</div>

</body>
</html>