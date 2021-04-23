<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<ul class="topnav">
		<li><a class="active" href="index.jsp">Home</a></li>
		<li><a href="#news">News</a></li>
		<c:if test="${ usuarioLogeado != null }">
			${usuarioLogeado.nombre"}
		</c:if>
		<c:if test="${ usuarioLogeado == null }">
			<li class="right"><a href="login.jsp">Entrar</a></li>
		</c:if>

		<li class="right"><a href="registro.jsp">Registrate</a></li>
	</ul>

	<h1 class="center">Portada</h1>
	<p style="color: orange">${usuarioLogeado}</p>
	<p class="center green">${mensaje}</p>
	<p class="center red">${nombre}</p>
</body>
</html>