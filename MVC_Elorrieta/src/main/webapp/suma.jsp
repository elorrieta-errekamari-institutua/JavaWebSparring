<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suma</title>
</head>
<%
String numero1String = request.getParameter("numero1");
String numero2String = request.getParameter("numero2");
float resultado = Float.parseFloat(numero1String) + Float.parseFloat(numero2String);
%>
<body>
	<h1>La suma es</h1>
	<p>
		<%
		out.print(numero1String);
		%>
	</p>
	<p>+</p>
	<p>
		<%
		out.print(numero2String);
		%>
	</p>
	<p>------</p>
	<p>
		<%
		out.print(resultado);
		%>
	</p>

</body>
</html>