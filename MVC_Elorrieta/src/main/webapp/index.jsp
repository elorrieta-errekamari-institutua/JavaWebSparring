<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My first JSP page</title>
</head>
<%
int count = 0;
%>
<body>
	<h1>Suma de numeros</h1>
	
	
	<p style="color:red">${mensaje}</p>
	
	<form method="post" action="login">
		<p>
			Numero 1 <input type="text" name="nombre">
		</p>
		<p>
			Numero 2 <input type="password" name="password">
		</p>

		<input type="submit" value="Submit">
	</form>

	<form method="POST" action="suma.jsp">
		<p>
			Numero 1 <input type="text" name="numero1">
		</p>
		<p>
			Numero 2 <input type="text" name="numero2">
		</p>

		<input type="submit" value="Submit">
	</form>

</body>
</html>