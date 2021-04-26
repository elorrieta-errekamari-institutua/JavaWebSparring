
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/cabecera.jsp" />

	<ul class="topnav">
		<li><a class="active" href="index.jsp">Home</a></li>
		<li><a href="#news">News</a></li>
		<c:if test="${ usuarioLogeado != null }">
			<li class="right"><a href="#usuario">Nombre Avatar</a>
				<ul>
					<li><a href="#usuario">Datos de usuario</a></li>
					<li><a href="historial.jsp">Historial</a></li>
					<li><a href="logout">Salir</a></li>
				</ul>
			</li>
		</c:if>
		<c:if test="${ usuarioLogeado == null }">
			<li class="right"><a href="login.jsp">Entrar</a></li>
			<li class="right"><a href="registro.jsp">Registrate</a></li>
		</c:if>

		<li class="right"><a href="registro.jsp">Registrate</a></li>
	</ul>

	<h1 class="center">Portada</h1>
	<p style="color: orange">${usuarioLogeado}</p>
	<p class="center green">${mensaje}</p>
	<p class="center red">${nombre}</p>
	<button class="mdc-button foo-button">
  <div class="mdc-button__ripple"></div>
  <span class="mdc-button__label">Button</span>
</button>
</body>
</html>